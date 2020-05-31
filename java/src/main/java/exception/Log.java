package exception;

import com.sun.tools.javac.Main;
import org.apache.commons.logging.LogFactory;

import java.util.logging.Logger;

public class Log {
    public static void main(String[] args) {
        //Logger lg= Logger.getGlobal();
        Logger lg = Logger.getLogger(Main.class.getName());
        lg.info("info");
        lg.warning("warning");
        lg.config("CONFIG");

        //Common Logging
        org.apache.commons.logging.Log loger = LogFactory.getLog(Main.class);
        loger.error("org.apache.commons.logging.Log");
    }
}
