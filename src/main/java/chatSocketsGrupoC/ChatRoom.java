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
import java.util.concurrent.ConcurrentHashMap;

/**
 * Un chat room el cual consiste de m�ltiples chatters.
 */
public class ChatRoom {

    int capacity;
    private MessageSocketServer messageSocketServer;
    private ConcurrentHashMap<String, ChatService> chatterConcurrentHashMap;

    /**
     * Construye un chat room con una capacidad determinada.
     */
    public ChatRoom(MessageSocketServer messageSocketServer) {
        this.messageSocketServer = messageSocketServer;
        chatterConcurrentHashMap = new ConcurrentHashMap<>();
    }

    /**
     * Registrar un chatter en el cuarto.
     *
     * @param aName el nombre a registrar
     */
    public void register(String aName, ChatService chatService) {
        chatterConcurrentHashMap.put(aName.toLowerCase(), chatService);
        messageSocketServer.onJoin(aName);
    }

    /**
     * De-registrar un chatter del room.
     *
     * @param aName el nombre a de-registrar
     */
    public synchronized void leave(String aName) {
        messageSocketServer.onLeave(aName);
        chatterConcurrentHashMap.remove(aName.toLowerCase());
    }

    /**
     * Enviar un mensaje a todos en este chat room.
     *
     * @param requestor   el nombre de quien env�a el mensaje
     * @param msg         el mensaje a enviar
     * @param chatService el lugar de donde se escribe el mensaje (el servicio asociado al cliente que envi� el mensaje)
     */
    public void broadcast(String requestor, String msg, ChatService chatService) {
        for (ChatService o : chatterConcurrentHashMap.values()) {
            if (o != chatService && o.getUserName() != null) {
                o.putMessage(requestor + ": " + msg);
            }
        }
    }

    public void sendLog(String message) {
        messageSocketServer.log(message);
    }

    public void kickChatter(String name) {
        ChatService chatService = chatterConcurrentHashMap.get(name.toLowerCase());
        if (chatService != null) {
            try {
                chatService.getSocket().close();
                leave(name);
            } catch (Throwable e) {
                e.printStackTrace();
            }

        }
    }

}