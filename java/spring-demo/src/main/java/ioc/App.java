package ioc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class App {
    //or #{bean.property}
    @Value("${description}")
    String description;

    @Value("${port}")
    int port;

    public int getPort(){
        return this.port;
    }

    public String getDescription(){
        return this.description;
    }
}
