package com.example.jobrunrtutorial.controller;

import com.example.jobrunrtutorial.service.CsvService;
import org.jobrunr.scheduling.JobScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
public class CsvController {

    @Autowired
    private JobScheduler jobScheduler;

    @Autowired
    private CsvService csvService;

    @GetMapping("/upload")
    public void upload(MultipartFile file) {
        // Armazenar esse csv no banco

        // Agendar a leitura e o envio desses dados
        jobScheduler.schedule(LocalDateTime.of(
                LocalDate.now().getYear(),
                LocalDate.now().getMonth(),
                LocalDate.now().getDayOfMonth() + 1,
                LocalDateTime.now().getHour(),
                LocalDateTime.now().getMinute(),
                LocalDateTime.now().getSecond()), () -> csvService.sendCsvData());

    }
}
