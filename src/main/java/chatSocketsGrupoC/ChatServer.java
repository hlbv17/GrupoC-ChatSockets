package chatSocketsGrupoC;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
   Un servidor que ejecuta el ChatService.
   Puede aceptar m�ltiples conexiones de m�ltiples clientes.
*/
public class ChatServer
{  
   public static void main(String[] args ) throws IOException
   {  
      final int ROOM_SIZE = 10;
      ChatRoom chatRoom = new ChatRoom(ROOM_SIZE);
      final int PORT = 8888;
      ServerSocket server = new ServerSocket(PORT);
      System.out.println("Esperando que se conecten clientes...");
      
      while (true) {
         Socket s = server.accept();
         System.out.println("Nuevo cliente conectado: " + s.getInetAddress().getHostAddress());
         ChatService servicio = new ChatService(s, chatRoom);
         Thread hilo = new Thread(servicio);
         hilo.start();
      }
      
   }
}
