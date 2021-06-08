package kr.co.ensmart.framworkdemo.base.controlleradivce;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import kr.co.ensmart.framworkdemo.base.exception.AppException;
import lombok.extern.slf4j.Slf4j;

// TODO RestController 클래스를 구분하영 작성할 경우 
// exception 처리를 별도의 RestControllerAdvice 구분해서 작성할수 잇다.
//@RestControllerAdvice(annotations = RestController.class)
//@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class GlobalRestControllerAdvice {

	@ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
		log.error("", e);
		return new ResponseEntity<>(new ErrorResponse("9000", "시스템오류가 발생했습니다."), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler(AppException.class)
    public ResponseEntity<ErrorResponse>  handleAppException(AppException e) {
		log.warn("", e);
		// TODO Get message by message code. 
		return new ResponseEntity<>(new ErrorResponse(e.getErrorCode(), "[TODO] Get message by message code."), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
