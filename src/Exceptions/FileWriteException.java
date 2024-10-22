package Exceptions;

public class FileWriteException extends RuntimeException {
    public FileWriteException(String message) {
        super(message);
    }
}
