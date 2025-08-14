public class FailedSignificantlyException extends RuntimeException {
    public FailedSignificantlyException(String message) {
        super(message); // super(message) calls the constructor of the superclass (RuntimeException) with the provided message
        // learn super in lectL05 OO Inheritance
    }
}