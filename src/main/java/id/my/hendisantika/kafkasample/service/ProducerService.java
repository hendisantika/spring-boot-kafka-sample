package id.my.hendisantika.kafkasample.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kafka-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/12/24
 * Time: 17:09
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ProducerService<T> {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTemplate<String, T> kafkaTemplateSuperHero;
    @Value("${spring.kafka.topic}")
    private String topic;
    @Value("${spring.kafka.superhero-topic}")
    private String superHeroTopic;
}
