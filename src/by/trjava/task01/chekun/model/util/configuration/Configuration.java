package by.trjava.task01.chekun.model.util.configuration;

import java.util.Arrays;
import java.util.List;

/**
 * Class using for save all important data of program.
 * Easily to change some position, because it will do only in one place, but will according in all program.
 * <p>
 * In future can be update and getSearchCriteria all data from file.
 *
 * @author Ilya Chekun
 * @version 1.0
 * @see
 */
public final class Configuration {

    public static final int APPLIANCE_TYPE_POSITION = 0;

    /////below is positions in received array

    //OVEN
    public static final int POWER_CONSUMPTION = 2;
    public static final int WEIGHT = 4;
    public static final int CAPACITY = 6;
    public static final int DEPTH = 8;
    public static final int HEIGHT = 10;
    public static final int WIDTH = 12;

    //LAPTOP
    public static final int BATTERY_CAPACITY = 2;
    public static final int OS = 4;
    public static final int MEMORY_ROM = 6;
    public static final int SYSTEM_MEMORY = 8;
    public static final int CPU = 10;
    public static final int DISPLAY_INCHS = 12;

    //REFRIGERATOR
    public static final int FREEZER_CAPACITY = 6;
    public static final int OVERALL_CAPACITY = 8;

    //VacuumCleaner
    public static final int FILTER_TYPE = 4;
    public static final int BAG_TYPE = 6;
    public static final int WAND_TYPE = 8;
    public static final int MOTOR_SPEED_REGULATION = 10;
    public static final int CLEANING_WIDTH = 12;

    //TabletPC
    public static final int DISPLAY_INCHES = 4;
    public static final int FLASH_MEMORY_CAPACITY = 8;
    public static final int COLOR = 10;

    //Speakers
    public static final int NUMBER_OF_SPEAKERS = 4;
    public static final int FREQUENCY_RANGE = 6;
    public static final int CORD_LENGHT = 8;

    //////////

    //////////////////////

    ///OVEN types of valid data

    public static final int OVEN_ARGUMENTS_COUNT = 13;

    public static final double OVEN_MIN_DEPTH = 0;
    public static final double OVEN_MAX_DEPTH = 120;

    public static final int OVEN_MIN_CAPACITY = 0;
    public static final int OVEN_MAX_CAPACITY = 100;

    public static final double OVEN_MIN_POWER_CONSUMPTION = 0;
    public static final double OVEN_MAX_POWER_CONSUMPTION = 5000;

    public static final double OVEN_MIN_WEIGHT = 0;
    public static final double OVEN_MAX_WEIGHT = 100;

    public static final double OVEN_MIN_HEIGHT = 0;
    public static final double OVEN_MAX_HEIGHT = 250;

    public static final double OVEN_MIN_WIDTH = 0;
    public static final double OVEN_MAX_WIDTH = 120;


    ////////////////////////////////////
    ///LAPTOP types of valid data

    public static final int LAPTOP_ARGUMENTS_COUNT = 13;

    public static final double LAPTOP_MIN_BATTERY_CAPACITY = 0;
    public static final double LAPTOP_MAX_BATTERY_CAPACITY = 5;

    public static final int LAPTOP_MIN_MEMORY_ROM = 500;
    public static final int LAPTOP_MAX_MEMORY_ROM = 12000;

    public static final int LAPTOP_MIN_SYSTEM_MEMORY = 500;
    public static final int LAPTOP_MAX_SYSTEM_MEMORY = 12000;

    public static final double LAPTOP_MIN_CPU = 1;
    public static final double LAPTOP_MAX_CPU = 7;

    public static final double LAPTOP_MIN_DISPLAY_INCHES = 16;
    public static final double LAPTOP_MAX_DISPLAY_INCHES = 24;

    public static final List<String> LAPTOP_OS_TYPES = Arrays.asList("Windows", "Linux", "Mac");

    /////////////////////////////////////

    ///REFRIGERATOR types of valid data

    public static final int REFRIGERATOR_ARGUMENTS_COUNT = 13;

    public static final double REFRIGERATOR_MIN_POWER_CONSUMPTION = 0;
    public static final double REFRIGERATOR__MAX_POWER_CONSUMPTION = 5000;

    public static final double REFRIGERATOR_MIN_WEIGHT = 0;
    public static final double REFRIGERATOR_MAX_WEIGHT = 100;

    public static final double REFRIGERATOR_MIN_HEIGHT = 0;
    public static final double REFRIGERATOR_MAX_HEIGHT = 250;

    public static final double REFRIGERATOR_MIN_WIDTH = 0;
    public static final double REFRIGERATOR_MAX_WIDTH = 120;

    public static final int REFRIGERATOR_MIN_FREEZER_CAPACITY = 6;
    public static final int REFRIGERATOR_MAX_FREEZER_CAPACITY = 30;

    public static final double REFRIGERATOR_MIN_OVERALL_CAPACITY = 100;
    public static final double REFRIGERATOR_MAX_OVERALL_CAPACITY = 500;


    /////////////////////////////////////

    ///SPEAKERS types of valid data

    public static final int SPEAKERS_ARGUMENTS_COUNT = 9;

    public static final double SPEAKERS_MIN_POWER_CONSUMPTION = 0;
    public static final double SPEAKERS_MAX_POWER_CONSUMPTION = 5000;

    public static final int SPEAKERS_MIN_NUMBER_OF_SPEAKERS = 1;
    public static final int SPEAKERS_MAX_NUMBER_OF_SPEAKERS = 12;

    public static final double SPEAKERS_MIN_CORD_LENGHT = 1.0;
    public static final double SPEAKERS_MAX_CORD_LENGHT = 12.5;

    public static final String SPEAKERS_REGEX_FREQUENCY_RANGE_PATTERN = "^[0-9.-]*$"; //in line must be only numbers then can be dot or dash

    /////////////////////////////////////
    ///TABLET_PC types of valid data

    public static final int TABLET_PC_ARGUMENTS_COUNT = 11;

    public static final int TABLET_PC_MIN_FLASH_MEMORY_CAPACITY = 1;
    public static final int TABLET_PC_MAX_FLASH_MEMORY_CAPACITY = 12;

    public static final double TABLET_PC_MIN_BATTERY_CAPACITY = 1;
    public static final double TABLET_PC_MAX_BATTERY_CAPACITY = 10;

    public static final double TABLET_PC_MIN_DISPLAY_INCHES = 8;
    public static final double TABLET_PC_MAX_DISPLAY_INCHES = 24;

    public static final int TABLET_PC_MIN_MEMORY_ROM = 500;
    public static final int TABLET_PC_MAX_MEMORY_ROM = 12000;

    public static final List<String> TABLET_PC_REQUIRED_COLORS = Arrays.asList("blue", "red", "green", "brown", "yellow", "ping", "black", "white");

    /////////////////////////////////////

    ///VACUUM_CLEANER types of valid data

    public static final int VACUUM_CLEANER_ARGUMENTS_COUNT = 13;

    public static final double VACUUM_CLEANER_MIN_CLEANING_WIDTH = 15;
    public static final double VACUUM_CLEANER_MAX_CLEANING_WIDTH = 45;

    public static final double VACUUM_CLEANER_MIN_MOTOR_SPEED_REGULATION = 2500;
    public static final double VACUUM_CLEANER_MAX_MOTOR_SPEED_REGULATION = 4500;

    public static final String[] VACUUM_CLEANER_FILTER_TYPES = {"A", "B", "C"};

    public static final String VACUUM_CLEANER_WANG_TYPES = "all-in-one";

    public static final String[] VACUUM_CLEANER_BAG_TYPES = {"A2", "AA-89", "XX00"};

    /////////////////////////////////////

    private Configuration() { }

}