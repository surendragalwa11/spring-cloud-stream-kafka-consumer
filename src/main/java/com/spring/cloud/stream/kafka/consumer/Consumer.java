package com.spring.cloud.stream.kafka.consumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(Sink.class)
public class Consumer {

    @StreamListener(target = Sink.INPUT)
    public void printMessage(String message) {
        System.out.println(message);
    }
}
