package ioc;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 原型模式
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)//"prototype"
public class MailSession {
    public void sendLogin(String name){
        System.out.printf("Welcome %s, you are logged at %s%n", name,
                          ZonedDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
        );
    }
}
