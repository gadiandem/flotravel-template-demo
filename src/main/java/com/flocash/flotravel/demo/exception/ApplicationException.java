package com.flocash.flotravel.demo.exception;

public class ApplicationException extends RuntimeException {
    private String code;
    private String msg;
    private int httpCode = 500;

    public ApplicationException(String code, String msg, int httpCode) {
        super(code + "-" + msg);
        this.code = code;
        this.msg = msg;
        this.httpCode = httpCode;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public ApplicationException(String code, String msg) {
        this(code, msg, 500);
    }
}
