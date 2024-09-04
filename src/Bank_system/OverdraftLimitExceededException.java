package Bank_system;

public class OverdraftLimitExceededException extends Exception {
    public OverdraftLimitExceededException(String message) {
        super(message);
    }
}