package ioc.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.ZoneId;
import java.util.List;

@Component
public class HValidators {
    @Autowired
    List<HValidator> validators;

    @Autowired(required = false)
    ZoneId zoneId = ZoneId.systemDefault();

    public void validate(String email, String name) {
        for(var validator : this.validators){
            validator.validate(email, name);
        }
    }

    @PostConstruct
    public void init(){
        System.out.println("init HValidator");
    }

    @PreDestroy
    public void shutdown(){
        System.out.println("shutdown HValidator");
    }
}
