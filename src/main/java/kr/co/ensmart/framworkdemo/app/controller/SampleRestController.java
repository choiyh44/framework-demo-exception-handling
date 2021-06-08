package kr.co.ensmart.framworkdemo.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ensmart.framworkdemo.base.exception.AppException;

@RestController
@RequestMapping("/sample/api")
public class SampleRestController {
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
		throw new AppException("app exception thrown.");
		
	}

}
