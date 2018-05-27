package com.liqihua.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author liqihua
 * @since 2018/5/27
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Bean
    public WebSocketHandler pcHandler(){
        return new WebSocketHandler();
    }


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //var ws = new WebSocket("ws://localhost:9002/socket-server1");
        registry.addHandler(pcHandler(),"/socket-server1");
    }
}
