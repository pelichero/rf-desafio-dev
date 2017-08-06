package br.com.cvc.reservafacil.testdevcore.exception;

public class CalculatorBusinessException extends FinancialScheduleBusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2585350908341713247L;

	public CalculatorBusinessException() {
		super();
	}

	public CalculatorBusinessException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CalculatorBusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public CalculatorBusinessException(String message) {
		super(message);
	}

	public CalculatorBusinessException(Throwable cause) {
		super(cause);
	}	
}
