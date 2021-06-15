package kr.co.ensmart.frameworkdemo.base.exception;

public class AuthException extends AppException {
	private static final long serialVersionUID = 4276546708698438827L;

	public AuthException() {
        super("8000"); // TODO Use error code enum.
    }

}
