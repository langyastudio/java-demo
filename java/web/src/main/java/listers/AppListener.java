package listers;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 被Web服务器自动初始化
 *
 * @author hk
 */
@WebListener
public class AppListener implements ServletContextListener {
    // 在此初始化WebApp,例如打开数据库连接池等:
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("WebApp initialized.");

        //全局唯一
        System.out.println(sce.getServletContext());
    }

    // 在此清理WebApp,例如关闭数据库连接池等:
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("WebApp destroyed.");
    }
}
