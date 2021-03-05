package ioc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class App {
    //or #{bean.property}
    @Value("${description}")
    String description;

    @Value("${port}")
    int port;

    @Value("${mail}")
    boolean mail;

    public int getPort(){
        return this.port;
    }

    public String getDescription(){
        return this.description;
    }

    public boolean getMail(){
        return this.mail;
    }
}
