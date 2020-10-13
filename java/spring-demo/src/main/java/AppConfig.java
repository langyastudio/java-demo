import ioc.list.HValidators;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ioc.UserService;

@Configuration
//value用于指定要扫描的package
@ComponentScan(value = "ioc")
public class AppConfig {
    public static void main(String[] args) {
        //注解装配
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.login("wang");

        //list
        HValidators hValidators = context.getBean(HValidators.class);
        hValidators.validate("1032030048@qq.com", "");
    }
}
