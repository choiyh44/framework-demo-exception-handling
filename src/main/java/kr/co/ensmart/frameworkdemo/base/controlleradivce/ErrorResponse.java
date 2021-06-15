package kr.co.ensmart.frameworkdemo.base.controlleradivce;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
	String errorCode;
	String errorMessage;
}
