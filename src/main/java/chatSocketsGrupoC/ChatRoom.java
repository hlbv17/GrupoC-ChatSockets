package chatSocketsGrupoC;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.io.PrintWriter;
import java.util.Collections;

/**
   Un chat room el cual consiste de m�ltiples chatters.
*/
public class ChatRoom
{
   /**
      Construye un chat room con una capacidad determinada.
      @param aCapacity la capacidad del cuarto
   */
   public ChatRoom(int aCapacity)
   {
      capacity = aCapacity;
      chatterHash = Collections.synchronizedMap(new HashMap(capacity));
      activeService = Collections.synchronizedList(new ArrayList(capacity));
   }

   /**
      Registrar un chatter en el cuarto.
      @param aName el nombre a registrar
   */
   public void register(String aName)
   {
      chatterHash.put(aName, new Chatter(aName));
   }

   /**
      De-registrar un chatter del cuarto.
      @param aName el nombre a de-registrar
      @param service el nombre del servicio que se est� de-registrando
   */
   public synchronized void leave(String aName, ChatService service)
   {
      chatterHash.remove(aName);
      activeService.remove(activeService.indexOf(service));
   }

   public void add(ChatService cs)
   {
      activeService.add(cs);
   }

   /**
      Enviar un mensaje a todos en este chat room.
      @param requestor el nombre de quien env�a el mensaje
      @param msg el mensaje a enviar
      @param chatService el lugar de donde se escribe el mensaje (el servicio asociado al cliente que envi� el mensaje)
   */ 
   public synchronized void broadcast(String requestor, String msg, ChatService chatService)
   {
      for (int i = 0; i < activeService.size(); i++)     
      {
         ChatService cs = (ChatService) activeService.get(i);
         if (cs != chatService && cs.getUserName() != null) 
         {
            cs.putMessage(requestor + ": " + msg); 
         }
      }
   }

   private List activeService;
   int capacity;
   private Map chatterHash;
}