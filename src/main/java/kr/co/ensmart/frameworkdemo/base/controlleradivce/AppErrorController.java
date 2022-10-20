package kr.co.ensmart.frameworkdemo.base.controlleradivce;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 컨틀롤러에서 발생한 오류 외의 오류처리를 담당한다. (컨틀롤러에서 발생한 오류는 ControllerAdvice의 handler가 처리)
 * spring boot에서 기본제공하는 BasicErrorController를 대체하는 클래스이다.
 * api 응답을 처리하려면 추가적인 보완이 필요한다.
 *  
 * @author choiyh44
 */
@Controller
public class AppErrorController implements ErrorController {

	@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {
	    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	    
	    if (status != null) {
	        Integer statusCode = Integer.valueOf(status.toString());
	    
	        if(statusCode == HttpStatus.NOT_FOUND.value()) {
	            return "error/4XX";
	        }
	        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	            return "error/5XX";
	        }
	    }
	    return "error";
	}
	
}
