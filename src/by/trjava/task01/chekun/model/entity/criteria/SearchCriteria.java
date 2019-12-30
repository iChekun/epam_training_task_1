package by.trjava.task01.chekun.model.entity.criteria;

public final class SearchCriteria {

    public static enum Oven {
        POWER_CONSUMPTION, WEIGHT, CAPACITY, DEPTH,
        HEIGHT, WIDTH
    }

    public static enum Laptop {
        BATTERY_CAPACITY, OS, MEMORY_ROM,
        SYSTEM_MEMORY, CPU, DISPLAY_INCHS
    }

    public static enum Refrigerator {
        POWER_CONSUMPTION, WEIGHT, FREEZER_CAPACITY,
        OVERALL_CAPACITY, HEIGHT, WIDTH
    }

    public static enum TabletPC {
        FLASH_MEMORY_CAPACITY, COLOR,
        DISPLAY_INCHES,
        BATTERY_CAPACITY, MEMORY_ROM
    }

    public static enum Speakers {
        POWER_CONSUMPTION, NUMBER_OF_SPEAKERS,
        FREQUENCY_RANGE, CORD_LENGTH
    }

    public static enum VacuumCleaner {
        POWER_CONSUMPTION, FILTER_TYPE, BAG_TYPE,
        WAND_TYPE, MOTOR_SPEED_REGULATION, CLEANING_WIDTH
    }

    private SearchCriteria() {
    }

}
