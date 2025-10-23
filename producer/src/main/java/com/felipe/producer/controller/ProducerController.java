package com.felipe.producer.controller;


import com.felipe.producer.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Value("${rabbitmq.queuename}")
    public String queueName;

    @Autowired
    PublishService publishService;

    @PostMapping("/publish/text")
    public void publishText(@RequestBody String text){
        publishService.publishMessage(text, queueName);
        System.out.println("Iniciei a publicação...");
    }
}
