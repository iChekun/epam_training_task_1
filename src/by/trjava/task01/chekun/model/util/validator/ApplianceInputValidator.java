package by.trjava.task01.chekun.model.util.validator;

public interface ApplianceInputValidator {

    public boolean isApplianceArgsCorrect(final String parameters);

    public  String[] parseStringIntoArgsArray(String line);
}
