package com.felipe.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String conteudo, String destinatario){
        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom("xxxxx@gmail.com");
        email.setTo(destinatario);
        email.setSubject("Alerta!");
        email.setText(conteudo);

        javaMailSender.send(email);
        System.out.println("E-mail enviado!");
    }

}
