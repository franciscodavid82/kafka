package com.david.str_producer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){
        kafkaTemplate.send("str-topic", message).whenComplete((result, e) -> {
            if (e != null)
                log.error("Mensagem não enviada: {}", e.getMessage());
            else {
                log.info("Mensagem enviada com sucesso: {}", result.getRecordMetadata());
                log.info("Partition: {}, offset: {}",
                        result.getRecordMetadata().partition(), result.getRecordMetadata().offset());
            }
        });
    }
}
