package by.trjava.task01.chekun.model.service.impl;

import by.trjava.task01.chekun.model.dao.ApplianceDAO;
import by.trjava.task01.chekun.model.dao.DAOFactory;
import by.trjava.task01.chekun.model.dao.exception.NoCorrectAppliancesInFileException;
import by.trjava.task01.chekun.model.entity.Appliance;
import by.trjava.task01.chekun.model.entity.criteria.Criteria;
import by.trjava.task01.chekun.model.dao.exception.FileReadingException;
import by.trjava.task01.chekun.model.dao.exception.NoSearchedDataFileException;
import by.trjava.task01.chekun.model.service.exception.NoMatchSearchException;
import by.trjava.task01.chekun.model.service.exception.WrongSearchCriteriaException;
import by.trjava.task01.chekun.model.service.validator.CriteriaValidator;
import by.trjava.task01.chekun.model.service.ApplianceService;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;


public class ApplianceServiceImpl implements ApplianceService {

    private static final Logger logger = Logger.getLogger(ApplianceServiceImpl.class);

    /**
     * Method find classes with given criteria in class storage
     *
     * @param criteria {@code Criteria} fields with value for search
     * @return {@code List<Appliance>} list with found classes
     * @throws NoMatchSearchException       throws if the search returned no results
     * @throws WrongSearchCriteriaException throws if criteria for search not valid
     * @see Criteria
     * @see CriteriaValidator
     * @see DAOFactory
     * @see ApplianceDAO
     */
    @Override
    public List<Appliance> find(final Criteria criteria) throws NoMatchSearchException,
                                                                WrongSearchCriteriaException {

        logger.debug("Method find() starting. Received arguments: " + criteria.toString());

        if (CriteriaValidator.validate(criteria)) {
            logger.debug("Criteria is correct!");

            DAOFactory factory = DAOFactory.getInstance();
            ApplianceDAO applianceDAO = factory.getApplianceDAO();

            try {
                final List<Appliance> appliances = applianceDAO.find(criteria);
                logger.debug("Received appliances list:  " + Arrays.toString(appliances.toArray()));
                return appliances;
            } catch (FileReadingException | NoSearchedDataFileException | NoCorrectAppliancesInFileException e) {
                logger.debug("Method find() caught exception:" + e.getMessage());
                throw new NoMatchSearchException("Method find() caught exception: " + e.getMessage());
            }
        }

        logger.debug("Method find() received bad criteria for search");

        throw new WrongSearchCriteriaException(
                "Method find() received bad criteria for search (Criteria group name does not contain this field(s)): "
                        + " Criteria group name: " + criteria.getGroupSearchName()
                        + " , Fields with values: " + criteria.getSearchCriteria().toString());
    }
}
