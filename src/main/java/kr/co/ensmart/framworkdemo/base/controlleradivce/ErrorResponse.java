package kr.co.ensmart.framworkdemo.base.controlleradivce;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
	String errorCode;
	String errorMessage;
}
