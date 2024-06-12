package id.my.hendisantika.kafkasample.controller;

import id.my.hendisantika.kafkasample.model.SuperHero;
import id.my.hendisantika.kafkasample.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kafka-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/12/24
 * Time: 17:12
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping(value = "/kafka")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class KafkaController {

    private final ProducerService<SuperHero> producerService;
}
