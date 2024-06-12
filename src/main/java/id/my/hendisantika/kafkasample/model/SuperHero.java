package id.my.hendisantika.kafkasample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kafka-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/12/24
 * Time: 17:01
 * To change this template use File | Settings | File Templates.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuperHero implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String superName;
    private String profession;
    private int age;
    private boolean canFly;
}
