package br.com.cvc.reservafacil.testdevcore.exception;

/**
 * 
 * @author felipe.pelichero
 *
 * 1 de ago de 2017
 */
public class TaxCalculationBusinessException extends FinancialScheduleBusinessException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TaxCalculationBusinessException() {
		super();
	}

	public TaxCalculationBusinessException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TaxCalculationBusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public TaxCalculationBusinessException(String message) {
		super(message);
	}

	public TaxCalculationBusinessException(Throwable cause) {
		super(cause);
	}	
}