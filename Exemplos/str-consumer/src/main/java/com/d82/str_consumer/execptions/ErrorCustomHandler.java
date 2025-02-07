package com.d82.str_consumer.execptions;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
@Log4j2
@Component
public class ErrorCustomHandler implements KafkaListenerErrorHandler {
    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
        log.info("EXCEPTION HANDLER ::: Capturei um erro!");
        log.info("Payload ::: {}}", message.getPayload());
        log.info("Offset ::: {}}", message.getHeaders().get("kafka_offset"));
        log.info("Message exception ::: {}}", exception.getMessage());

        return null;
    }
}
