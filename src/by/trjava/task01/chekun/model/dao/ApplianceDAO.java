package by.trjava.task01.chekun.model.dao;

import by.trjava.task01.chekun.model.dao.exception.NoCorrectAppliancesInFileException;
import by.trjava.task01.chekun.model.dao.exception.NoSearchedDataFileException;
import by.trjava.task01.chekun.model.entity.Appliance;
import by.trjava.task01.chekun.model.entity.criteria.Criteria;
import by.trjava.task01.chekun.model.dao.exception.FileReadingException;

import java.util.List;

public interface ApplianceDAO {

    List<Appliance> find(Criteria criteria) throws FileReadingException,
                                                   NoSearchedDataFileException,
                                                   NoCorrectAppliancesInFileException;

}

