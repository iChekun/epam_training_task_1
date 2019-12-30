package by.trjava.task01.chekun.util.factory;

import by.trjava.task01.chekun.model.entity.*;
import by.trjava.task01.chekun.model.util.UtilFactory;
import by.trjava.task01.chekun.model.util.exception.WrongApplianceArgumentsException;
import by.trjava.task01.chekun.model.util.factory.ApplianceFactory;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApplianceFactoryImplTest {
    private static final Logger logger = Logger.getLogger(ApplianceFactoryImplTest.class);
    private final UtilFactory utilFactory = UtilFactory.getInstance();
    private final ApplianceFactory factory = utilFactory.getApplianceFactory();

    @BeforeClass
    public static void beforeClass() {
        logger.info("\n\nApplianceFactoryImplTest started!");
    }


    @Test(expected = WrongApplianceArgumentsException.class)
    public void createAppliance_wrong_parameters_exception() throws WrongApplianceArgumentsException {
        factory.createAppliance(1, null);
    }

    @Test(expected = WrongApplianceArgumentsException.class)
    public void ccreateAppliance_wrong_parameters_exception_2() throws WrongApplianceArgumentsException {
        String[] parameters = {"  "};
        factory.createAppliance(1, parameters);
    }

    @Test
    public void createAppliance_Oven_correctParameters_true() throws WrongApplianceArgumentsException {
        String[] values = {"Oven", "POWER_CONSUMPTION", "1700", "WEIGHT", "15", "CAPACITY", "23", "DEPTH", "50", "HEIGHT ", "42", "WIDTH", "68"};

        Appliance expected = new Oven(52, 1700, 15, 23, 50, 42, 68);

        Appliance actual = factory.createAppliance(52, values);

        assertEquals(expected, actual);
    }


    @Test
    public void createAppliance_Laptop_correctParameters_true() throws WrongApplianceArgumentsException {
        String[] values = {"LAPTOP", "BATTERY_CAPACITY", "1", "OS", "Windows", "MEMORY_ROM", "5000", "SYSTEM_MEMORY", "7000", "CPU ", "3", "DISPLAY_INCHS", "17"};

        Appliance expected = new Laptop(52, 1, "windows", 5000, 7000, 3, 17);

        Appliance actual = factory.createAppliance(52, values);

        assertEquals(expected, actual);
    }

    @Test
    public void createAppliance_Refrigerator_correctParameters_true() throws WrongApplianceArgumentsException {
        String[] values = {"Refrigerator", "POWER_CONSUMPTION", "222", "WEIGHT", "12", "FREEZER_CAPACITY", "12", "OVERALL_CAPACITY", "280", "HEIGHT ", "210", "WIDTH", "60"};

        Appliance expected = new Refrigerator(52, 222, 12, 12, 280, 210, 60);

        Appliance actual = factory.createAppliance(52, values);

        assertEquals(expected, actual);
    }

    @Test
    public void createAppliance_Speakers_correctParameters_true() throws WrongApplianceArgumentsException {
        String[] values = {"Speakers", "POWER_CONSUMPTION", "15", "NUMBER_OF_SPEAKERS", "2", "FREQUENCY_RANGE", "2-4", "CORD_LENGTH", "2"};

        Appliance expected = new Speakers(52, 15, 2, "2-4", 2);

        Appliance actual = factory.createAppliance(52, values);

        assertEquals(expected, actual);
    }

    @Test
    public void createAppliance_TabletPC_correctParameters_true() throws WrongApplianceArgumentsException {
        String[] values = {"TabletPC", "BATTERY_CAPACITY", "3", "DISPLAY_INCHES", "14", "MEMORY_ROM", "8000", "FLASH_MEMORY_CAPACITY", "2", "COLOR ", "blue"};

        Appliance expected = new TabletPC(52, 3, 14, 8000, 2, "blue");

        Appliance actual = factory.createAppliance(52, values);

        assertEquals(expected, actual);
    }

    @Test
    public void createAppliance_VacuumCleaner_correctParameters_true() throws WrongApplianceArgumentsException {
        String[] values = {"VacuumCleaner", "POWER_CONSUMPTION", "100", "FILTER_TYPE", "A", "BAG_TYPE", "A2", "WAND_TYPE", "all-in-one", "MOTOR_SPEED_REGULATION ", "3000", "CLEANING_WIDTH", "20"};

        Appliance expected = new VacuumCleaner(52, 100, "A", "A2", "all-in-one", 3000, 20);

        Appliance actual = factory.createAppliance(52, values);

        assertEquals(expected, actual);
    }


    @AfterClass
    public static void afterClass() {
        logger.info("\n\nApplianceFactoryImplTest finished!!");
    }
}