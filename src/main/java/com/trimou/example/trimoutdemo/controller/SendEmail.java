package com.trimou.example.trimoutdemo.controller;

import com.trimou.example.trimoutdemo.request.EmailRequest;
import com.trimou.example.trimoutdemo.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendEmail {

    @Autowired
    private SendMailService sendEmailService;

    @PostMapping("send-email")
    public ResponseEntity sendEmail(@RequestBody EmailRequest emailRequest) {
        sendEmailService.sendEmail(emailRequest);
        return ResponseEntity.ok().build();
    }
}
