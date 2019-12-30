package by.trjava.task01.chekun.model.util.validator.entityvalidators;

import org.apache.log4j.Logger;

import java.util.Arrays;

import static by.trjava.task01.chekun.model.util.configuration.Configuration.*;

public class VacuumCleanerValidator {

    private static final Logger logger = Logger.getLogger(VacuumCleanerValidator.class);

    public static boolean isVacuumCleanerArgCorrect(String[] inputValues) {
        logger.debug("isVacuumCleanerArgCorrect() start working");

        if (inputValues.length == VACUUM_CLEANER_ARGUMENTS_COUNT) {
            return isFilterTypeCorrect(inputValues[FILTER_TYPE])
                    && isBagTypeCorrect(inputValues[BAG_TYPE])
                    && isWandTypeCorrect(inputValues[WAND_TYPE])
                    && isMotorSpeedRegulationCorrect(inputValues[MOTOR_SPEED_REGULATION])
                    && isCleaningWidthCorrect(inputValues[CLEANING_WIDTH]);
        }

        logger.debug("isVacuumCleanerArgCorrect() received wrong arguments count : " + inputValues.length);
        return false;
    }

    private static boolean isCleaningWidthCorrect(String value) {
        try {
            double cleaningWidth = Double.parseDouble(value);
            return cleaningWidth >= VACUUM_CLEANER_MIN_CLEANING_WIDTH && cleaningWidth <= VACUUM_CLEANER_MAX_CLEANING_WIDTH;
        } catch (NumberFormatException ex) {
            logger.debug("cleaningWidth is not valid. Received: " + value);
            return false;
        }
    }

    private static boolean isMotorSpeedRegulationCorrect(String value) {
        try {
            double motorSpeedRegulation = Double.parseDouble(value);
            return motorSpeedRegulation >= VACUUM_CLEANER_MIN_MOTOR_SPEED_REGULATION && motorSpeedRegulation <= VACUUM_CLEANER_MAX_MOTOR_SPEED_REGULATION;
        } catch (NumberFormatException ex) {
            logger.debug("motorSpeedRegulation is not valid. Received: " + value);
            return false;
        }
    }

    private static boolean isWandTypeCorrect(String value) {
        //don't know how check this.. so i made only with pattern from received data from file
        //if valid types will grow you can expand WANG TYPES
        return value != null && value.equalsIgnoreCase(VACUUM_CLEANER_WANG_TYPES);
    }

    private static boolean isBagTypeCorrect(String value) {
        //also made with pattern  from file and added three given types for valid type
        return value != null
                && Arrays.stream(VACUUM_CLEANER_BAG_TYPES).anyMatch(s -> s.equalsIgnoreCase(value));
    }

    private static boolean isFilterTypeCorrect(String value) {
        return Arrays.stream(VACUUM_CLEANER_FILTER_TYPES).anyMatch(s -> s.equalsIgnoreCase(value));
    }

    private VacuumCleanerValidator() {
    }
}
