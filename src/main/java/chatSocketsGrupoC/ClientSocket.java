package chatSocketsGrupoC;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ClientSocket {
    private final int PORT = 8888;
    private final String HOST = "localhost";
    private Socket socket;
    private PrintWriter out;
    BufferedReader reader;
    ExecutorService service = Executors.newFixedThreadPool(2);
    private MessageSocketClient onReceivedMessage;
    private Future<?> taskListenerMessage;
    private boolean isClosedClient = true;

    public void connect() throws Exception {
        socket = new Socket(HOST, PORT);
        InputStream inStream = socket.getInputStream();
        OutputStream outStream = socket.getOutputStream();
        reader = new BufferedReader(new InputStreamReader(inStream));
        out = new PrintWriter(outStream);
        isClosedClient = false;
        taskListenerMessage = service.submit(() -> {
            while (!socket.isClosed() && !isClosedClient) {
                try {
                    String response = reader.readLine();
                    System.out.println(response);
                    if (response == null){
                        disconnect();
                        break;
                    }
                    if (onReceivedMessage != null) {
                        onReceivedMessage.onMessage(response);
                    }
                    if (response.equals("Adios!")) {
                        disconnect();
                    }
                } catch (Throwable err) {
                    if (err instanceof SocketException) {
                        String error = err.getMessage();
                        if (error.equalsIgnoreCase("Connection reset")) {
                            isClosedClient = true;
                            if (onReceivedMessage != null) {
                                onReceivedMessage.onServerClosed();
                            }
                            break;
                        }
                        if (error.equalsIgnoreCase("Socket closed")) {
                            isClosedClient = true;
                            if (onReceivedMessage != null) {
                                onReceivedMessage.onLogout();
                            }
                            break;
                        }
                    }
                    err.printStackTrace();
                }
            }
        });
    }

    public void registerOnMessage(MessageSocketClient registerCallback) {
        this.onReceivedMessage = registerCallback;
    }

    public void disconnect() throws Exception {
        if (socket == null || socket.isClosed()) {
            throw new Error("El socket ya se encuentra cerrado");
        }
        socket.close();
        taskListenerMessage.cancel(true);
        if (onReceivedMessage != null) {
            onReceivedMessage.onLogout();
        }
    }

    public void sendMessageRoom(String message) {
        if (socket == null || socket.isClosed()) {
            throw new Error("El servidor está cerrado y no se puede enviar el mensaje");
        }
        out.println(message);
        out.flush();
    }
}
