package com.yar05.auth_demo.service;

import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Async
    public void sendSimpleMail(String to, String token) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setTo(to);
            message.setFrom("youneselalaouielrhoul2005@gmail.com");
            message.setSubject("Confirm your email");
            String body = """

                    Please use the following link to verify your email:

                    http://localhost:8080/register/confirmToken?token=%s
                    """.formatted(token);
            message.setText(body);
            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalIdentifierException("Failed to send email");
        }
    }
}
