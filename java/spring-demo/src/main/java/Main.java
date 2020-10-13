import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ioc.UserService;

public class Main {
    public static void main(String[] args) {
        //XML文件装配
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        UserService userService = context.getBean(UserService.class);
        userService.login("wang");
    }
}
