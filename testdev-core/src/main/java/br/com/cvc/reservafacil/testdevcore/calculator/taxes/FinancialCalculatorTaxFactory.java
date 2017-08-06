package br.com.cvc.reservafacil.testdevcore.calculator.taxes;

import java.math.BigDecimal;
import java.text.MessageFormat;

import org.springframework.stereotype.Component;

import br.com.cvc.reservafacil.testdevcore.calculator.Calculator;
import br.com.cvc.reservafacil.testdevcore.exception.TaxCalculatorException;
import br.com.cvc.reservafacil.testdevcore.model.FinancialTransferScheduleDTO;

/**
 * 
 * @author felipe.pelichero
 *
 * 1 de ago de 2017
 */
@Component
public class FinancialCalculatorTaxFactory {

	private static final double C_TYPE_TAXES = 120000d;
	private static final double B_TYPE_TAXES = 25001d;
	private static final double A_TYPE_TAXES = 25000d;
	private static final String NO_VALUE_TO_CALCULATE_MSG_ERROR = "No value to calculate.";
	private static final String DTO_NULL_MSG_ERROR = "Error on creating calculator, financial transfer is null.";
	private static final String NO_CALCULATOR_ERROR = "Theres no calculator for the type [{0}]";
	
	/**
	 * 	
	 * @param type
	 * @return
	 */
	public Calculator<FinancialTransferScheduleDTO> createCalculator(FinancialTransferScheduleDTO dto) throws TaxCalculatorException{
		if(dto == null){
			throw new TaxCalculatorException(DTO_NULL_MSG_ERROR);
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
	private Calculator<FinancialTransferScheduleDTO> createCalculator(BigDecimal value) throws TaxCalculatorException{
		
		if(value == null){
			throw new TaxCalculatorException(NO_VALUE_TO_CALCULATE_MSG_ERROR); 
		}
		
		if(value.doubleValue() <= A_TYPE_TAXES){
			return new FinancialTypeACalculator();
		} 
		
		if(value.doubleValue() >= B_TYPE_TAXES && value.doubleValue() <= C_TYPE_TAXES){
			return new FinancialTypeBCalculator();
		}
		
		if(value.doubleValue() > C_TYPE_TAXES){
			return new FinancialTypeCCalculator();
		}
		
		throw new TaxCalculatorException(NO_VALUE_TO_CALCULATE_MSG_ERROR);
	}
	
}
