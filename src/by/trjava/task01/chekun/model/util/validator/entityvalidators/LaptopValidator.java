package by.trjava.task01.chekun.model.util.validator.entityvalidators;

import org.apache.log4j.Logger;

import static by.trjava.task01.chekun.model.util.configuration.Configuration.*;


public class LaptopValidator {

    private static final Logger logger = Logger.getLogger(LaptopValidator.class);

    public static boolean isLaptopArgCorrect(String[] inputValues) {
        logger.debug("isLaptopArgCorrect() starting..");

        if (inputValues.length == LAPTOP_ARGUMENTS_COUNT) {
            return isBatteryCapacityCorrect(inputValues[BATTERY_CAPACITY])
                    && isOSCorrect(inputValues[OS])
                    && isMemoryRomCorrect(inputValues[MEMORY_ROM])
                    && isSystemMemoryCorrect(inputValues[SYSTEM_MEMORY])
                    && isCPUCorrect(inputValues[CPU])
                    && isDisplayInchesCorrect(inputValues[DISPLAY_INCHS]);
        }

        logger.debug("isLaptopArgCorrect() received bad arguments count : " + inputValues.length);
        return false;
    }

    private LaptopValidator() {
    }

    private static boolean isBatteryCapacityCorrect(String value) {
        try {
            double batteryCapacity = Double.parseDouble(value);
            return batteryCapacity >= LAPTOP_MIN_BATTERY_CAPACITY && batteryCapacity <= LAPTOP_MAX_BATTERY_CAPACITY;
        } catch (NumberFormatException ex) {
            logger.debug("batteryCapacity not valid. Received: " + value);
            return false;
        }
    }

    private static boolean isOSCorrect(String value) {
        logger.debug("isOSCorrect() working. Received: " + value);
        return LAPTOP_OS_TYPES.stream().anyMatch(s -> s.equalsIgnoreCase(value.trim()));
    }

    private static boolean isMemoryRomCorrect(String value) {
        try {
            int memoryRom = Integer.parseInt(value);
            return memoryRom >= LAPTOP_MIN_MEMORY_ROM && memoryRom <= LAPTOP_MAX_MEMORY_ROM;
        } catch (NumberFormatException ex) {
            logger.debug("memoryRom not valid. Received: " + value);
            return false;
        }
    }

    private static boolean isSystemMemoryCorrect(String value) {
        try {
            int systemMemory = Integer.parseInt(value);
            return systemMemory >= LAPTOP_MIN_SYSTEM_MEMORY && systemMemory <= LAPTOP_MAX_SYSTEM_MEMORY;
        } catch (NumberFormatException ex) {
            logger.debug("systemMemory not valid. Received: " + value);
            return false;
        }
    }

    private static boolean isDisplayInchesCorrect(String value) {
        try {
            double displayInches = Double.parseDouble(value);
            return displayInches >= LAPTOP_MIN_DISPLAY_INCHES && displayInches <= LAPTOP_MAX_DISPLAY_INCHES;
        } catch (NumberFormatException ex) {
            logger.debug("displayInches not valid. Received: " + value);
            return false;
        }
    }

    private static boolean isCPUCorrect(String value) {
        try {
            double CPU = Double.parseDouble(value);
            return CPU >= LAPTOP_MIN_CPU && CPU <= LAPTOP_MAX_CPU;
        } catch (NumberFormatException ex) {
            logger.debug("CPU not valid. Received: " + value);
            return false;
        }
    }


}
