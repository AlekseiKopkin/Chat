package Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {
    // экземпляр нашего сервера
    private Server server;
    // исходящее сообщение
    private PrintWriter outMessage;
    // входящее собщение
    private Scanner inMessage;

    // конструктор, который принимает клиентский сокет и сервер
    public ClientHandler(Socket socket) {
        try {
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
        while (true) {
            // Если от клиента пришло сообщение
            if (inMessage.hasNext()) {
                String clientMessage = inMessage.nextLine();
                System.out.println(clientMessage);
                sendMsg(clientMessage);
            }
        }
    }

    // отправляем сообщение
    private void sendMsg(String msg) {
        try {
            outMessage.println(msg);
            outMessage.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
