package br.com.cvc.reservafacil.testdevcore.exception;

/**
 * 
 * @author felipe.pelichero
 *
 * 1 de ago de 2017
 */
public class FinancialScheduleBusinessException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FinancialScheduleBusinessException() {
		super();
	}

	public FinancialScheduleBusinessException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FinancialScheduleBusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public FinancialScheduleBusinessException(String message) {
		super(message);
	}

	public FinancialScheduleBusinessException(Throwable cause) {
		super(cause);
	}	
}