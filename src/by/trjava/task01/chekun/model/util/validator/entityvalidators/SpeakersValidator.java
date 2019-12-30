package by.trjava.task01.chekun.model.util.validator.entityvalidators;


import org.apache.log4j.Logger;

import static by.trjava.task01.chekun.model.util.configuration.Configuration.*;

public class SpeakersValidator {

    private static final Logger logger = Logger.getLogger(SpeakersValidator.class);

    public static boolean isSpeakersArgCorrect(String[] inputValues) {
        logger.debug("isSpeakersArgCorrect() start working..");

        if (inputValues.length == SPEAKERS_ARGUMENTS_COUNT) {
            return ApplianceValidator.isPowerConsumptionCorrect(inputValues[POWER_CONSUMPTION], SPEAKERS_MIN_POWER_CONSUMPTION, SPEAKERS_MAX_POWER_CONSUMPTION)
                    && isNumberOfSpeakersCorrect(inputValues[NUMBER_OF_SPEAKERS])
                    && isFrequencyRangeCorrect(inputValues[FREQUENCY_RANGE])
                    && isCordLenghtCorrect(inputValues[CORD_LENGHT]);
        }

        logger.debug("isSpeakersArgCorrect() received wrong arguments count : " + inputValues.length);
        return false;
    }

    private static boolean isFrequencyRangeCorrect(String value) {
        return value.matches(SPEAKERS_REGEX_FREQUENCY_RANGE_PATTERN);
    }

    private static boolean isCordLenghtCorrect(String value) {
        try {
            double cordLenght = Double.parseDouble(value);
            return cordLenght >= SPEAKERS_MIN_CORD_LENGHT && cordLenght <= SPEAKERS_MAX_CORD_LENGHT;
        } catch (NumberFormatException ex) {
            logger.debug("cordLenght is not valid. Received: " + value);
            return false;
        }
    }

    private static boolean isNumberOfSpeakersCorrect(String value) {
        try {
            int numberOfSpeakers = Integer.parseInt(value);
            return numberOfSpeakers >= SPEAKERS_MIN_NUMBER_OF_SPEAKERS && numberOfSpeakers <= SPEAKERS_MAX_NUMBER_OF_SPEAKERS;
        } catch (NumberFormatException ex) {
            logger.debug("numberOfSpeakers is not valid. Received: " + value);
            return false;
        }
    }

    private SpeakersValidator() {
    }
}
