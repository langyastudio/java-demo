import ioc.list.HValidators;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import ioc.UserService;

import java.time.ZoneId;

@Configuration
//value用于指定要扫描的package
@ComponentScan(value = "ioc")
public class AppConfig {
    /**
     * 第三方Bean
     */
    @Bean
    @Primary
    @Qualifier("z") //别名
    ZoneId createZoneOfZ(){
        return ZoneId.of("Z");
    }
    @Bean
    @Qualifier("utc8") //别名
    ZoneId createZoneOfUtc8(){
        return ZoneId.of("UTC+08:00");
    }

    public static void main(String[] args) {
        //注解装配
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.login("wang");

        //list
        HValidators hValidators = context.getBean(HValidators.class);
        hValidators.validate("1032030048@qq.com", "12");
    }
}
