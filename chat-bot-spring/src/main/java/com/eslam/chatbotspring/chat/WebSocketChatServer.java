package com.eslam.chatbotspring.chat;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * WebSocket Server
 *
 * @see ServerEndpoint WebSocket Client
 * @see Session   WebSocket Session
 */

@Component
@ServerEndpoint("/chat/{username}")
public class WebSocketChatServer {

    /**
     * All chat sessions.
     */
    private static final Map<String, Session> onlineSessions = new ConcurrentHashMap<>();

    private static void sendMessageToAll(String msg) {
        //TODO: add send message method.
    }

    /**
     * Open connection, 1) add session, 2) add user.
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) {
        System.out.println(username);
        //TODO: add on open connection.
        onlineSessions.put(session.getId(), session);
        System.out.println("there is a new session opened and its fucken id is = " + session.getId());

        try {
            session.getBasicRemote().sendText(new Gson().toJson(new Message("welcome " + username)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Send message, 1) get username and session, 2) send message to all.
     */
    @OnMessage
    public void onMessage(Session session, String jsonStr) {
        System.out.println("onMessage id= "+session.getId());
        Message message = new Gson().fromJson(jsonStr, Message.class);
        System.out.println("onMessage content= "+message.getMsg());
        //TODO: add send message.
    }

    /**
     * Close connection, 1) remove session, 2) update user.
     */
    @OnClose
    public void onClose(Session session) {
        //TODO: add close connection.
        System.out.println("onClose id= "+session.getId());
    }

    /**
     * Print exception.
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println(error.getMessage());
        error.printStackTrace();
    }

}
