package by.trjava.task01.chekun.model.util.idfinder;

import org.apache.log4j.Logger;

import java.util.Random;

/**
 * Class made by singleton. Using for find unique identificator for object.
 *
 * @author Ilya Chekun
 * @version 1.0
 * @see
 */
public class FreeIdFinderImpl implements FreeIdFinder {

    private static final Logger logger = Logger.getLogger(FreeIdFinderImpl.class);

    public int find() {
        logger.debug("freeIdFinder start working");
        //   Repository<Appliance> repository = ApplianceRepositoryImpl.getInstance();

       final Random random = new Random();
//        boolean notFound = true;
//        int id = random.nextInt(5005) * 10000;
//        while (notFound) {
//            notFound = false;
//          for (Appliance thing : repository.getApplianceList()) {
//                if (thing.getId() == id) {
//                 notFound = true;
//               }
//           }
//            id = random.nextInt(5005) * 10000;
//        }
        return random.nextInt(5005) * 10000;
    }
}
