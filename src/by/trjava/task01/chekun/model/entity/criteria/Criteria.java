package by.trjava.task01.chekun.model.entity.criteria;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Criteria implements Cloneable {

    private static final Logger logger = Logger.getLogger(Criteria.class);

    private String groupSearchName;

    private Map<String, Object> criteria = new HashMap<String, Object>();

    public Criteria(String groupSearchName) {
        logger.debug("Criteria has created! GroupSearchName is  " + groupSearchName);
        this.groupSearchName = groupSearchName;
    }

    public String getGroupSearchName() {
        return groupSearchName;
    }

    public void add(String searchParameter, Object value) {
        criteria.putIfAbsent(searchParameter, value);
    }

    public Map<String, Object> getSearchCriteria() {

        Map<String, Object> cloneCriteria = new HashMap<>(criteria);

        return cloneCriteria;
    }


    @Override
    public String toString() {
        return getClass().getName() + "@" +
                " groupSearchName:" + groupSearchName +
                " criteria:" + criteria;
    }


}
