package com.example.jobrunrtutorial.service;

import org.jobrunr.jobs.annotations.Job;
import org.springframework.stereotype.Service;

@Service
public class CsvService {

    @Job(name = "Envia os dados do csv para api de fornecedor")
    public void sendCsvData(){
        // Pegar os dados do csv do banco e enviar para uma api
        System.out.println("Enviando dados para api");
    }
}
