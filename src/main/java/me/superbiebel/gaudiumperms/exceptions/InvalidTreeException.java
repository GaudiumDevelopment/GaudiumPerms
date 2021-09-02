package me.superbiebel.gaudiumperms.exceptions;

public class InvalidTreeException extends Exception{
    public InvalidTreeException() {
    }

    public InvalidTreeException(String message) {
        super(message);
    }

    public InvalidTreeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidTreeException(Throwable cause) {
        super(cause);
    }

    public InvalidTreeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
