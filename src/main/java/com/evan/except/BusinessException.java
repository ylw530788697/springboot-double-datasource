package com.evan.except;

/**
 * @author evanYang
 * @version 1.0
 * @date 04/11/2020 10:49
 */
public class BusinessException extends RuntimeException {
    private String message;
    private Throwable throwable;
    public BusinessException(String message) {
        this(message,null);
    }

    public BusinessException(String message,Throwable throwable) {
        super(message,throwable);
    }
}
