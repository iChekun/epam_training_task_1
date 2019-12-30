package by.trjava.task01.chekun.model.util.creator;

import by.trjava.task01.chekun.model.entity.Appliance;
import by.trjava.task01.chekun.model.util.exception.WrongApplianceArgumentsException;

public interface ApplianceCreator {

    public Appliance create(String parameters) throws WrongApplianceArgumentsException;
}
