package com.aki.sorting.webSocket;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/sortingWS")
@Component
public class sortingWebSocket {
    private Session WSSession;
    private static CopyOnWriteArraySet<sortingWebSocket> sortingWebSockets = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session){
        WSSession = session;
        sortingWebSockets.add(this);
        System.out.println("连接开启");
    }
    @OnClose
    public void OnClose(){
        System.out.println("连接关闭");
    }

    @OnMessage
    public void onMessage(String msg){
        System.out.println(new StringBuffer().append("收到客户端消息:").append(msg) );
        sendMsg(new StringBuffer().append("客户端告诉你,你发的消息是:").append(msg).toString());
    }

    @OnError
    public void OnError(Throwable error){
        System.out.println("连接开启");
        error.printStackTrace();
    }

    private void sendMsg(String msg){
        try {
            WSSession.getBasicRemote().sendText(msg);
        } catch (IOException e) {
            System.out.println("发送异常");
            e.printStackTrace();
        }
    }

    private void allSendMsg(String msg){
        for(sortingWebSocket sortingWebSocket : sortingWebSockets){
            sortingWebSocket.sendMsg(msg);
        }
    }
}
