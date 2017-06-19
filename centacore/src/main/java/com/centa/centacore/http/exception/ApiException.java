package com.centa.centacore.http.exception;

/**
 * Created by yanwenqiang on 17/6/19.
 * <p>
 * 描述:API Exception
 */

public final class ApiException extends RuntimeException {

    public final int code;
    public final String message;

    public ApiException(int code) {
        this(code, null);
    }

    public ApiException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
