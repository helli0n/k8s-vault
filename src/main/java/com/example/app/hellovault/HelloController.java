package main.com.example.app;

import java.util.concurrent.TimeUnit;
import java.util.Properties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Value;

@RestController
public class HelloController {
    private static long start = System.currentTimeMillis();

    @Value("${vault.secret.user}")
    private String VaultSecretUser;
    @Value("${vault.secret.password}")
    private String VaultSecretPassword;
    @Value("${vault.secret.othersecret}")
    private String VaultSecretOthersecret;
    @Value("${configmap.property}")
    private String ConfigmapProperty;
    @GetMapping("/")
    public String sayHello() {
        long millis = System.currentTimeMillis() - start;
        String uptime = String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(millis),
                TimeUnit.MILLISECONDS.toSeconds(millis) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));

        return String.format("Hello, Vault! (up %s, vault.secret.user: %s, vault.secret.password: %s, vault.secret.othersecret: %s, configmap.property: %s)", uptime, VaultSecretUser, VaultSecretPassword, VaultSecretOthersecret, ConfigmapProperty);
    }

}