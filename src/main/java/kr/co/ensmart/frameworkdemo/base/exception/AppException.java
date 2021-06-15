package kr.co.ensmart.frameworkdemo.base.exception;

import lombok.Getter;

@Getter
public class AppException extends RuntimeException {
	private static final long serialVersionUID = 5736609807177979617L;

	private String errorCode;
	
    public AppException(String errorCode, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(errorCode, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
    }

    public AppException(String errorCode, Throwable cause) {
        super(errorCode, cause);
        this.errorCode = errorCode;
    }

    public AppException(String errorCode) {
        super(errorCode);
        this.errorCode = errorCode;
    }

}
