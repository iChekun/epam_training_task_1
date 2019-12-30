package by.trjava.task01.chekun.model.dao;

import by.trjava.task01.chekun.model.dao.impl.FileApplianceDAOImpl;

public final class DAOFactory {

    private static DAOFactory instance = new DAOFactory();

    private DAOFactory() { }

    private ApplianceDAO applianceDAO = new FileApplianceDAOImpl();

    public static DAOFactory getInstance() {
        return instance;
    }

    public ApplianceDAO getApplianceDAO() {
        return applianceDAO;
    }
}
