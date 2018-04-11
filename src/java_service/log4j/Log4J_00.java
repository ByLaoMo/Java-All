package java_service.log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Log4J_00 {


    static Logger logger = Logger.getLogger(Log4J_00.class);

    public static void main(String[] args) {

        BasicConfigurator.configure();
        logger.setLevel(Level.ALL);

        logger.trace("跟踪信息");           // 最低等级日志输出
        logger.debug("调试信息");
        logger.info("标准信息级别输出.");
        logger.warn("警告信息");
        logger.error("错误信息");
        logger.fatal("致命信息");
    }
}
