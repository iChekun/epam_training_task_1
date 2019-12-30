package by.trjava.task01.chekun.model.dao.impl;

import by.trjava.task01.chekun.model.dao.ApplianceDAO;
import by.trjava.task01.chekun.model.dao.DAOFactory;
import by.trjava.task01.chekun.model.dao.exception.FileReadingException;
import by.trjava.task01.chekun.model.dao.exception.NoCorrectAppliancesInFileException;
import by.trjava.task01.chekun.model.dao.exception.NoSearchedDataFileException;
import by.trjava.task01.chekun.model.entity.*;
import by.trjava.task01.chekun.model.entity.criteria.Criteria;
import by.trjava.task01.chekun.model.entity.criteria.SearchCriteria;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FileApplianceDAOImplTest {

    private static final Logger logger = Logger.getLogger(FileApplianceDAOImplTest.class);

    private DAOFactory factory = DAOFactory.getInstance();

    private ApplianceDAO applianceDAO = factory.getApplianceDAO();

    @BeforeClass
    public static void beforeClass() {
        logger.info("\n\nFileApplianceDAOImplTest test starting!");
    }

    @Test
    public void find_correctCriteria_Oven_true() throws NoSearchedDataFileException, NoCorrectAppliancesInFileException, FileReadingException {

        Criteria criteria = new Criteria(SearchCriteria.Oven.class.getSimpleName());

        criteria.add(SearchCriteria.Oven.POWER_CONSUMPTION.toString(), 1000);


        List<Appliance> applianceList = applianceDAO.find(criteria);

        //Oven : POWER_CONSUMPTION=1000, WEIGHT=10, CAPACITY=32, DEPTH=60, HEIGHT=45.5, WIDTH=59.5;

        Appliance expected = new Oven(1, 1000, 10, 32, 60, 45.5, 59.5);

        Appliance result = applianceList.get(0);

        assertEquals(expected, result);
    }



    @Test
    public void find_correctCriteria_laptop_true() throws NoSearchedDataFileException, NoCorrectAppliancesInFileException, FileReadingException {

        Criteria criteria = new Criteria(SearchCriteria.Laptop.class.getSimpleName());

        criteria.add(SearchCriteria.Laptop.BATTERY_CAPACITY.toString(), 1);
        criteria.add(SearchCriteria.Laptop.OS.toString(), "windows");

        List<Appliance> applianceList = applianceDAO.find(criteria);

        //Laptop : BATTERY_CAPACITY=1, OS=Windows, MEMORY_ROM=4000, SYSTEM_MEMORY=1000, CPU=1.2, DISPLAY_INCHS=18

        Appliance expected = new Laptop(1, 1, "windows", 4000, 1000, 1.2, 18);

        Appliance result = applianceList.get(0);

        assertEquals(expected, result);
    }


    @Test
    public void find_correctCriteria_Refrigerator_true() throws NoSearchedDataFileException, NoCorrectAppliancesInFileException, FileReadingException {

        Criteria criteria = new Criteria(SearchCriteria.Refrigerator.class.getSimpleName());

        criteria.add(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString(), 300);
        criteria.add(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString(), 10);
        criteria.add(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString(), 100);

        List<Appliance> applianceList = applianceDAO.find(criteria);

        //Refrigerator : POWER_CONSUMPTION=100, WEIGHT=20, FREEZER_CAPACITY=10, OVERALL_CAPACITY=300, HEIGHT=200, WIDTH=70

        Appliance expected = new Refrigerator(1, 100, 20, 10, 300, 200, 70);

        Appliance result = applianceList.get(0);

        assertEquals(expected, result);
    }

    @Test
    public void find_correctCriteria_Speakers_true() throws NoSearchedDataFileException, NoCorrectAppliancesInFileException, FileReadingException {

        Criteria criteria = new Criteria(SearchCriteria.Speakers.class.getSimpleName());

        criteria.add(SearchCriteria.Speakers.FREQUENCY_RANGE.toString(), "2-4");
        criteria.add(SearchCriteria.Speakers.CORD_LENGTH.toString(), 2);


        List<Appliance> applianceList = applianceDAO.find(criteria);

        //Speakers : POWER_CONSUMPTION=15, NUMBER_OF_SPEAKERS=2, FREQUENCY_RANGE=2-4, CORD_LENGTH=2

        Appliance expected = new Speakers(1, 15, 2, "2-4", 2);

        Appliance result = applianceList.get(0);

        assertEquals(expected, result);
    }


    @Test
    public void find_correctCriteria_Tablet_PC_true() throws NoSearchedDataFileException, NoCorrectAppliancesInFileException, FileReadingException {

        Criteria criteria = new Criteria(SearchCriteria.TabletPC.class.getSimpleName());

        criteria.add(SearchCriteria.TabletPC.COLOR.toString(), "blue");


        List<Appliance> applianceList = applianceDAO.find(criteria);

        //TabletPC : BATTERY_CAPACITY=3, DISPLAY_INCHES=14, MEMORY_ROM=8000, FLASH_MEMORY_CAPACITY=2, COLOR=blue

        Appliance expected = new TabletPC(1, 3, 14, 8000, 2, "blue");

        Appliance result = applianceList.get(0);

        assertEquals(expected, result);
    }


    @Test
    public void find_correctCriteria_VacuumCleaner_true() throws NoSearchedDataFileException, NoCorrectAppliancesInFileException, FileReadingException {

        Criteria criteria = new Criteria(SearchCriteria.VacuumCleaner.class.getSimpleName());

        criteria.add(SearchCriteria.VacuumCleaner.WAND_TYPE.toString(), "all-in-one");
        criteria.add(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString(), 2900);

        List<Appliance> applianceList = applianceDAO.find(criteria);

        //VacuumCleaner : POWER_CONSUMPTION=110, FILTER_TYPE=B, BAG_TYPE=AA-89, WAND_TYPE=all-in-one, MOTOR_SPEED_REGULATION=2900, CLEANING_WIDTH=25

        Appliance expected = new VacuumCleaner(1, 110, "B", "AA-89", "all-in-one", 2900, 25);

        Appliance result = applianceList.get(0);

        assertEquals(expected, result);
    }

    @Test(expected = NoCorrectAppliancesInFileException.class)
    public void find_badSearchCriteria_exception() throws NoSearchedDataFileException, NoCorrectAppliancesInFileException, FileReadingException {
        Criteria criteria = new Criteria(SearchCriteria.Oven.class.getSimpleName());

        criteria.add(SearchCriteria.Oven.WEIGHT.toString(), 40000);

        List<Appliance> result = applianceDAO.find(criteria);
        ///Oven :  WEIGHT=40000, CAPACITY=32, DEPTH=60, HEIGHT=45.5, WIDTH=59.5;
    }

    @Test(expected = NoSearchedDataFileException.class)
    public void find_badSearchCriteria_exception_2() throws NoSearchedDataFileException, NoCorrectAppliancesInFileException, FileReadingException {
        Criteria criteria = new Criteria(SearchCriteria.Oven.class.getSimpleName());

        criteria.add(SearchCriteria.Oven.WEIGHT.toString(), "bad");

        List<Appliance> result = applianceDAO.find(criteria);
        ///Oven :  WEIGHT=40000, CAPACITY=32, DEPTH=60, HEIGHT=45.5, WIDTH=59.5;
    }

    @AfterClass
    public static void afterClass() {
        logger.info("\n\nFileApplianceDAOImplTest test finished!");
    }
}