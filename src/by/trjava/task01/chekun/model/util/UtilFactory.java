package by.trjava.task01.chekun.model.util;

import by.trjava.task01.chekun.model.util.creator.ApplianceCreator;
import by.trjava.task01.chekun.model.util.creator.ApplianceCreatorImpl;
import by.trjava.task01.chekun.model.util.factory.ApplianceFactory;
import by.trjava.task01.chekun.model.util.factory.ApplianceFactoryImpl;
import by.trjava.task01.chekun.model.util.idfinder.FreeIdFinder;
import by.trjava.task01.chekun.model.util.idfinder.FreeIdFinderImpl;
import by.trjava.task01.chekun.model.util.validator.ApplianceInputValidator;
import by.trjava.task01.chekun.model.util.validator.impl.ApplianceInputValidatorImpl;

public final class UtilFactory {

    private static UtilFactory instance = new UtilFactory();

    private UtilFactory() { }

    private final ApplianceCreator applianceCreator = new ApplianceCreatorImpl();

    private final ApplianceInputValidator applianceInputValidator = new ApplianceInputValidatorImpl();

    private final ApplianceFactory applianceFactory = new ApplianceFactoryImpl();

    private final FreeIdFinder freeIdFinder = new FreeIdFinderImpl();

    public ApplianceCreator getApplianceCreator() {
        return applianceCreator;
    }

    public ApplianceInputValidator getApplianceInputValidator() {
        return applianceInputValidator;
    }

    public ApplianceFactory getApplianceFactory() {
        return applianceFactory;
    }

    public FreeIdFinder getFreeIdFinder() {
        return freeIdFinder;
    }

    public static UtilFactory getInstance() {
        return instance;
    }
}
