package Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {
    // исходящее сообщение
    private PrintWriter outMessage;
    // входящее собщение
    private Scanner inMessage;
    private static final String HOST = "localhost";
    private static final int PORT = 3444;
    // клиентский сокет
    private Socket clientSocket = null;
    double r = 0;
    String s="";
    // конструктор, который принимает клиентский сокет и сервер
    public ClientHandler(Socket socket) {
        try {
            this.clientSocket = socket;
            this.outMessage = new PrintWriter(socket.getOutputStream());
            this.inMessage = new Scanner(socket.getInputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    // Переопределяем метод run(), который вызывается когда
    // мы вызываем new Thread(client).start();
    @Override
    public void run() {
        try {
            while (true) {
                // Если от клиента пришло сообщение
                if (inMessage.hasNext()) {
                    String clientMessage = inMessage.nextLine();
                        System.out.print("messeger ok");
                         if (1==1) {
                            sendMsg(clientMessage);
                        }
                    }
                }
            }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    // отправляем сообщение
    public void sendMsg(String msg) {
        try {
            outMessage.println(msg);
            outMessage.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
