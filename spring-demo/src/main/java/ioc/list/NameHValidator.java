package ioc.list;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class NameHValidator implements HValidator {
    @Override
    public void validate(String email, String name) {
        if(null == name || name.isBlank() || name.length() > 20){
            throw new IllegalArgumentException("invalid name: " + name);
        }
    }
}
