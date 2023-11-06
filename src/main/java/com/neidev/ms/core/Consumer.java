package com.neidev.ms.core;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = "topic", groupId = "group-1")
    public void receiveMessage(String message) {
        System.out.println("Consumer message: " + message);
    }
}
