package com.liqihua.config;

import org.springframework.web.socket.WebSocketSession;

import java.util.LinkedList;
import java.util.List;

/**
 * @author liqihua
 * @since 2018/5/27
 */
public class WebSocketPool {
    public static List<WebSocketSession> list = new LinkedList<>();
}
