package exception;

public class SalException extends Exception {
    public SalException() {
    }

    public SalException(String message) {
        super(message);
    }

    public SalException(Throwable cause) {
        super(cause);
    }
}
