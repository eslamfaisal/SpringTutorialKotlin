package edu.udacity.java.nano.chat;

/**
 * WebSocket message model
 */
public class Message {
    private String username;
    private String msg;
    private long onlineCount;
    private String type;

    public Message(String username, String msg, long onlineCount, String type) {
        this.username = username;
        this.msg = msg;
        this.onlineCount = onlineCount;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getOnlineCount() {
        return onlineCount;
    }

    void setOnlineCount(long onlineCount) {
        this.onlineCount = onlineCount;
    }

    public String getType() {
        return type;
    }

    void setType(String type) {
        this.type = type;
    }
}
