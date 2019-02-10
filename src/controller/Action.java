package controller;

import controller.File.CheckFile;
import controller.File.FileWrite;
import controller.File.ReadFile;
import view.Frame;
import view.PrintMessages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

public class Action {
    private static String name;
    // адрес сервера
    private static final String SERVER_HOST = "localhost";
    // порт
    private static final int SERVER_PORT = 3440;
    // клиентский сокет
    private Socket clientSocket;
    // входящее сообщение
    private Scanner inMessage;
    // исходящее сообщение
    private PrintWriter outMessage;

    public void ActionId() {
        PanelID.enterChat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!PanelID.chooseUserName.getText().equals("")) {
                    name = PanelID.chooseUserName.getText();
                    Frame.getFrameChat();
                    if(new CheckFile().ExistFile()) {
                        new ReadFile();
                    }
                } else {
                    new PrintMessages().NoName();
                }
            }
        });
    }

    public void ActionChat() {
        try {
            // подключаемся к серверу
            clientSocket = new Socket(SERVER_HOST, SERVER_PORT);
            inMessage = new Scanner(clientSocket.getInputStream());
            outMessage = new PrintWriter(clientSocket.getOutputStream());
        } catch (IOException e) {
             e.printStackTrace();
        }
        PanelChat.buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if ((!PanelChat.textField.getText().equals(name + ":")) && (!PanelChat.textField.getText().equals(""))) {
                    sendMsg(PanelChat.textField.getText());
                } else {
                    new PrintMessages().NoMessage();
                }
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // бесконечный цикл
                    while (true) {
                        // если есть входящее сообщение
                        if (inMessage.hasNext()) {
                            // считываем его
                            String inMes = inMessage.nextLine();
                            new CheckFile().ExistFile();
                            if(new CheckFile().CheckingEmptinessFile()==1) {
                                PanelChat.textArea.setText(PanelChat.textArea.getText() + "\n" + inMes);
                            }
                            else
                            {
                                PanelChat.textArea.setText(inMes);
                            }

                            new FileWrite();
                            PanelChat.textField.setText(name + ":");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        // добавляем обработчик события закрытия окна клиентского приложения
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    outMessage.flush();
                    outMessage.close();
                    inMessage.close();
                    clientSocket.close();
                } catch (IOException exc) {
                    exc.printStackTrace();
                }
            }
        });
    }

    private void sendMsg(String msg) {
        // формируем сообщение для отправки на сервер
        // отправляем сообщение
        outMessage.println(msg);
        outMessage.flush();
    }
}