package com.inspire12.likelionwebsocket.model;

import lombok.Builder;
import lombok.Getter;


@Builder
public class ChatMessage {

    public static ChatMessage createWelcomeMessage(String name) {
        return ChatMessage.builder()
                .sender("System")
                .content(
                        String.format("""
                                %s 님이 들어왔습니다.
                                """, name))
                .type(ChatMessage.MessageType.JOIN)
                .build();

    }

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }

    @Getter
    private MessageType type;
    @Getter
    private String content;
    @Getter
    private String sender;

}
