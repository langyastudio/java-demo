package ioc.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HValidators {
    @Autowired
    List<HValidator> validators;

    public void validate(String email, String name) {
        for(var validator : this.validators){
            validator.validate(email, name);
        }
    }
}
