package id.my.hendisantika.kafkasample.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kafka-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/12/24
 * Time: 17:10
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Service
public class ConsumerService {
    @KafkaListener(topics = {"${spring.kafka.topic}"}, containerFactory = "kafkaListenerStringFactory", groupId = "group_id")
    public void consumeMessage(String message) {
        log.info("**** -> Consumed message -> {}", message);
    }
}
