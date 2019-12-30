package by.trjava.task01.chekun.view;

import org.apache.log4j.Logger;

public class Printer {

    private static Logger logger = Logger.getLogger(Printer.class);

    public static void print(String message) {
        logger.info(message);
    }

    public static void print(Object object) {
        logger.info(object.toString());
    }

    public static void print(Exception ex ) {
        logger.warn(ex.getMessage());
    }
}
