package br.com.cvc.reservafacil.testdevcore.calculator.links.tax.types;

import java.math.BigDecimal;
import java.text.MessageFormat;

import org.springframework.stereotype.Component;

import br.com.cvc.reservafacil.testdevcore.calculator.Calculator;
import br.com.cvc.reservafacil.testdevcore.model.FinancialTransferScheduleDTO;

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
	public Calculator<FinancialTransferScheduleDTO> createCalculator(FinancialTransferScheduleDTO dto){
		if(dto == null){
			throw new IllegalStateException("Error on creating calculator, financial transfer is null.");
		}
		
		switch (dto.getTypeTransf()) {
			case A: return new FinancialTypeACalculator();
			case B: return new FinancialTypeBCalculator();
			case C: return new FinancialTypeCCalculator();
			case D: return createCalculator(dto.getTransfValue());
			default: throw new IllegalStateException(MessageFormat.format(NO_CALCULATOR_ERROR, dto.getTypeTransf()));
		}
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 * 
	 * TODO refatorar
	 */
	private Calculator<FinancialTransferScheduleDTO> createCalculator(BigDecimal value){
		
		if(value == null){
			throw new IllegalStateException("No value to calculate."); 
		}
		
		if(value.doubleValue() <= 25000d){
			return new FinancialTypeACalculator();
		} 
		
		if(value.doubleValue() > 25000d && value.doubleValue() <= 120000d){
			return new FinancialTypeBCalculator();
		}
		
		if(value.doubleValue() > 120000d){
			return new FinancialTypeCCalculator();
		}
		
		throw new IllegalStateException("No value to calculate.");
	}
	
}
