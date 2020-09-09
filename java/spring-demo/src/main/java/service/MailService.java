package service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class MailService {
    public void sendLogin(String name){
        System.out.printf("Welcome %s, you are logged at %s%n", name,
                          ZonedDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
        );
    }
}
