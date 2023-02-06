package chatSocketsGrupoC;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketServer {
    final int PORT = 8888;

    private ServerSocket server;
    private ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public void openServer(ChatRoom chatRoom) throws IOException {

        server = new ServerSocket(PORT);
        service.submit(() -> {
            while (true) {
                System.out.println("Esperando alguna respuesta");
                Socket s = server.accept();
                ChatService servicio = new ChatService(s, chatRoom);
                service.submit(servicio);
            }
        });
    }




}
