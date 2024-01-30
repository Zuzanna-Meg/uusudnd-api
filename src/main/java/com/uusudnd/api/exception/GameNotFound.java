package com.uusudnd.api.exception;

public class GameNotFound extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public GameNotFound(String message) {
        super(message);
    }
}
