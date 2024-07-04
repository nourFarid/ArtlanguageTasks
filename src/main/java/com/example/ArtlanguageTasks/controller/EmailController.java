package com.example.ArtlanguageTasks.controller;

import com.example.ArtlanguageTasks.DTO.EmailRequest;
import com.example.ArtlanguageTasks.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmailController {
    @Autowired
    private SendEmailService sendEmailService;
    @GetMapping("/sendEmail")
    public String sendEmail(){
        sendEmailService.sendEmail("norfared13@gmail.com", "test subject","test body");
        return "SENT SUCCESSFULLY";
    }
    @PostMapping("/sentDynamic")
    public String sendEmailWithParams(@RequestBody EmailRequest emailRequest){
        sendEmailService.sendEmail(emailRequest.getTo(),emailRequest.getSubject(),emailRequest.getBody());
        return "SENT SUCCESSFULLY";
    }
    
}
