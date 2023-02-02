package chatSocketsGrupoC;

import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
   Programa cliente del chat.
*/
public class ChatClient
{
   public static void main(String[] args)
         throws IOException
   {
      final int PORT = 8888;
      final String HOST = "localhost";
      
      System.out.println("Bienvenido al chat room!\n");
      System.out.println("Por favor entre su comando.");
      System.out.println("USO:  LOGIN usuario_o_nick");
      System.out.println("      CHAT mensaje");
      System.out.println("      LOGOUT");
      System.out.println("Presione ENTER para enviar su mensaje.\n");

      Socket s = new Socket(HOST, PORT);
      InputStream inStream = s.getInputStream();
      OutputStream outStream = s.getOutputStream();
      final BufferedReader in = new BufferedReader(new InputStreamReader(inStream));
      PrintWriter out = new PrintWriter(outStream);
      BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

      final Flag done = new Flag(false);
      
      class OutputRunnable implements Runnable
      {
         public void run()
         {
            try
            {
               while (!done.getFlag())
               {
                  String response = in.readLine();
                  System.out.println(response);
                  if (response.equals("Adios!"))
                     done.setFlag(true);
               }
            }
            catch (IOException e){}
         }
      }
      
      OutputRunnable or = new OutputRunnable();
      Thread t = new Thread(or);
      t.start();
      
      while (!done.getFlag())
      {  
         String line = console.readLine();
         out.println(line);
         out.flush();
      }
      s.close();
   }
}