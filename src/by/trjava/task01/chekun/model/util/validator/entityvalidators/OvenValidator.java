package by.trjava.task01.chekun.model.util.validator.entityvalidators;


import org.apache.log4j.Logger;

import static by.trjava.task01.chekun.model.util.configuration.Configuration.*;

public class OvenValidator {

    private static final Logger logger = Logger.getLogger(OvenValidator.class);

    public static boolean isOvenArgCorrect(String[] inputValues) {
        logger.debug("isOvenArgCorrect start working");

        if (inputValues.length == OVEN_ARGUMENTS_COUNT) {
            return ApplianceValidator.isPowerConsumptionCorrect(inputValues[POWER_CONSUMPTION], OVEN_MIN_POWER_CONSUMPTION, OVEN_MAX_POWER_CONSUMPTION)
                    && ApplianceValidator.isWeightCorrect(inputValues[WEIGHT], OVEN_MIN_WEIGHT, OVEN_MAX_WEIGHT)
                    && isCapacityCorrect(inputValues[CAPACITY])
                    && isDepthCorrect(inputValues[DEPTH])
                    && ApplianceValidator.isHeightCorrect(inputValues[HEIGHT], OVEN_MIN_HEIGHT, OVEN_MAX_HEIGHT)
                    && ApplianceValidator.isWidthCorrect(inputValues[WIDTH], OVEN_MIN_WIDTH, OVEN_MAX_WIDTH);
        }

        logger.debug("isOvenArgCorrect() received bad arguments count : " + inputValues.length);
        return false;
    }

    private static boolean isCapacityCorrect(String value) {
        try {
            int weight = Integer.parseInt(value);
            return weight >= OVEN_MIN_CAPACITY && weight <= OVEN_MAX_CAPACITY;
        } catch (NumberFormatException ex) {
            logger.debug("weight is not valid. Received: " + value);
            return false;
        }
    }

    private static boolean isDepthCorrect(String value) {
        try {
            double depth = Double.parseDouble(value);
            return depth >= OVEN_MIN_DEPTH && depth <= OVEN_MAX_DEPTH;
        } catch (NumberFormatException ex) {
            logger.debug("depth is not valid. Received: " + value);
            return false;
        }
    }

    private OvenValidator() {
    }

}
