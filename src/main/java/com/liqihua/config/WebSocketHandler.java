package com.liqihua.config;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * @author liqihua
 * @since 2018/5/27
 */

public class WebSocketHandler extends TextWebSocketHandler {


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("--- afterConnectionEstablished");
        session.sendMessage(new TextMessage("Established"));
        /**
         * 建立连接后把session放进一个list以便后面给html端发消息
         */
        WebSocketPool.list.add(session);
        super.afterConnectionEstablished(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("--- handleTextMessage "+message.getPayload());
        super.handleTextMessage(session, message);
    }


    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("--- afterConnectionClosed");
        WebSocketPool.list.remove(session);
        super.afterConnectionClosed(session, status);
    }
}
