package by.trjava.task01.chekun.model.util.validator.entityvalidators;

import org.apache.log4j.Logger;

public class ApplianceValidator {

    private static final Logger logger = Logger.getLogger(ApplianceValidator.class);

    public static boolean isPowerConsumptionCorrect(String value, double minConsumption, double maxConsumption) {
        try {
            double powerConsumption = Double.parseDouble(value);
           // logger.debug(powerConsumption >= minConsumption && powerConsumption <= maxConsumption? "powerConsumption valid. Value: " + value : "powerConsumption not valid. Received:" + value);
            return powerConsumption >= minConsumption && powerConsumption <= maxConsumption;
        } catch (NumberFormatException ex) {
            logger.debug("powerConsumption not valid. Received: " + value);
            return false;
        }
    }

    public static boolean isWeightCorrect(String value, double minWeight, double maxWeight) {
        try {
            double weight = Double.parseDouble(value);
            //logger.debug(weight >= minWeight && weight <= maxWeight ? "weight valid. Value: " + value : "powerConsumption not valid. Received:" + value);
            return weight >= minWeight && weight <= maxWeight;
        } catch (NumberFormatException ex) {
            logger.debug("weight not valid. Received: " + value);
            return false;
        }
    }

    public static boolean isHeightCorrect(String value, double minHeight, double maxHeight) {
        try {
            double height = Double.parseDouble(value);
            //logger.debug(height >= minHeight && height <= maxHeight ? "height valid. Value: " + value : "height not valid. Received:" + value);
            return height >= minHeight && height <= maxHeight;
        } catch (NumberFormatException ex) {
            logger.debug("height not valid. Received: " + value);
            return false;
        }
    }

    public static boolean isWidthCorrect(String value, double minWidth, double maxWidth) {
        try {
            double width = Double.parseDouble(value);
            //logger.debug(width >= minWidth && width <= maxWidth ? "width valid. Value: " + value : "width not valid. Received:" + value);
            return width >= minWidth && width <= maxWidth;
        } catch (NumberFormatException ex) {
            logger.debug("width not valid. Received: " + value);
            return false;
        }
    }

    public static boolean isBatteryCapacityCorrect(String value, double minBatteryCapacity, double maxBatteryCapacity) {
        try {
            double batteryCapacity = Double.parseDouble(value);
//            logger.debug(batteryCapacity >= minBatteryCapacity && batteryCapacity <= maxBatteryCapacity
//                    ? "batteryCapacity valid. Value: " + value : "batteryCapacity not valid. Received:" + value);
            return batteryCapacity >= minBatteryCapacity && batteryCapacity <= maxBatteryCapacity;
        } catch (NumberFormatException ex) {
            logger.debug("batteryCapacity not valid. Received: " + value);
            return false;
        }
    }

    public static boolean isDisplayInchsCorrect(String value, double minDisplayInchs, double maxDisplayInchs) {
        try {
            double displayInchs = Double.parseDouble(value);
//            logger.debug(displayInchs >= minDisplayInchs && displayInchs <= maxDisplayInchs
//                    ? "displayInchs valid. Value: " + value : "displayInchs not valid. Received:" + value);
            return displayInchs >= minDisplayInchs && displayInchs <= maxDisplayInchs;
        } catch (NumberFormatException ex) {
            logger.debug("displayInchs not valid. Received: " + value);
            return false;
        }
    }

    public static boolean isMemoryRomCorrect(String value, int minMemoryRom, double maxMemoryRom) {
        try {
            int memoryRom = Integer.parseInt(value);
//            logger.debug(memoryRom >= minMemoryRom && memoryRom <= maxMemoryRom
//                    ? "memoryRom valid. Value: " + value : "memoryRom not valid. Received:" + value);
            return memoryRom >= minMemoryRom && memoryRom <= maxMemoryRom;
        } catch (NumberFormatException ex) {
            logger.debug("memoryRom not valid. Received: " + value);
            return false;
        }
    }

    private ApplianceValidator() {
    }

}
