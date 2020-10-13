package ioc;

import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class MailService {
    public void sendLogin(String name){
        System.out.printf("Welcome %s, you are logged at %s%n", name,
                          ZonedDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
        );
    }
}
