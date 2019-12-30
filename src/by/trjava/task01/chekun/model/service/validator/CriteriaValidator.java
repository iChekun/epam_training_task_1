package by.trjava.task01.chekun.model.service.validator;

import by.trjava.task01.chekun.model.entity.criteria.Criteria;
import by.trjava.task01.chekun.model.entity.criteria.SearchCriteria;
import org.apache.log4j.Logger;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CriteriaValidator {

    private static final Logger logger = Logger.getLogger(CriteriaValidator.class);

    //Map contain 1.Name of enum with types of fields of classes 2. References on all enums
    private static final Map<String, Class<? extends Enum<?>> > ENUMS_MAP = new HashMap<>();

    //there in static block init i put all names of enums and references on this enums
    static {
        ENUMS_MAP.put(SearchCriteria.Oven.class.getSimpleName(), SearchCriteria.Oven.class);
        ENUMS_MAP.put(SearchCriteria.Laptop.class.getSimpleName(), SearchCriteria.Laptop.class);
        ENUMS_MAP.put(SearchCriteria.Refrigerator.class.getSimpleName(), SearchCriteria.Refrigerator.class);
        ENUMS_MAP.put(SearchCriteria.TabletPC.class.getSimpleName(), SearchCriteria.TabletPC.class);
        ENUMS_MAP.put(SearchCriteria.Speakers.class.getSimpleName(), SearchCriteria.Speakers.class);
        ENUMS_MAP.put(SearchCriteria.VacuumCleaner.class.getSimpleName(), SearchCriteria.VacuumCleaner.class);
    }

    public static boolean validate(final Criteria criteria) {
        logger.debug("Criteria validation starting.");

        if (criteria != null) {

            logger.debug("Received criteria is not null");

            final String applianceGroupName = criteria.getGroupSearchName();

            if (applianceGroupName != null) {

                logger.debug("Appliance group name is not null. GroupName = " + applianceGroupName);

                final Map<String, Object> searchCriteria = criteria.getSearchCriteria();

                //get here enum with fields of class that chose for search
                final Class<? extends Enum<?>> enumWithSearchedFields = ENUMS_MAP.get(applianceGroupName);

                return !searchCriteria.values().contains(null)
                        && isCriteriaFieldsArgumentsCorrect(enumWithSearchedFields, searchCriteria);

            }
        }

        return false;
    }


    private static boolean isCriteriaFieldsArgumentsCorrect(final Class<? extends Enum<?>> e,
                                                            final Map<String, Object> criteria) {
        boolean result = false;

        if (e != null) { // if will received bad enum
            //I`m make String array from Map , but take only fields names
            final String[] expectedValues = Arrays.stream(e.getEnumConstants())
                                                                .map(Enum::name)
                                                                    .toArray(String[]::new);

            //i`m try to see all criteria fields from one class or maybe there contain fields from another
            result = Arrays.asList(expectedValues)
                                   .containsAll(
                                       criteria.keySet());
        }
        return result;
    }

    private CriteriaValidator() {
    }
}
