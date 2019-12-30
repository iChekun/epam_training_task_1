package by.trjava.task01.chekun.model.util.factory;

import by.trjava.task01.chekun.model.entity.Appliance;
import by.trjava.task01.chekun.model.util.exception.WrongApplianceArgumentsException;

public interface ApplianceFactory {

    Appliance createAppliance(final int id, final String[] parameters) throws WrongApplianceArgumentsException;

}
