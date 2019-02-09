package Client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    // порт, который будет прослушивать наш сервер
    static final int PORT = 3440;

    public Server() {
        try {
            Socket clientSocket;
            ServerSocket serverSocket;
            serverSocket = new ServerSocket(PORT);
            while (true) {
                // таким образом ждём подключений от сервера
                clientSocket = serverSocket.accept();
                // создаём обработчик клиента, который подключился к серверу
                // this - это наш сервер
                ClientHandler client = new ClientHandler(clientSocket);
                //clients.add(client);
                // каждое подключение клиента обрабатываем в новом потоке
                new Thread(client).start();
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}