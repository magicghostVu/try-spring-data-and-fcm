package pack.logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Created by Fresher on 21/03/2018.
 */
@Service
public class LoggingService {


    private Logger logger;

    private static LoggingService ourInstance = new LoggingService();

    public static LoggingService getInstance() {
        return ourInstance;
    }

    public LoggingService() {

        logger = LogManager.getLogger("RollingFileLog");

    }

    public Logger getLogger() {
        return logger;
    }
}
