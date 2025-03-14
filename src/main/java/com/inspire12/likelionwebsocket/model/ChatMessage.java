package com.inspire12.likelionwebsocket.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ChatMessage {

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }

    private MessageType type;
    private String content;
    private String sender;

    // 기본 생성자
    public ChatMessage() {}

    // getter & setter
    public MessageType getType() {
        return type;
    }
    public void setType(MessageType type) {
        this.type = type;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
}
