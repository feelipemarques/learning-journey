package com.felipe.consumer.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ConsumeService {

    @Autowired
    MailSenderService mailSenderService;

    @RabbitListener(queues = "${rabbitmq.queuename}")
    public void receiveMessage(Message message){
        String corpo = new String(message.getBody());
        if(corpo.contains("ALERT")){
            mailSenderService.sendEmail(corpo, "feelipemarquees@gmail.com");
        }else{
            System.out.println("...");
        }

    }

}
