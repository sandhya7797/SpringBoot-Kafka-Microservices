package com.example.orderservice.kafka;

import com.example.basecommons.dto.OrderCreatedEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

//Producer should create message and send message to kafka broker to specific topic (order-created-topic here).

@Service
public class OrderEventProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderEventProducer.class);

    private NewTopic topic;

    private KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    public OrderEventProducer(NewTopic topic, KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(OrderCreatedEvent event) {
        LOGGER.info("Sending order created event: {}", event.toString());
        Message<OrderCreatedEvent> message = MessageBuilder.withPayload(event)
                .setHeader(KafkaHeaders.TOPIC,topic.name()).build();//message is like an envelope it contains event, topic,timestamp etc

        kafkaTemplate.send(message);
    }
}
