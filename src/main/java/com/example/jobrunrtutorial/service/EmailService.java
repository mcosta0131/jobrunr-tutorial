package com.example.jobrunrtutorial.service;

import org.jobrunr.jobs.annotations.Job;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Job(name = "Envia email para fornecedor", retries = 10)
    public void sendEmail(String to, String subject, String body) {
        System.out.println("Envia email para fornecedor");
    }
}
