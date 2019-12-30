package by.trjava.task01.chekun.util.validator.impl;

import by.trjava.task01.chekun.model.util.UtilFactory;
import by.trjava.task01.chekun.model.util.validator.ApplianceInputValidator;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApplianceInputValidatorImplTest {
    private static final Logger logger = Logger.getLogger(ApplianceInputValidatorImplTest.class);
    private final UtilFactory factory = UtilFactory.getInstance();
    private ApplianceInputValidator validator = factory.getApplianceInputValidator();

    @BeforeClass
    public static void beforeClass() {
        logger.info("\n\nApplianceInputValidatorImplTest started!");
    }


    @Test
    public void parseLine_test() {
        String parameters = "Speakers : POWER_CONSUMPTION=15, NUMBER_OF_SPEAKERS=2, FREQUENCY_RANGE=2-4, CORD_LENGTH=2;";

        String[] expected = {"Speakers", "POWER_CONSUMPTION", "15", "NUMBER_OF_SPEAKERS", "2", "FREQUENCY_RANGE", "2-4", "CORD_LENGTH", "2"};

        String[] result = validator.parseStringIntoArgsArray(parameters);

        assertArrayEquals(expected, result);
    }

    @Test
    public void isApplianceCorrect_true() {
        String parameters = "Speakers : POWER_CONSUMPTION=15, NUMBER_OF_SPEAKERS=2, FREQUENCY_RANGE=2-4, CORD_LENGTH=2;";

        assertTrue(validator.isApplianceArgsCorrect(parameters));
    }

    @Test
    public void isApplianceCorrect_false() {
        String parameters = ": POWER_CONSUMPTION=15, NUMBER_OF_SPEAKERS=2, FREQUENCY_RANGE=2-4, CORD_LENGTH=2;";

        assertFalse(validator.isApplianceArgsCorrect(parameters));
    }

    @AfterClass
    public static void afterClass() {
        logger.info("\n\nApplianceInputValidatorImplTest finished!!");
    }
}