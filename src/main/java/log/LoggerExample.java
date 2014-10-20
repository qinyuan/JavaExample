package log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerExample {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(LoggerExample.class);
        logger.error("Hello World, Hello World, Hello World, Hello World");
    }
}
