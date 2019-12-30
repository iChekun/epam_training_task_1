package by.trjava.task01.chekun.model.dao.exception;

public class FileReadingException extends Exception {

    public FileReadingException() {
        super();
    }

    public FileReadingException(String message) {
        super(message);
    }

    public FileReadingException(Throwable cause) {
        super(cause);
    }

    public FileReadingException(String message, Throwable cause) {
        super(message, cause);
    }
}
