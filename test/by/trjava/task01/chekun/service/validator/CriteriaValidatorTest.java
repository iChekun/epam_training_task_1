package by.trjava.task01.chekun.service.validator;

import by.trjava.task01.chekun.model.entity.criteria.Criteria;
import by.trjava.task01.chekun.model.entity.criteria.SearchCriteria;
import by.trjava.task01.chekun.model.service.validator.CriteriaValidator;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CriteriaValidatorTest {
    private static final Logger logger = Logger.getLogger(CriteriaValidatorTest.class);

    @BeforeClass
    public static void beforeClass() {
        logger.info("\n\nCriteriaValidatorTest started!");
    }


    @Test
    public void validate_true() {
        Criteria criteria = new Criteria(SearchCriteria.Oven.class.getSimpleName());

        criteria.add(SearchCriteria.Oven.CAPACITY.toString(), 50);
        criteria.add(SearchCriteria.Oven.HEIGHT.toString(), 20);

        boolean result = CriteriaValidator.validate(criteria);

        assertTrue(result);
    }

    @Test
    public void validate_false() {
        Criteria criteria = new Criteria(SearchCriteria.Oven.class.getSimpleName());

        //  if we give the class fields that are not relevant to the desired

        criteria.add(SearchCriteria.Laptop.DISPLAY_INCHS.toString(), 50);
        criteria.add(SearchCriteria.Oven.HEIGHT.toString(), 20);

        boolean result = CriteriaValidator.validate(criteria);

        assertFalse(result);
    }

    @Test
    public void validate_badFields_false() {
        Criteria criteria = new Criteria(SearchCriteria.Oven.class.getSimpleName());

        //  if we give the class fields that are not relevant to the desired

        criteria.add(SearchCriteria.Laptop.DISPLAY_INCHS.toString(), 50);
        criteria.add(SearchCriteria.Oven.HEIGHT.toString(), 20);
        criteria.add(SearchCriteria.VacuumCleaner.BAG_TYPE.toString(), "AA");
        criteria.add(SearchCriteria.Oven.CAPACITY.toString(), 1000);

        boolean result = CriteriaValidator.validate(criteria);

        assertFalse(result);
    }

    @Test
    public void validate_nullCriteria_false() {
        Criteria criteria = null;

        boolean result = CriteriaValidator.validate(criteria);

        assertFalse(result);
    }


    @Test
    public void validate_null_GroupName_false() {
        Criteria criteria = new Criteria(null);

        boolean result = CriteriaValidator.validate(criteria);

        assertFalse(result);
    }

    @Test
    public void validate_null_SearchParameter_false() {
        Criteria criteria = new Criteria(SearchCriteria.Oven.class.getSimpleName());

        criteria.add(null, 50);

        boolean result = CriteriaValidator.validate(criteria);

        assertFalse(result);
    }

    @Test
    public void validate_null_ValueParameter_false() {
        Criteria criteria = new Criteria(SearchCriteria.Oven.class.getSimpleName());

        criteria.add(SearchCriteria.Oven.CAPACITY.toString(), null);

        boolean result = CriteriaValidator.validate(criteria);

        assertFalse(result);
    }


    @Test
    public void validate_null_ValueParameter_null_SearchParameter_false() {
        Criteria criteria = new Criteria(SearchCriteria.Oven.class.getSimpleName());

        criteria.add(null, null);

        boolean result = CriteriaValidator.validate(criteria);

        assertFalse(result);
    }


    @Test
    public void validate_badSearchClassName_false() {
        Criteria criteria = new Criteria("Ove");

        boolean result = CriteriaValidator.validate(criteria);

        assertFalse(result);
    }

    @Test
    public void validate_badSearchClassName_2_false() {
        Criteria criteria = new Criteria("Lapt");

        boolean result = CriteriaValidator.validate(criteria);

        assertFalse(result);
    }


    @AfterClass
    public static void afterClass() {
        logger.info("\n\nCriteriaValidatorTest finished!!");
    }
}