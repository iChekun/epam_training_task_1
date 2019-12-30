package by.trjava.task01.chekun.model.service;

import by.trjava.task01.chekun.model.entity.Appliance;
import by.trjava.task01.chekun.model.entity.criteria.Criteria;
import by.trjava.task01.chekun.model.service.exception.NoMatchSearchException;
import by.trjava.task01.chekun.model.service.exception.WrongSearchCriteriaException;

import java.util.List;

public interface ApplianceService {

    List<Appliance> find(Criteria criteria) throws NoMatchSearchException,
                                                   WrongSearchCriteriaException;
}
