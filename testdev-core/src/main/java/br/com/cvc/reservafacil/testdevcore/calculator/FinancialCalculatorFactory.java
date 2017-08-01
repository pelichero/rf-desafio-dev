package br.com.cvc.reservafacil.testdevcore.calculator;

import java.text.MessageFormat;

import br.com.cvc.reservafacil.testdevcore.model.enums.TypeTransfEnum;

/**
 * 
 * @author felipe.pelichero
 *
 * 1 de ago de 2017
 */
public class FinancialCalculatorFactory {

	private static final String NO_CALCULATOR_ERROR = "Theres no calculator for the type [{0}]";
	private static FinancialCalculatorFactory INSTANCE;
	
	public static FinancialCalculatorFactory getInstance(){
		if(INSTANCE == null){
			INSTANCE = new FinancialCalculatorFactory();
		}		
		return INSTANCE;
	}
	
	/**
	 * 	
	 * @param type
	 * @return
	 */
	public FinancialCalculator createCalculator(TypeTransfEnum type){
		switch (type) {
			case A: return new FinancialTypeACalculator();
			case B: return new FinancialTypeBCalculator();
			case C: return new FinancialTypeCCalculator();
			case D: return new FinancialTypeDCalculator();
			default: throw new IllegalStateException(MessageFormat.format(NO_CALCULATOR_ERROR, type));
		}
	}
	
}
