package by.trjava.task01.chekun.model.util.validator.entityvalidators;

import org.apache.log4j.Logger;

import static by.trjava.task01.chekun.model.util.configuration.Configuration.*;

public class TabletPCValidator {

    private static final Logger logger = Logger.getLogger(TabletPCValidator.class);

    public static boolean isTabletPcArgCorrect(String[] inputValues) {
        logger.debug("isTabletPcArgCorrect() start working..");

        if (inputValues.length == TABLET_PC_ARGUMENTS_COUNT) {

            return ApplianceValidator.isBatteryCapacityCorrect(inputValues[BATTERY_CAPACITY], TABLET_PC_MIN_BATTERY_CAPACITY, TABLET_PC_MAX_BATTERY_CAPACITY)
                    && ApplianceValidator.isDisplayInchsCorrect(inputValues[DISPLAY_INCHES], TABLET_PC_MIN_DISPLAY_INCHES, TABLET_PC_MAX_DISPLAY_INCHES)
                    && ApplianceValidator.isMemoryRomCorrect(inputValues[MEMORY_ROM], TABLET_PC_MIN_MEMORY_ROM, TABLET_PC_MAX_MEMORY_ROM)
                    && isFlashMemoryCapacityCorrect(inputValues[FLASH_MEMORY_CAPACITY])
                    && isColorCorrect(inputValues[COLOR]);
        }

        logger.debug("isTabletPcArgCorrect() received wrong arguments count : " + inputValues.length);
        return false;
    }

    private static boolean isFlashMemoryCapacityCorrect(String value) {
        try {
            double flashMemoryCapacity = Double.parseDouble(value);
            return flashMemoryCapacity >= TABLET_PC_MIN_FLASH_MEMORY_CAPACITY && flashMemoryCapacity <= TABLET_PC_MAX_FLASH_MEMORY_CAPACITY;
        } catch (NumberFormatException ex) {
            logger.debug("flashMemoryCapacity is not valid. Received: " + value);
            return false;
        }
    }

    private static boolean isColorCorrect(String value) {
        return TABLET_PC_REQUIRED_COLORS.contains(value.trim());
    }

    private TabletPCValidator() {}

}
