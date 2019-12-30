package by.trjava.task01.chekun.dao.validator;

import by.trjava.task01.chekun.model.dao.validator.InputLineValidator;
import by.trjava.task01.chekun.model.entity.criteria.Criteria;
import by.trjava.task01.chekun.model.entity.criteria.SearchCriteria;
import by.trjava.task01.chekun.service.validator.CriteriaValidatorTest;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class InputLineValidatorTest {

    private static final Logger logger = Logger.getLogger(CriteriaValidatorTest.class);

    @BeforeClass
    public static void beforeClass() {
        logger.info("\n\nInputLineValidatorTest started!");
    }


    @Test
    public void validateInputLine_true(){
        Criteria criteria = new Criteria(SearchCriteria.Oven.class.getSimpleName());
        criteria.add(SearchCriteria.Oven.CAPACITY.toString(),32);

        String parameters = "Oven : POWER_CONSUMPTION=1000, WEIGHT=10, CAPACITY=32, DEPTH=60, HEIGHT=45.5, WIDTH=59.5;";

        InputLineValidator validator = new InputLineValidator(criteria);

        boolean result = validator.validate(parameters);

        assertTrue(result);
    }

    @Test
    public void validateInputLine_false(){
        Criteria criteria = new Criteria(SearchCriteria.Oven.class.getSimpleName());
        criteria.add(SearchCriteria.Oven.CAPACITY.toString(),55);

        String parameters = "Oven : POWER_CONSUMPTION=1000, WEIGHT=10, CAPACITY=32, DEPTH=60, HEIGHT=45.5, WIDTH=59.5;";

        InputLineValidator validator = new InputLineValidator(criteria);

        boolean result = validator.validate(parameters);

        assertFalse(result);
    }

    @AfterClass
    public static void afterClass() {
        logger.info("\n\nInputLineValidatorTest finished!!");
    }

}