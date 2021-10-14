package com.eslam.chatbotspring.chat;

/**
 * WebSocket message model
 */
public class Message {
    // TODO: add message model.


    private String message;

    public Message() {
    }

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
