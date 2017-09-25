package br.com.cvc.reservafacil.testdevcore.exception;

public class TaxesCalculatorException
		extends CalculatorBusinessException {

	/**
	 *
	 */
	private static final long serialVersionUID = -2585350908341713247L;

	public TaxesCalculatorException() {
		super();
	}

	public TaxesCalculatorException(String message, Throwable cause, boolean enableSuppression,
					boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TaxesCalculatorException(String message, Throwable cause) {
		super(message, cause);
	}

	public TaxesCalculatorException(String message) {
		super(message);
	}

	public TaxesCalculatorException(Throwable cause) {
		super(cause);
	}	
}
