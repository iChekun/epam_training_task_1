package by.trjava.task01.chekun.model.util.validator.impl;

import by.trjava.task01.chekun.model.entity.ApplianceTypes;

import by.trjava.task01.chekun.model.util.configuration.Configuration;
import by.trjava.task01.chekun.model.util.validator.entityvalidators.*;
import by.trjava.task01.chekun.model.util.validator.ApplianceInputValidator;
import org.apache.log4j.Logger;

import java.util.Arrays;

import static by.trjava.task01.chekun.model.util.configuration.Configuration.*;


/**
 * Class contains checking methods input parameters in accordance with pattern of data.
 *
 * @author Ilya Chekun
 * @version 1.0
 * @see Configuration
 * @see ApplianceTypes
 */
public class ApplianceInputValidatorImpl implements ApplianceInputValidator {

    private static final Logger logger = Logger.getLogger(ApplianceInputValidatorImpl.class);

    //regex clean = or : or , or ; from line
    private static final String regexToCleanFromColonCommaEqualsSemicolon = "=|:|,|;";
    //regex for cleaning all spaces in line
    private static final String clearAllSpaces = " +";
    private static final String space = " ";
    ///////////////////////

    /**
     * Method check parameters and return true if {@code Appliance} can be create
     *
     * @param parameters {@code String} parameters for new object
     * @return true -> if parameters correct
     * false -> otherwise
     */
    @Override
    public boolean isApplianceArgsCorrect(final String parameters) {

        if (parameters != null && parameters.length() > 1) {
            logger.debug("Method isApplianceArgsCorrect start working. Received parameters: " + parameters);

            final String[] inputValues = parseStringIntoArgsArray(parameters);

            if (isApplianceTypeCorrect(inputValues[APPLIANCE_TYPE_POSITION])) {

                final ApplianceTypes TYPE = ApplianceTypes.valueOf(
                                                            inputValues[APPLIANCE_TYPE_POSITION].toUpperCase());

                switch (TYPE) {
                    case OVEN:
                        return OvenValidator.isOvenArgCorrect(inputValues);
                    case LAPTOP:
                        return LaptopValidator.isLaptopArgCorrect(inputValues);
                    case REFRIGERATOR:
                        return RefrigeratorValidator.isRefrigeratorArgCorrect(inputValues);
                    case SPEAKERS:
                        return SpeakersValidator.isSpeakersArgCorrect(inputValues);
                    case TABLETPC:
                        return TabletPCValidator.isTabletPcArgCorrect(inputValues);
                    case VACUUMCLEANER:
                        return VacuumCleanerValidator.isVacuumCleanerArgCorrect(inputValues);
                }
            }
            logger.debug("Method isApplianceArgsCorrect() received wrong appliance type!");
        }
        logger.debug("Method isApplianceArgsCorrect() received null!");
        return false;
    }

    /**
     * Final method for parsing line according with type look data in file.
     * Example:  was:  "Speakers : POWER_CONSUMPTION=15, NUMBER_OF_SPEAKERS=2, FREQUENCY_RANGE=2-4, CORD_LENGTH=2;
     * became(Array): {"Speakers", "POWER_CONSUMPTION", "15", "NUMBER_OF_SPEAKERS", "2", "FREQUENCY_RANGE", "2-4", "CORD_LENGTH", "2"};
     *
     * @param line {@code String} line for parsing
     * @return {@code String[]} array with arguments for new object
     */
    @Override
    public final String[] parseStringIntoArgsArray(String line) {
        logger.debug("Parsing line: " + line);
        line = line.replaceAll(regexToCleanFromColonCommaEqualsSemicolon, space);
        logger.debug("Line after replace all , . = for space: " + line);
        line = line.trim().replaceAll(clearAllSpaces, space);
        logger.debug("Final lineL: " + line);
        return line.split(space);
    }


    private boolean isApplianceTypeCorrect(final String type) {
        return Arrays.toString(ApplianceTypes.values())
                                                 .contains(
                                                         type.trim().toUpperCase());
    }

}
