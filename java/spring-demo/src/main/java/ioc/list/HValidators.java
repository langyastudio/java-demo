package ioc.list;

import com.sun.jdi.CharType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class HValidators {
    @Value("classpath:/app.properties")
    Resource resource;

    @Autowired
    List<HValidator> validators;

    @Autowired(required = false)
    ZoneId zoneId = ZoneId.systemDefault();

    public void validate(String email, String name) {
        for (var validator : this.validators) {
            validator.validate(email, name);
        }
    }

    @PostConstruct
    public void init() {
        System.out.println("init HValidator");

        try (var reader = new BufferedReader(
                new InputStreamReader(this.resource.getInputStream(), StandardCharsets.UTF_8))) {
            String logo = reader.lines().collect(Collectors.joining("\n"));
            System.out.println(logo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void shutdown() {
        System.out.println("shutdown HValidator");
    }
}
