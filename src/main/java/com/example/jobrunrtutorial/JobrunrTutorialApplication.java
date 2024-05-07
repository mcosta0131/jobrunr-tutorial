package com.example.jobrunrtutorial;

import com.example.jobrunrtutorial.service.EmailService;
import com.example.jobrunrtutorial.service.SampleService;
import jakarta.annotation.PostConstruct;
import org.jobrunr.jobs.JobId;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.scheduling.cron.Cron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.time.LocalDateTime;

@SpringBootApplication
public class JobrunrTutorialApplication {

    @Autowired
    private JobScheduler jobScheduler;

    @Autowired
    private SampleService sampleService;

    @Autowired
    private EmailService emailService;

    public static void main(String[] args) {

        SpringApplication.run(JobrunrTutorialApplication.class, args);
    }

    @PostConstruct
    public void init() {

        jobScheduler.
                scheduleRecurrently(Duration.ofMillis(10000),
                        () -> sampleService.executeSampleJob("Mateus"));


        jobScheduler.enqueue(() -> sampleService.executeSampleJob("mundo"));


        jobScheduler.schedule(LocalDateTime.of(2024, 5, 10, 0, 0, 0),
                () -> emailService.sendEmail("teste@teste.com", "assunto", "Olá, tudo bem ??"));
    }
}
