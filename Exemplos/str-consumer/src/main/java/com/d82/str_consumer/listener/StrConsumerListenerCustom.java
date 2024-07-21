
package com.d82.str_consumer.listener;

import com.d82.str_consumer.custom.StrConsumerCustomListerner;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;


//CLASSE SEM BOILERPLATE

@Log4j2
@Component
public class StrConsumerListenerCustom {

    @SneakyThrows
    @StrConsumerCustomListerner(groupId = "group-1")
    public void create(String message) {
        log.info("Custom: CREATE ::: Receive Message {}", message);
        throw new IllegalAccessException("Se liga aí! Deu erro!");

    }

    @StrConsumerCustomListerner(groupId = "group-1")
    public void log(String message) {
        log.info("Custom: LOG ::: Receive Message {}", message);
    }

    @KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "validMessageContainerFactory")
    public void history(String message) {
        log.info("Custom: HISTORY ::: Receive Message {}", message);
    }
}
