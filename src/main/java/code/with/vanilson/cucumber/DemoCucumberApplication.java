package code.with.vanilson.cucumber;

import code.with.vanilson.cucumber.space.SpaceShipDefaultProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableConfigurationProperties(value = {SpaceShipDefaultProperties.class})
public class DemoCucumberApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoCucumberApplication.class, args);
    }

}
