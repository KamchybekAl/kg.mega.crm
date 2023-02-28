package enums.exception;

public class WrongCommandException extends RuntimeException{
    public WrongCommandException(String message) {
        super(message);
        System.out.println(" You write wrong command, please check and write again SAVE or FINDALL  - nothing else.");

    }
}
