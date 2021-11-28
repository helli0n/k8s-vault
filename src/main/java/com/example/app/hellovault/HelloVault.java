package main.com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class HelloVault {
    public static void main(String[] args) {
        SpringApplication.run(HelloVault.class, args);
    }
}
