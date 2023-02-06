package chatSocketsGrupoC;

import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
 * Ejecuta los comandos de un protocolo de chat room
 * simple recibidos de un socket.
 */
public class ChatService implements Runnable {

    private String userName;
    private Socket socket;
    private ChatRoom chatRoom;
    private PrintWriter out;
    private BufferedReader in;
    private boolean loggedIn;

    /**
     * Construye un objeto del servicio que procesa comandos
     * de un socket para un chat room.
     *
     * @param aSocket   el socket
     * @param aChatRoom el chat room
     */
    public ChatService(Socket aSocket, ChatRoom aChatRoom) {
        socket = aSocket;
        chatRoom = aChatRoom;
        loggedIn = false;
    }

    public Socket getSocket() {
        return socket;
    }

    /**
     * Ejecuta los comandos hasta recibir un LOGOUT o el fin de
     * los datos de entrada.
     */
    @Override
    public void run() {
        try {
            InputStream inStream = socket.getInputStream();
            OutputStream outStream = socket.getOutputStream();
            in = new BufferedReader(new InputStreamReader(inStream));
            out = new PrintWriter(outStream);
            try {
                while (!socket.isClosed() && socket.isConnected()) {
                    String line = in.readLine();
                    int commandDelimiterPos = line.indexOf(' ');
                    if (commandDelimiterPos < 0)
                        commandDelimiterPos = line.length();
                    String command = line.substring(0, commandDelimiterPos);
                    line = line.substring(commandDelimiterPos);

                    String response = executeCommand(command, line);
                    putMessage(response);
                }
                chatRoom.sendLog(userName + " se ha desconectado");
                chatRoom.leave(userName);
            } catch (Throwable throwable) {
                chatRoom.sendLog(userName + " se ha desconectado");
                chatRoom.leave(userName);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Env�a el mensaje a trav�s del socket.
     *
     * @param msg el mensaje a ser enviado
     */
    public void putMessage(String msg) {
        if (out != null) {
            out.println(msg);
            out.flush();
        }
    }

    /**
     * Ejecuta un comando.
     *
     * @param command el comando
     * @param line    el resto de la linea del comando
     * @return la respuesta a ser enviada al cliente
     */
    public String executeCommand(String command, String line) throws IOException {
        if (command.equals("LOGIN")) {
            userName = line;
            chatRoom.register(userName, this);
            chatRoom.broadcast(userName, "se ha unido", this);
            chatRoom.sendLog(userName + " se ha conectado.");
            loggedIn = true;
            return "Admin: Hola, " + userName + ". Bienvenido";
        } else if (!loggedIn) {
            return "Administrador del chat room: Usted debe hacer LOGIN primero";
        } else if (command.equals("CHAT")) {
            chatRoom.broadcast(userName, line, this);
            return userName + ": " + line;
        } else if (!command.equals("LOGOUT")) {

            return "Administrador del chat room: Comando inválido";
        }
        chatRoom.sendLog(userName + " se ha desconectado");
        chatRoom.broadcast(userName, "LOGOUT", this);
        chatRoom.leave(userName);
        return "Adios!";
    }

    /**
     * Retorna el nombre del usuario de este servicio.
     *
     * @return el nombre del usuario de este servicio
     */
    public String getUserName() {
        return userName;
    }


}
