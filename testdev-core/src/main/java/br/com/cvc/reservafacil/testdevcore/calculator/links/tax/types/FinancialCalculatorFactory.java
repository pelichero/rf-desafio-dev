package br.com.cvc.reservafacil.testdevcore.calculator.links.tax.types;

import java.text.MessageFormat;

import org.springframework.stereotype.Component;

import br.com.cvc.reservafacil.testdevcore.calculator.Calculator;
import br.com.cvc.reservafacil.testdevcore.model.FinancialTransferScheduleDTO;
import br.com.cvc.reservafacil.testdevcore.model.enums.TypeTransfEnum;

/**
 * 
 * @author felipe.pelichero
 *
 * 1 de ago de 2017
 */
@Component
public class FinancialCalculatorFactory {

	private static final String NO_CALCULATOR_ERROR = "Theres no calculator for the type [{0}]";
	
	/**
	 * 	
	 * @param type
	 * @return
	 */
	public Calculator<FinancialTransferScheduleDTO> createCalculator(TypeTransfEnum type){
		switch (type) {
			case A: return new FinancialTypeACalculator();
			case B: return new FinancialTypeBCalculator();
			case C: return new FinancialTypeCCalculator();
			case D: return new FinancialTypeDCalculator();
			default: throw new IllegalStateException(MessageFormat.format(NO_CALCULATOR_ERROR, type));
		}
	}
	
}
