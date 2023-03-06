package com.woniuxy.exception;

public class ClazzNameExistException extends RuntimeException {
    public ClazzNameExistException() {
    }

    public ClazzNameExistException(String message) {
        super(message);
    }

    public ClazzNameExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClazzNameExistException(Throwable cause) {
        super(cause);
    }
}
