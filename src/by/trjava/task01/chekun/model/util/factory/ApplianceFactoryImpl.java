package by.trjava.task01.chekun.model.util.factory;

import by.trjava.task01.chekun.model.entity.ApplianceTypes;
import by.trjava.task01.chekun.model.entity.*;
import by.trjava.task01.chekun.model.util.configuration.Configuration;
import by.trjava.task01.chekun.model.util.exception.WrongApplianceArgumentsException;
import org.apache.log4j.Logger;

import static by.trjava.task01.chekun.model.util.configuration.Configuration.*;


import java.util.Arrays;

/**
 * Class for create and return object that implementing {@see Appliance}.
 *
 * @author Ilya Chekun
 * @version 1.0
 * @see Appliance
 * @see WrongApplianceArgumentsException
 * @see ApplianceTypes
 * @see Configuration
 */
public class ApplianceFactoryImpl implements ApplianceFactory {

    private static final Logger logger = Logger.getLogger(ApplianceFactoryImpl.class);

    /**
     * Creates and returns {@see Appliance} according with received parameters.
     * Can create an object of any class implementing interface {@code Appliance}.
     *
     * @param id         {@code int} unique identificator for new object.
     * @param parameters {@code String[]} parameters for new object
     * @return object with given parameters.
     * @throws WrongApplianceArgumentsException throws if method will received wrong arguments
     */
    @Override
    public Appliance createAppliance(final int id, final String[] parameters) throws WrongApplianceArgumentsException {

        if (parameters != null && parameters.length > 1) {
            logger.debug("createAppliance() start working. Received parameters: id=" + id + ", " + Arrays.toString(parameters));

            final ApplianceTypes TYPE = ApplianceTypes.valueOf(parameters[APPLIANCE_TYPE_POSITION].toUpperCase());

            logger.debug("Appliance type: " + TYPE);

            switch (TYPE) {
                case OVEN:
                    return new Oven(id,
                            Double.parseDouble(parameters[POWER_CONSUMPTION]),
                            Double.parseDouble(parameters[WEIGHT]),
                            Integer.parseInt(parameters[CAPACITY]),
                            Double.parseDouble(parameters[DEPTH]),
                            Double.parseDouble(parameters[HEIGHT]),
                            Double.parseDouble(parameters[WIDTH]));
                case LAPTOP:
                    return new Laptop(id,
                            Double.parseDouble(parameters[BATTERY_CAPACITY]),
                            parameters[OS],
                            Integer.parseInt(parameters[MEMORY_ROM]),
                            Integer.parseInt(parameters[SYSTEM_MEMORY]),
                            Double.parseDouble(parameters[CPU]),
                            Double.parseDouble(parameters[DISPLAY_INCHS]));
                case REFRIGERATOR:
                    return new Refrigerator(id,
                            Double.parseDouble(parameters[POWER_CONSUMPTION]),
                            Double.parseDouble(parameters[WEIGHT]),
                            Integer.parseInt(parameters[FREEZER_CAPACITY]),
                            Double.parseDouble(parameters[OVERALL_CAPACITY]),
                            Double.parseDouble(parameters[HEIGHT]),
                            Double.parseDouble(parameters[WIDTH]));
                case VACUUMCLEANER:
                    return new VacuumCleaner(id,
                            Double.parseDouble(parameters[POWER_CONSUMPTION]),
                            parameters[FILTER_TYPE],
                            parameters[BAG_TYPE],
                            parameters[WAND_TYPE],
                            Double.parseDouble(parameters[MOTOR_SPEED_REGULATION]),
                            Double.parseDouble(parameters[CLEANING_WIDTH]));
                case TABLETPC:
                    return new TabletPC(id,
                            Double.parseDouble(parameters[BATTERY_CAPACITY]),
                            Double.parseDouble(parameters[DISPLAY_INCHES]),
                            Integer.parseInt(parameters[MEMORY_ROM]),
                            Integer.parseInt(parameters[FLASH_MEMORY_CAPACITY]),
                            parameters[COLOR]);
                case SPEAKERS:
                    return new Speakers(id,
                            Double.parseDouble(parameters[POWER_CONSUMPTION]),
                            Integer.parseInt(parameters[NUMBER_OF_SPEAKERS]),
                            parameters[FREQUENCY_RANGE],
                            Double.parseDouble(parameters[CORD_LENGHT]));
            }
        }

        logger.debug("Method createAppliance() received wrong arguments");
        throw new WrongApplianceArgumentsException("Method createAppliance() received wrong arguments");
    }
}
