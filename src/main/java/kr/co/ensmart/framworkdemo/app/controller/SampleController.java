package kr.co.ensmart.framworkdemo.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.ensmart.framworkdemo.base.exception.AppException;

@Controller
@RequestMapping("/sample")
public class SampleController {
	@GetMapping("/main")
	String viewMain() {
		return "sample/main";
	}
	
	@GetMapping("/error")
	String viewSampleError() {
		String nullStr = null;
		
		// throw NullPointerException
		nullStr.charAt(0);
		
		return "sample/main"; // do not reach here.
	}

	@GetMapping("/app-error")
	String viewSampleAppError() {
		// throw AppException
		throw new AppException("Error code.");
		
	}

	@GetMapping("/show-error")
	String showSampleError() {
		return "error/error"; // do not reach here.
	}


}
