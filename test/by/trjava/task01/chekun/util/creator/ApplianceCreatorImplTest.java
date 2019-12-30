package by.trjava.task01.chekun.util.creator;

import by.trjava.task01.chekun.model.entity.*;
import by.trjava.task01.chekun.model.util.UtilFactory;
import by.trjava.task01.chekun.model.util.creator.ApplianceCreator;
import by.trjava.task01.chekun.model.util.exception.WrongApplianceArgumentsException;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApplianceCreatorImplTest {
    private static Logger logger = Logger.getLogger(ApplianceCreatorImplTest.class);

    private UtilFactory utilFactory = UtilFactory.getInstance();
    private ApplianceCreator creator = utilFactory.getApplianceCreator();

    @BeforeClass
    public static void beforeClass() {
        logger.info("\n\nApplianceCreatorImplTest started!");
    }


    @Test(expected = WrongApplianceArgumentsException.class)
    public void create_emptyString_exception() throws WrongApplianceArgumentsException {
        creator.create("");
    }

    @Test(expected = WrongApplianceArgumentsException.class)
    public void create_wrongParameters_exception() throws WrongApplianceArgumentsException {

        creator.create("belarus minsk 1 2 2019 5");
    }

    @Test
    public void create_Oven_correctParameters() throws WrongApplianceArgumentsException {

        Appliance expected = new Oven(5, 1700, 15, 23, 50, 42, 68);

        Appliance actual = creator.create("Oven : POWER_CONSUMPTION=1700, WEIGHT=15, CAPACITY=23, DEPTH=50, HEIGHT=42, WIDTH=68;");

        assertEquals(expected, actual);
    }

    @Test
    public void create_Laptop_correctParameters() throws WrongApplianceArgumentsException {

        Appliance expected = new Laptop(5, 1, "windows", 4000, 1000, 1.2, 18);

        Appliance actual = creator.create("Laptop : BATTERY_CAPACITY=1, OS=Windows, MEMORY_ROM=4000, SYSTEM_MEMORY=1000, CPU=1.2, DISPLAY_INCHS=18;");

        assertEquals(expected, actual);
    }

    @Test
    public void create_Refrigerator_correctParameters() throws WrongApplianceArgumentsException {

        Appliance expected = new Refrigerator(5, 100, 20, 10, 300, 200, 70);

        Appliance actual = creator.create("Refrigerator : POWER_CONSUMPTION=100, WEIGHT=20, FREEZER_CAPACITY=10, OVERALL_CAPACITY=300, HEIGHT=200, WIDTH=70;");

        assertEquals(expected, actual);
    }

    @Test
    public void create_Speakers_correctParameters() throws WrongApplianceArgumentsException {

        Appliance expected = new Speakers(5, 15, 2, "2-4", 2);

        Appliance actual = creator.create("Speakers : POWER_CONSUMPTION=15, NUMBER_OF_SPEAKERS=2, FREQUENCY_RANGE=2-4, CORD_LENGTH=2;");

        assertEquals(expected, actual);
    }


    @Test
    public void create_VacuumCleaner_correctParameters() throws WrongApplianceArgumentsException {

        Appliance expected = new VacuumCleaner(5, 100, "A", "A2", "all-in-one", 3000, 20);

        Appliance actual = creator.create("VacuumCleaner : POWER_CONSUMPTION=100, FILTER_TYPE=A, BAG_TYPE=A2, WAND_TYPE=all-in-one, MOTOR_SPEED_REGULATION=3000, CLEANING_WIDTH=20;");

        assertEquals(expected, actual);
    }

    @Test
    public void create_TabletPC_correctParameters() throws WrongApplianceArgumentsException {

        Appliance expected = new TabletPC(5, 3, 14, 8000, 2, "blue");

        Appliance actual = creator.create("TabletPC : BATTERY_CAPACITY=3, DISPLAY_INCHES=14, MEMORY_ROM=8000, FLASH_MEMORY_CAPACITY=2, COLOR=blue;");

        assertEquals(expected, actual);
    }

    @AfterClass
    public static void afterClass() {
        logger.info("\n\nApplianceCreatorImplTest finished!");
    }
}