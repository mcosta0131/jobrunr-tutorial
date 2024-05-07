package com.example.jobrunrtutorial.service;

import lombok.extern.slf4j.Slf4j;
import org.jobrunr.jobs.annotations.Job;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
@Slf4j
public class SampleService {


    public static final long EXECUTION_TIME = 2000L;

    private AtomicInteger count = new AtomicInteger();

    @Job(name = "Método de exemplo jobrunr", retries = 2)
    public void executeSampleJob(String variable) {

        log.info("Olá {}", variable);
        try {
            Thread.sleep(EXECUTION_TIME);
        } catch (InterruptedException e) {
            log.error("Erro: ", e);
        } finally {
            count.incrementAndGet();
            log.info("Finalizado método de exemplo");
        }
    }


    public int getNumberOfInvocations() {
        return count.get();
    }
}
