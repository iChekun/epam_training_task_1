package by.trjava.task01.chekun.model.service.exception;

public class NoMatchSearchException extends Exception {

    public NoMatchSearchException() {
        super();
    }


    public NoMatchSearchException(String message) {
        super(message);
    }

    public NoMatchSearchException(Throwable cause) {
        super(cause);
    }

    public NoMatchSearchException(String message, Throwable cause) {
        super(message, cause);
    }
}

