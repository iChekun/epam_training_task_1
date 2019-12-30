package by.trjava.task01.chekun.model.dao.exception;

public class NoCorrectAppliancesInFileException extends Exception {

    public NoCorrectAppliancesInFileException() {
        super();
    }

    public NoCorrectAppliancesInFileException(String message) {
        super(message);
    }

    public NoCorrectAppliancesInFileException(Throwable cause) {
        super(cause);
    }

    public NoCorrectAppliancesInFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
