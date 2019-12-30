package by.trjava.task01.chekun.model.dao.validator;

import by.trjava.task01.chekun.model.entity.criteria.Criteria;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class InputLineValidator {

    private static final Logger logger = Logger.getLogger(InputLineValidator.class);

    private Map<String, Object> searchCriteria = new HashMap<String, Object>();
    //need because some appliances have the same fields
    private String searchGroupName;

    public InputLineValidator(Criteria searchCriteria) {
        logger.debug("InputLineValidator has created!");
        this.searchCriteria = searchCriteria.getSearchCriteria();
        this.searchGroupName = searchCriteria.getGroupSearchName();
        logger.debug("InputLineValidator fields: searchGroupName:" + this.searchGroupName + ",criteria:" + searchCriteria.toString());
    }

    /**
     * Check input line on matches with given criteria.
     *
     * @param line {@code String} received line
     * @return true -> if all criteria will find and appliance type will the same
     * false -> otherwise.
     */
    public boolean validate(final String line) {
        //Need to parse line into array because if i will do something like this:
        // searchCriteria.entrySet().stream().allMatch(s -> LINE.equalsIgnoreCase(s.getKey() + "=" + s.getValue().toString()));
        // where LINE  is a String line that i received,
        // if user will give something like: POWER_CONSUMPTION=2
        // and in file will line like: POWER_CONSUMPTION=2000
        // it will be equals and method will return TRUE, but it must retunt FALSE. By this way i`m parsing line in array before start find any criteria math
        final String[] values = parseLine(line);

        return line.contains(searchGroupName) &&
                searchCriteria
                        .entrySet()
                        .stream()
                        .allMatch
                                (s -> Arrays.stream(values).anyMatch(p -> p.equalsIgnoreCase(s.getKey() + "=" + s.getValue().toString())));
    }

    //parse a string into an array, at the places of which there will be fields with their values
    private static final String regex = "\\s*(\\s|,|:|;)\\s*";

    private final String[] parseLine(String line) {
        return line.split(regex);
    }
}
