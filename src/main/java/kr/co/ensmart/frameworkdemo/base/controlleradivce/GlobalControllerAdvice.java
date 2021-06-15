package kr.co.ensmart.frameworkdemo.base.controlleradivce;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import kr.co.ensmart.frameworkdemo.base.exception.AppException;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice(annotations = Controller.class)
@Order(Ordered.LOWEST_PRECEDENCE)
@Slf4j
public class GlobalControllerAdvice {
	public static final String API_REQUEST_URI_PART = "/api"; 
	public static final String HTTP_REQUEST_HEADER_ACCEPT = "Accept"; 
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object handleException(Exception e, HttpServletRequest request) {
		log.error("", e);
		if (isApiRequest(request)) {
			return handleApiException();
		}
		
		return "error/error";
    }
	
	@ExceptionHandler(AppException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleAppException(AppException e, HttpServletRequest request, Model model) {
		log.warn("", e);
		if (isApiRequest(request)) {
			return handleAppApiException(e);
		}
		model.addAttribute("message", e.getMessage());
		return "error/app-error";
    }

	private boolean isApiRequest(HttpServletRequest request) {
		String acceptHeader = request.getHeader(GlobalControllerAdvice.HTTP_REQUEST_HEADER_ACCEPT);
		if (StringUtils.contains(acceptHeader, MediaType.APPLICATION_JSON_VALUE)
				|| StringUtils.contains(request.getRequestURI(), GlobalControllerAdvice.API_REQUEST_URI_PART)) {
			return true;
		}
		return false;
	}

	@ResponseBody
	private ResponseEntity<ErrorResponse> handleApiException() { 
		// TODO Get message by message code. 
		return new ResponseEntity<>(new ErrorResponse("9000", "시스템오류가 발생했습니다."), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ResponseBody
    public ResponseEntity<ErrorResponse>  handleAppApiException(AppException e) {
		// TODO Get message by message code. 
		return new ResponseEntity<>(new ErrorResponse(e.getErrorCode(), "[TODO] Get message by message code."), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }


}
