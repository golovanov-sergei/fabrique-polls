package studio.fabrique.polls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class FabriquePollsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FabriquePollsApplication.class, args);
    }

}
