package id.my.hendisantika.kafkasample.controller;

import id.my.hendisantika.kafkasample.model.SuperHero;
import id.my.hendisantika.kafkasample.service.ProducerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Publish", description = "Endpoint for publishing message to Kafka")
public class KafkaController {

    private final ProducerService<SuperHero> producerService;

    @GetMapping(value = "/publish")
    @Operation(
            summary = "Publish Data as a string",
            description = "Publish Data as a string.",
            tags = {"Publish"})
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    description = "Success",
                    responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation =
                            String.class))
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(description = "Not found", responseCode = "404",
                    content = @Content),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(description = "Internal error", responseCode = "500"
                    , content = @Content)
    }
    )
    public String sendMessageToKafkaTopic(@RequestParam("message") String message) {
        producerService.sendMessage(message);
        return "Successfully publisher message..!";
    }

    @PostMapping(value = "/publish")
    @Operation(
            summary = "Publish Data as an Json object",
            description = "Publish Data as an Json object.",
            tags = {"Publish"})
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    description = "Success",
                    responseCode = "200",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation =
                            String.class))
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(description = "Not found", responseCode = "404",
                    content = @Content),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(description = "Internal error", responseCode = "500"
                    , content = @Content)
    }
    )
    public Map<String, Object> sendObjectToKafkaTopic(@RequestBody SuperHero superHero) {
        producerService.sendSuperHeroMessage(superHero);

        Map<String, Object> map = new HashMap<>();
        map.put("message", "Successfully publisher Super Hero..!");
        map.put("payload", superHero);

        return map;
    }
}
