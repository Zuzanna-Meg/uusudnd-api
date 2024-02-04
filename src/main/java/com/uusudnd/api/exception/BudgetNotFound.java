package com.uusudnd.api.exception;

public class BudgetNotFound extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BudgetNotFound(String message) {
        super(message);
    }
}
