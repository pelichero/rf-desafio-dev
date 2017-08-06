package br.com.cvc.reservafacil.testdevapi.bean;

/**
 * 
 * @author felipe.pelichero
 *
 * 6 de ago de 2017
 */
public class ErrorResponse {
	
	private int errorCode;
	private String message;

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ErrorResponse [errorCode=" + errorCode + ", message=" + message + "]";
	}
}