package id.my.hendisantika.kafkasample.controller;

import id.my.hendisantika.kafkasample.model.SuperHero;
import id.my.hendisantika.kafkasample.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

    @GetMapping(value = "/publish")
    public String sendMessageToKafkaTopic(@RequestParam("message") String message) {
        producerService.sendMessage(message);
        return "Successfully publisher message..!";
    }

    @PostMapping(value = "/publish")
    public Map<String, Object> sendObjectToKafkaTopic(@RequestBody SuperHero superHero) {
        producerService.sendSuperHeroMessage(superHero);

        Map<String, Object> map = new HashMap<>();
        map.put("message", "Successfully publisher Super Hero..!");
        map.put("payload", superHero);

        return map;
    }
}
