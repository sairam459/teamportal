package com.src.teamportal.application.controller.message;

import com.src.teamportal.application.model.Message;
import com.src.teamportal.application.model.OutputMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageController {

    private final SimpMessagingTemplate template;

    @Autowired
    MessageController(SimpMessagingTemplate template){
        this.template = template;
    }

    @MessageMapping("/send/message")
    public void onReceivedMesage(String message){
        this.template.convertAndSend("/chat",  new SimpleDateFormat("HH:mm:ss").format(new Date())+"- "+message);
    }
}
