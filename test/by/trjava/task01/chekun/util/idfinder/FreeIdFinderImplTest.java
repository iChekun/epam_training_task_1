package by.trjava.task01.chekun.util.idfinder;

import by.trjava.task01.chekun.model.util.UtilFactory;
import by.trjava.task01.chekun.model.util.idfinder.FreeIdFinder;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class FreeIdFinderImplTest {

    private static Logger logger = Logger.getLogger(FreeIdFinderImplTest.class);
    private UtilFactory factory = UtilFactory.getInstance();
    private FreeIdFinder freeIdFinder = factory.getFreeIdFinder();

    @BeforeClass
    public static void beforeClass() {
        logger.info("\n\nFreeIdFinderTest started!");
    }

    @Test
    public void find_true() {
        //given
        //when
        int id = freeIdFinder.find();
        //then
        assertTrue(id >= 0 && id <= 100_000_000);
    }

    @AfterClass
    public static void afterClass() {
        logger.info("FreeIdFinderTest finished!");
    }

}