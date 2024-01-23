package com.uusudnd.api.exception;

public class MemberNotFound extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MemberNotFound(String message) {
        super(message);
    }
}
