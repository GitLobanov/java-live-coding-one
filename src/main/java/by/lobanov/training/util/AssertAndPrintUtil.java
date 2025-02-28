package by.lobanov.training.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AssertAndPrintUtil {

    private static final Logger logger = LoggerFactory.getLogger(AssertAndPrintUtil.class);

    private AssertAndPrintUtil() {
    }

    public static void logInfo (Object o) {
        logger.info("{}", o);
    }

    public static void isEquals(Object o1, Object o2) {
        logger.info("Result is {}", o1.equals(o2));
    }

    public static void isEqualsAndPrint(Object o1, Object o2) {
        logger.info("Excepted 1 {}", o1);
        logger.info("Result 2 {}", o2);
        logger.info("Result is {}", o1.equals(o2));
    }



}
