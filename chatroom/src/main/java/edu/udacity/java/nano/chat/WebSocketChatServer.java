package edu.udacity.java.nano.chat;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
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
    private static final String ENTER = "ENTER";
    private static final String CHAT = "CHAT";
    private static final String LEAVE = "LEAVE";

    /**
     * All chat sessions.
     * Multiple Sessions are associated with a single user to account for the case where a user logs in to a chat room on multiple tabs
     */
    private static Map<String, Set<Session>> onlineSessions = new ConcurrentHashMap<>();

    private static void sendMessageToAll(Message message) {
        Set<Map.Entry<String, Set<Session>>> sessionEntries = onlineSessions.entrySet();
        for (Map.Entry<String, Set<Session>> entry : sessionEntries) {
            try {
                Set<Session> sessions = entry.getValue();
                for (Session session : sessions) {
                    session.getBasicRemote().sendText(JSON.toJSONString(message));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Open connection, 1) add session, 2) add user.
     */
    @OnOpen
    public void onOpen(Session session,  @PathParam("username") String username) {
        Set<Session> sessions = onlineSessions.getOrDefault(username, new HashSet<>());
        if (!onlineSessions.containsKey(username)) {
            sessions.add(session);
            onlineSessions.put(username, sessions);
            sendMessageToAll(new Message(username, " joined the chat room.", onlineSessions.size(), ENTER));
        } else {
            boolean isPresent = sessions.stream().anyMatch((s) -> s.getId().equals(session.getId()));
            if (!isPresent) {
                sessions.add(session);
                onlineSessions.put(username, sessions);
            }
            updateOnlineUsersCount(session);
        }
    }

    /**
     * Send message, 1) get username and session, 2) send message to all.
     */
    @OnMessage
    public void onMessage(Session session, String jsonMessage) {
        Message message = JSON.parseObject(jsonMessage, Message.class);
        message.setOnlineCount(onlineSessions.size());
        message.setType(CHAT);
        sendMessageToAll(message);
    }

    /**
     * Close connection, 1) remove session, 2) update user.
     */
    @OnClose
    public void onClose(Session session, @PathParam("username") String username) throws IOException {
        if (onlineSessions.containsKey(username)) {
            boolean wasLastSession = removeOnlineSession(session, username);
            session.close();
            if (wasLastSession) {
                sendMessageToAll(new Message(username, " left the chat room.", onlineSessions.size(), LEAVE));
            }
        }
    }

    /**
     * Print exception.
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    private boolean removeOnlineSession(Session session, @PathParam("username") String username) {
        Set<Session> sessions = onlineSessions.get(username);
        sessions.remove(session);
        if (sessions.isEmpty()) {
            onlineSessions.remove(username);
            return true;
        }

        onlineSessions.put(username, sessions);
        return false;
    }

    private void updateOnlineUsersCount(Session session) {
        try {
            Message dummyMessage = new Message("", "", onlineSessions.size(), ENTER);
            session.getBasicRemote().sendText(JSON.toJSONString(dummyMessage));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
