package by.trjava.task01.chekun.model.util.validator.entityvalidators;

import org.apache.log4j.Logger;


import static by.trjava.task01.chekun.model.util.configuration.Configuration.*;

public class RefrigeratorValidator {

    private static final Logger logger = Logger.getLogger(RefrigeratorValidator.class);

    public static boolean isRefrigeratorArgCorrect(String[] inputValues) {
        logger.debug("isRefrigeratorArgCorrect() start working..");

        if (inputValues.length == REFRIGERATOR_ARGUMENTS_COUNT) {
            return ApplianceValidator.isPowerConsumptionCorrect(inputValues[POWER_CONSUMPTION], REFRIGERATOR_MIN_POWER_CONSUMPTION, REFRIGERATOR__MAX_POWER_CONSUMPTION)
                    && ApplianceValidator.isWeightCorrect(inputValues[WEIGHT], REFRIGERATOR_MIN_WEIGHT, REFRIGERATOR_MAX_WEIGHT)
                    && isFreezerCapacityCorrect(inputValues[FREEZER_CAPACITY])
                    && isOverallCapacityCorrect(inputValues[OVERALL_CAPACITY])
                    && ApplianceValidator.isHeightCorrect(inputValues[HEIGHT], REFRIGERATOR_MIN_HEIGHT, REFRIGERATOR_MAX_HEIGHT)
                    && ApplianceValidator.isWidthCorrect(inputValues[WIDTH], REFRIGERATOR_MIN_WIDTH, REFRIGERATOR_MAX_WIDTH);
        }

        logger.debug("isRefrigeratorArgCorrect() received wrong arguments count : " + inputValues.length);
        return false;
    }

    private static boolean isFreezerCapacityCorrect(String value) {
        try {
            int freezerCapacity = Integer.parseInt(value);
            return freezerCapacity >= REFRIGERATOR_MIN_FREEZER_CAPACITY && freezerCapacity <= REFRIGERATOR_MAX_FREEZER_CAPACITY;
        } catch (NumberFormatException ex) {
            logger.debug("freezerCapacity is not valid. Received: " + value);
            return false;
        }
    }

    private static boolean isOverallCapacityCorrect(String value) {
        try {
            int overall_capacity = Integer.parseInt(value);
            return overall_capacity >= REFRIGERATOR_MIN_OVERALL_CAPACITY && overall_capacity <= REFRIGERATOR_MAX_OVERALL_CAPACITY;
        } catch (NumberFormatException ex) {
            logger.debug("overall_capacity is not valid. Received: " + value);
            return false;
        }
    }

    private RefrigeratorValidator() {
    }
}
