package service;

/**
 * @author hk
 */
public class UserService {
    private MailService mailService;

    public void setMailService(MailService mailService){
        this.mailService = mailService;
    }

    public void login(String name){
        if("wang".compareToIgnoreCase(name) == 0){
            mailService.sendLogin(name);
            return;
        }

        throw new RuntimeException("login failed");
    }
}
