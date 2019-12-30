package by.trjava.task01.chekun.controller;


import by.trjava.task01.chekun.model.entity.Appliance;
import by.trjava.task01.chekun.model.entity.criteria.Criteria;
import by.trjava.task01.chekun.model.entity.criteria.SearchCriteria;
import by.trjava.task01.chekun.model.service.ApplianceService;
import by.trjava.task01.chekun.model.service.ServiceFactory;
import by.trjava.task01.chekun.model.service.exception.NoMatchSearchException;
import by.trjava.task01.chekun.model.service.exception.WrongSearchCriteriaException;
import by.trjava.task01.chekun.model.service.validator.CriteriaValidator;
import by.trjava.task01.chekun.view.Printer;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class Main {


    public static void main(String[] args) throws CloneNotSupportedException {


        {
            ServiceFactory factory = ServiceFactory.getInstance();
            ApplianceService applianceService = factory.getApplianceService();

            Printer.print("\n\t\t\t\tWork has start!\n");

            ///in all place use type int because if it will double when i  will compare i will have not 60 but 60.0

            {
                Criteria ovenCriteria = new Criteria(SearchCriteria.Oven.class.getSimpleName());
                int powerConsumption = 2000;

                ovenCriteria.add(SearchCriteria.Oven.POWER_CONSUMPTION.toString(), powerConsumption);


                Printer.print("\nSearch  :  " + ovenCriteria.toString());
                try {
                    List<Appliance> result = applianceService.find(ovenCriteria);

                    Printer.print("Received:  " + Arrays.toString(result.toArray()));

                } catch (NoMatchSearchException | WrongSearchCriteriaException e) {
                    Printer.print(e);
                }
            }

            {
                Criteria ovenCriteria = new Criteria(SearchCriteria.Oven.class.getSimpleName());
                Printer.print("\nSearch  all Oven:  " + ovenCriteria.toString());

                try {
                    List<Appliance> result = applianceService.find(ovenCriteria);
                    Printer.print("Received:  " + Arrays.toString(result.toArray()));
                } catch (NoMatchSearchException | WrongSearchCriteriaException e) {
                    Printer.print(e);
                }
            }

            {
                Criteria laptopCriteria = new Criteria(SearchCriteria.Laptop.class.getSimpleName());
                int memoryRom = 8000;
                String OS = "linux";

                laptopCriteria.add(SearchCriteria.Laptop.MEMORY_ROM.toString(), memoryRom);
                laptopCriteria.add(SearchCriteria.Laptop.OS.toString(), OS);

                Printer.print("\nSearch  :  " + laptopCriteria.toString());
                try {
                    List<Appliance> result = applianceService.find(laptopCriteria);
                    Printer.print("Received:  " + Arrays.toString(result.toArray()));
                } catch (NoMatchSearchException | WrongSearchCriteriaException e) {
                    Printer.print(e);
                }

            }


            {
                Criteria refrigeratorCriteria = new Criteria(SearchCriteria.Refrigerator.class.getSimpleName());
                int freezerCapacity = 15;
                int weight = 30;
                int powerConsumption = 200;

                refrigeratorCriteria.add(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString(), freezerCapacity);
                refrigeratorCriteria.add(SearchCriteria.Refrigerator.WEIGHT.toString(), weight);
                refrigeratorCriteria.add(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString(), powerConsumption);

                Printer.print("\nSearch  :  " + refrigeratorCriteria.toString());
                try {
                    List<Appliance> result = applianceService.find(refrigeratorCriteria);
                    Printer.print("Received:  " + Arrays.toString(result.toArray()));
                } catch (NoMatchSearchException | WrongSearchCriteriaException e) {
                    Printer.print(e);
                }
            }

            {
                Criteria speakersCriteria = new Criteria(SearchCriteria.Speakers.class.getSimpleName());
                int numberOfSpeakers = 2;
                int powerConsumption = 15;

                speakersCriteria.add(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString(), numberOfSpeakers);
                speakersCriteria.add(SearchCriteria.Speakers.POWER_CONSUMPTION.toString(), powerConsumption);

                Printer.print("\nSearch  :  " + speakersCriteria.toString());
                try {
                    List<Appliance> result = applianceService.find(speakersCriteria);
                    Printer.print("Received:  " + Arrays.toString(result.toArray()));
                } catch (NoMatchSearchException | WrongSearchCriteriaException e) {
                    Printer.print(e);
                }

            }


            {
                Criteria tabletPCCriteria = new Criteria(SearchCriteria.TabletPC.class.getSimpleName());
                String color = "blue";

                tabletPCCriteria.add(SearchCriteria.TabletPC.COLOR.toString(), color);

                Printer.print("\nSearch  :  " + tabletPCCriteria.toString());
                try {
                    List<Appliance> result = applianceService.find(tabletPCCriteria);
                    Printer.print("Received:  " + Arrays.toString(result.toArray()));
                } catch (NoMatchSearchException | WrongSearchCriteriaException e) {
                    Printer.print(e);
                }

            }

            {
                Criteria vacuumCleanerCriteria = new Criteria(SearchCriteria.VacuumCleaner.class.getSimpleName());
                String bagType = "A2";
                String wandType = "all-in-one";
                int motorSpeedRegulation = 3000;

                vacuumCleanerCriteria.add(SearchCriteria.VacuumCleaner.BAG_TYPE.toString(), bagType);
                vacuumCleanerCriteria.add(SearchCriteria.VacuumCleaner.WAND_TYPE.toString(), wandType);
                vacuumCleanerCriteria.add(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString(), motorSpeedRegulation);

                Printer.print("\nSearch  :  " + vacuumCleanerCriteria.toString());
                try {
                    List<Appliance> result = applianceService.find(vacuumCleanerCriteria);
                    Printer.print("Received:  " + Arrays.toString(result.toArray()));
                } catch (NoMatchSearchException | WrongSearchCriteriaException e) {
                    Printer.print(e);
                }
            }

            {
                Criteria tabletCriteria = new Criteria(SearchCriteria.TabletPC.class.getSimpleName());
                Printer.print("\nSearch  all TabletPC:  " + tabletCriteria.toString());

                try {
                    List<Appliance> result = applianceService.find(tabletCriteria);
                    Printer.print("Received:  " + Arrays.toString(result.toArray()));
                } catch (NoMatchSearchException | WrongSearchCriteriaException e) {
                    Printer.print(e);
                }
            }

            //////bad criteria
            {
                Criteria vacuumCleanerCriteria = new Criteria(SearchCriteria.VacuumCleaner.class.getSimpleName());
                String bagType = "55";

                vacuumCleanerCriteria.add(SearchCriteria.VacuumCleaner.BAG_TYPE.toString(), bagType);

                Printer.print("\nSearch with bad criteria data :  " + vacuumCleanerCriteria.toString());
                try {
                    List<Appliance> result = applianceService.find(vacuumCleanerCriteria);
                    Printer.print("Received:  " + Arrays.toString(result.toArray()));
                } catch (NoMatchSearchException | WrongSearchCriteriaException e) {
                    Printer.print(e);
                }
            }
            ///wrong criteria fields
            {
                Criteria criteria = new Criteria(SearchCriteria.Oven.class.getSimpleName());
                int motorSpeedRegulation = 60;
                criteria.add(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString(), motorSpeedRegulation);

                Printer.print("\nSearch   with wrong criteria fields (Oven does not contain this field) :  " + criteria.toString());
                try {
                    List<Appliance> result = applianceService.find(criteria);
                    Printer.print("Received:  " + Arrays.toString(result.toArray()));
                } catch (NoMatchSearchException | WrongSearchCriteriaException e) {
                    Printer.print(e);
                }
            }

            ///contain appliance but they are not valid
            {
                Criteria criteria = new Criteria(SearchCriteria.Speakers.class.getSimpleName());
                int powerConsumption = 500000;
                criteria.add(SearchCriteria.Speakers.POWER_CONSUMPTION.toString(), powerConsumption);

                Printer.print("\nSearch  Speakers but it will be not valid :  " + criteria.toString());
                try {
                    List<Appliance> result = applianceService.find(criteria);
                    Printer.print("Received:  " + Arrays.toString(result.toArray()));
                } catch (NoMatchSearchException | WrongSearchCriteriaException e) {
                    Printer.print(e);
                }
            }


            Printer.print("\n\t\t\t\tWork has end!\n");
        }
    }
}
