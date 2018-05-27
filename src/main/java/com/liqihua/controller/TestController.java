package com.liqihua.controller;

import com.liqihua.config.WebSocketPool;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;

import java.io.IOException;

/**
 * @author liqihua
 * @since 2018/5/27
 */
@RestController
@RequestMapping("/testController")
public class TestController {

    /**
     * 给html端发送消息
     * @return
     */
    @RequestMapping("/sendToHTML")
    public String sendToHTML(){
        WebSocketPool.list.forEach(s -> {
            try {
                s.sendMessage(new TextMessage("hey "+System.currentTimeMillis()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return "ok";
    }
}
