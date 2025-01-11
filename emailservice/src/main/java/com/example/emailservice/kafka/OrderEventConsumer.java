package com.example.emailservice.kafka;

import com.example.basecommons.dto.OrderCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderEventConsumer {

    @KafkaListener(topics = "${spring.kafka.template.default-topic}",
    groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderCreatedEvent orderEvent) {
        //process the even info or save into database.
        System.out.println("order event consumed by email service - " + orderEvent.toString());
    }


}
