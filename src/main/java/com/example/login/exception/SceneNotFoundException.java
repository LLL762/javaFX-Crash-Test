package com.example.login.exception;

/**
 * 07/06/2022.
 *
 * @author Laurent Lamiral
 */
public class SceneNotFoundException extends RuntimeException {

    public SceneNotFoundException() {
    }

    public SceneNotFoundException(String message) {
        super(message);
    }

    public SceneNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SceneNotFoundException(Throwable cause) {
        super(cause);
    }

    public SceneNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
