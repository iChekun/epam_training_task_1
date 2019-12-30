package by.trjava.task01.chekun.model.service.exception;

public class WrongSearchCriteriaException extends Exception {

    public WrongSearchCriteriaException() {
        super();
    }

    public WrongSearchCriteriaException(String message) {
        super(message);
    }

    public WrongSearchCriteriaException(Throwable cause) {
        super(cause);
    }

    public WrongSearchCriteriaException(String message, Throwable cause) {
        super(message, cause);
    }
}