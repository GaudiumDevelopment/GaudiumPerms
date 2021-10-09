package me.superbiebel.gaudiumperms.exceptions;

public class TooManyDoubleWildcardsException extends IllegalStateException{
    public TooManyDoubleWildcardsException() {
    }

    public TooManyDoubleWildcardsException(String message) {
        super(message);
    }

    public TooManyDoubleWildcardsException(String message, Throwable cause) {
        super(message, cause);
    }

    public TooManyDoubleWildcardsException(Throwable cause) {
        super(cause);
    }
}
