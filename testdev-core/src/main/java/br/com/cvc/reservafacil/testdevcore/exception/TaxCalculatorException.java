package br.com.cvc.reservafacil.testdevcore.exception;

public class TaxCalculatorException extends CalculatorBusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2585350908341713247L;

	public TaxCalculatorException() {
		super();
	}

	public TaxCalculatorException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TaxCalculatorException(String message, Throwable cause) {
		super(message, cause);
	}

	public TaxCalculatorException(String message) {
		super(message);
	}

	public TaxCalculatorException(Throwable cause) {
		super(cause);
	}	
}
