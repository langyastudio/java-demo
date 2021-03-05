package ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author hk
 */
@Component
public class UserService {
    @Autowired
    MailService mailService;

//    public void setMailService(MailService mailService){
//        this.mailService = mailService;
//    }

    public void login(String name){
        if("wang".compareToIgnoreCase(name) == 0){
            mailService.sendLogin(name);
            return;
        }

        throw new RuntimeException("login failed");
    }
}
