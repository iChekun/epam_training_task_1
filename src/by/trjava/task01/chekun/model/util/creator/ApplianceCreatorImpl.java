package by.trjava.task01.chekun.model.util.creator;

import by.trjava.task01.chekun.model.entity.Appliance;
import by.trjava.task01.chekun.model.util.UtilFactory;
import by.trjava.task01.chekun.model.util.exception.WrongApplianceArgumentsException;
import by.trjava.task01.chekun.model.util.factory.ApplianceFactory;
import by.trjava.task01.chekun.model.util.factory.ApplianceFactoryImpl;
import by.trjava.task01.chekun.model.util.idfinder.FreeIdFinder;
import by.trjava.task01.chekun.model.util.idfinder.FreeIdFinderImpl;
import by.trjava.task01.chekun.model.util.validator.ApplianceInputValidator;
import by.trjava.task01.chekun.model.util.validator.impl.ApplianceInputValidatorImpl;
import org.apache.log4j.Logger;

/**
 * Class create any objects that implementing {@see Appliance}.
 *
 * @author Ilya Chekun
 * @version 1.0
 * @see Appliance
 * @see ApplianceInputValidatorImpl
 * @see FreeIdFinderImpl
 * @see ApplianceFactoryImpl
 */
public class ApplianceCreatorImpl implements ApplianceCreator {

    private static final Logger logger = Logger.getLogger(ApplianceCreatorImpl.class);

    /**
     * Creates and returns an object that implementing {@code Appliance} in accordance with given initial values.
     *
     * @param parameters {@code String} initial values
     * @return object with given parameters
     * @throws WrongApplianceArgumentsException throws if received wrong arguments.
     * @see Appliance
     */
    @Override
    public Appliance create(final String parameters) throws WrongApplianceArgumentsException {
        logger.debug("Method create() start working. Received arguments: " + parameters);

        UtilFactory utilFactory = UtilFactory.getInstance();
        ApplianceInputValidator validator = utilFactory.getApplianceInputValidator();

        if (parameters != null && validator.isApplianceArgsCorrect(parameters)) {

            final ApplianceFactory applianceFactory = utilFactory.getApplianceFactory();
            final FreeIdFinder freeIdFinder = utilFactory.getFreeIdFinder();

            final String[] inputValues = validator.parseStringIntoArgsArray(parameters);

            final int id = freeIdFinder.find(); // find new clear id

            final Appliance thing = applianceFactory.createAppliance(id, inputValues);

            logger.debug("Final appliance to return: " + thing);
            return thing;

        }
        logger.debug("Method create() received wrong parameters: " + parameters);
        throw new WrongApplianceArgumentsException("Method create() received wrong parameters: " + parameters);
    }
}
