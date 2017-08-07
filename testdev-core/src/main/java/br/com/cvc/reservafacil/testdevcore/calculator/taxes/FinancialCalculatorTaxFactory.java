package br.com.cvc.reservafacil.testdevcore.calculator.taxes;

import java.math.BigDecimal;
import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private final Logger Logger = LoggerFactory.getLogger(this.getClass());

	private static final double C_TYPE_TAXES = 120000d;
	private static final double B_TYPE_TAXES = 25001d;
	private static final double A_TYPE_TAXES = 25000d;

	private static final String NO_VALUE_TO_CALCULATE_MSG_ERROR = "No value to calculate.";
	private static final String DTO_NULL_MSG_ERROR = "Error on creating calculator, financial transfer is null.";
	private static final String NO_CALCULATOR_ERROR = "Theres no calculator for the type [{0}]";
	private static final String TRANSFER_TYPE_IS_NULL_MSG_ERROR = "Transfer type is null";
	
	/**
	 * 	
	 * @param type
	 * @return
	 */
	public Calculator<FinancialTransferScheduleDTO> createCalculator(FinancialTransferScheduleDTO dto) throws TaxCalculatorException{
		if(dto == null){
			Logger.error(DTO_NULL_MSG_ERROR);
			throw new TaxCalculatorException(DTO_NULL_MSG_ERROR);
		}
		
		if(dto.getTypeTransf() == null){
			Logger.error(TRANSFER_TYPE_IS_NULL_MSG_ERROR);
			throw new TaxCalculatorException(TRANSFER_TYPE_IS_NULL_MSG_ERROR);
		}
		
		Logger.debug(MessageFormat.format(">>> Creating tax calculator of type: {0}", dto.getTypeTransf()));
		
		switch (dto.getTypeTransf()) {
			case A: 
				Logger.info(MessageFormat.format(">>> Creating Tax Calculator type: ", dto.getTypeTransf()));
				return new FinancialTypeACalculator();
			case B: 
				Logger.info(MessageFormat.format(">>> Creating Tax Calculator type: ", dto.getTypeTransf()));
				return new FinancialTypeBCalculator();
			case C:
				Logger.info(MessageFormat.format(">>> Creating Tax Calculator type: ", dto.getTypeTransf()));
				return new FinancialTypeCCalculator();
			case D:
				Logger.info(MessageFormat.format(">>> Creating Tax Calculator type: ", dto.getTypeTransf()));
				return createCalculator(dto.getTransfValue());
			default: 
				Logger.error(MessageFormat.format(NO_CALCULATOR_ERROR, dto.getTypeTransf()));
				throw new TaxCalculatorException(MessageFormat.format(NO_CALCULATOR_ERROR, dto.getTypeTransf()));
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
			Logger.error(NO_VALUE_TO_CALCULATE_MSG_ERROR);
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
		
		Logger.error(NO_VALUE_TO_CALCULATE_MSG_ERROR);
		throw new TaxCalculatorException(NO_VALUE_TO_CALCULATE_MSG_ERROR);
	}
	
}
