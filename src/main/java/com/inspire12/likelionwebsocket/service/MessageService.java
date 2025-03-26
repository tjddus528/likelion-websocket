package com.inspire12.likelionwebsocket.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inspire12.likelionwebsocket.holder.WebsocketSessionHolder;
import com.inspire12.likelionwebsocket.model.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@Slf4j
@Service
public class MessageService {

    private final ObjectMapper objectMapper;

    public MessageService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    public ChatMessage createWelcomeMessage(ChatMessage chatMessage) {
        return ChatMessage.createWelcomeMessage(chatMessage.getSender());
    }

    public ChatMessage systemMessage(ChatMessage chatMessage) {
        try {
            log.info("Message Service");

            TextMessage messageToSend = new TextMessage(objectMapper.writeValueAsBytes(chatMessage));
            for (WebSocketSession webSocketSession : WebsocketSessionHolder.getSession()) {
                System.out.println(webSocketSession.isOpen());
                webSocketSession.sendMessage(messageToSend);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return chatMessage;

    }
}
