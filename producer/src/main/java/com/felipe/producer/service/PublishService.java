package com.felipe.producer.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void publishMessage(String message, String queue){
        rabbitTemplate.convertAndSend("", queue, message);
        System.out.println(message);
    }
}
