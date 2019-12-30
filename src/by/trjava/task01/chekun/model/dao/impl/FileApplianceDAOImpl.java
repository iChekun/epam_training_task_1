package by.trjava.task01.chekun.model.dao.impl;

import by.trjava.task01.chekun.model.dao.ApplianceDAO;
import by.trjava.task01.chekun.model.dao.exception.NoCorrectAppliancesInFileException;
import by.trjava.task01.chekun.model.dao.exception.NoSearchedDataFileException;
import by.trjava.task01.chekun.model.dao.validator.InputLineValidator;
import by.trjava.task01.chekun.model.entity.Appliance;
import by.trjava.task01.chekun.model.entity.criteria.Criteria;
import by.trjava.task01.chekun.model.dao.exception.FileReadingException;
import by.trjava.task01.chekun.model.util.UtilFactory;
import by.trjava.task01.chekun.model.util.creator.ApplianceCreator;
import by.trjava.task01.chekun.model.util.exception.WrongApplianceArgumentsException;
import by.trjava.task01.chekun.model.util.validator.impl.ApplianceInputValidatorImpl;
import org.apache.log4j.Logger;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class for find and validate parameters of Electrical Goods objects.
 * Class using {@see java.nio.file.Files} and {@see java.nio.file.Paths}.
 *
 * @author Ilya Chekun
 * @version 1.0
 * @see ApplianceInputValidatorImpl
 * @see FileReadingException
 * @see NoSearchedDataFileException
 */
public class FileApplianceDAOImpl implements ApplianceDAO {

    private static final Logger logger = Logger.getLogger(FileApplianceDAOImpl.class);


    private static final String FILE_PATH = "./resources\\appliances_db.txt";

    /**
     * Method search required appliances in file and return them in {@code List<Appliance> list}.
     * getParametersOfDesiredAppliances -> Reads file with data, check them with checker and return in {@code List<String> list} back
     * getSearchedAppliancesList -> creating {@code Appliance} if parameters correct and return {@code List<Appliance> }
     *
     * @param criteria criteria to search
     * @return {@code List<String>} with correct lines
     * @throws FileReadingException               throws if bad file FILE_PATH or can not open the file
     * @throws NoSearchedDataFileException        throws if file empty or file has zero correct lines
     * @throws NoCorrectAppliancesInFileException throws if all criteria will find, but appliance parameters will be not valid
     * @see InputLineValidator
     * @see UtilFactory
     * @see ApplianceCreator
     */
    @Override
    public List<Appliance> find(final Criteria criteria) throws FileReadingException,
                                                                NoSearchedDataFileException,
                                                                NoCorrectAppliancesInFileException {

        logger.debug("Method find() starting..");

        final List<String> appliancesParametersList = getParametersOfDesiredAppliances(criteria);

        final List<Appliance> appliances = getSearchedAppliancesList(appliancesParametersList);

        return appliances;
    }


    private List<String> getParametersOfDesiredAppliances(final Criteria criteria) throws FileReadingException,
                                                                                            NoSearchedDataFileException {

        logger.debug("getParametersOfDesiredAppliances() start working! ");
        final InputLineValidator inputLineValidator = new InputLineValidator(criteria);

        try (Stream<String> line = Files.lines(Paths.get(FILE_PATH))) {

            final List<String> appliancesParametersList = line.filter(inputLineValidator::validate).collect(Collectors.toList());

            if (appliancesParametersList.size() > 0) {
                logger.debug("List for return : " + Arrays.toString(appliancesParametersList.toArray()));
                return appliancesParametersList;
            }

        } catch (NullPointerException | IOException ex) {
            logger.debug("FileReading exception! " + ex.getMessage());
            throw new FileReadingException("Path (" + FILE_PATH + ") is incorrect. ", ex);
        }
        logger.debug("NoSearchedDataFileException! Criteria: " + criteria.toString());
        throw new NoSearchedDataFileException("File (" + FILE_PATH + ") does not contain lines with the required criteria. Criteria: " + criteria.toString());
    }


    private List<Appliance> getSearchedAppliancesList(final List<String> appliancesParametersList)
                                                                            throws NoCorrectAppliancesInFileException {

        logger.debug("File contain search criteria. List making has start. ");

        UtilFactory utilFactory = UtilFactory.getInstance();
        ApplianceCreator creator = utilFactory.getApplianceCreator();

        final List<Appliance> appliances = new ArrayList<>();

        for (String applianceParameters : appliancesParametersList) {

            //  i`m ignoring exception because if inputLineValidator for search say that line is correct, this does not mean that parameters for appliance is valid.
            //  So i try to create all objects that choose search inputLineValidator, ignoring if some of them will be not valid.
            //  If in end i will have appliance list size zero ,
            //  i will throw new exception in which i will say that file does not contain correct appliances
            try {
                final Appliance appliance = creator.create(applianceParameters);
                appliances.add(appliance);
                logger.debug("appliance added: " + appliance.toString());
            } catch (WrongApplianceArgumentsException ignore) {
                logger.debug("Not valid appliance:  " + ignore.getMessage());
            }

        }
        if (appliances.size() > 0) {
            logger.debug("Return the final list.");
            return appliances;
        }

        logger.debug("All found appliances are not valid!");
        throw new NoCorrectAppliancesInFileException("File (" + FILE_PATH + ") contain searched appliances but they are not valid!");
    }
}

 /*
    @Override
    public List<Appliance> find(final Criteria criteria) throws FileReadingException,
                                                                NoSearchedDataFileException,
                                                                NoCorrectAppliancesInFileException {
        logger.debug("Method find() starting..");

        UtilFactory utilFactory = UtilFactory.getInstance();
        ApplianceCreator creator = utilFactory.getApplianceCreator();
        InputLineValidator inputLineValidator = new InputLineValidator(criteria);

        try (Stream<String> line = Files.lines(Paths.get(FILE_PATH))) {
            System.out.println(line.toString());
            final List<String> appliancesParametersList = line.filter(inputLineValidator::validate).collect(Collectors.toList());

            if (appliancesParametersList.size() > 0) {

                final List<Appliance> appliances = new ArrayList<>();
                logger.debug("File contain search criteria. List making start");

                for (String applianceParameters : appliancesParametersList) {

                    //  i`m ignoring exception because if inputLineValidator for search say that line is correct, this does not mean that parameters for appliance is valid.
                    //  So i try to create all objects that choose search inputLineValidator, ignoring if some of them will be not valid.
                    //  If in end i will have appliance list size zero ,
                    //  i will throw new exception in which i will say that file does not contain correct appliances
                    try {
                        final Appliance appliance = creator.create(applianceParameters);
                        appliances.add(appliance);
                    } catch (WrongApplianceArgumentsException ignore) {
                        logger.debug("Not valid appliance:  " + ignore.getMessage());
                    }
                }

                if (appliances.size() > 0) {
                    logger.debug("Return the final list.");
                    return appliances;
                }
                logger.debug("File (" + FILE_PATH + ") contain searched appliances but they are not valid!");
                throw new NoCorrectAppliancesInFileException("File (" + FILE_PATH + ") contain searched appliances but they are not valid!");
            }

        } catch (NullPointerException | IOException ex) {
            logger.debug("Path (" + FILE_PATH + ") is incorrect. ", ex);
            throw new FileReadingException("Path (" + FILE_PATH + ") is incorrect. ", ex);
        }
        logger.debug("File (" + FILE_PATH + ") does not contain lines with the required criteria.");
        throw new NoSearchedDataFileException("File (" + FILE_PATH + ") does not contain lines with the required criteria. Criteria: " + criteria.toString());
    }
}*/
