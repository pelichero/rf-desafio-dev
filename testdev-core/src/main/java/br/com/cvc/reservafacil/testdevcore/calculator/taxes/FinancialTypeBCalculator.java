package br.com.cvc.reservafacil.testdevcore.calculator.taxes;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.time.LocalDate;

import br.com.cvc.reservafacil.testdevcore.calculator.Calculator;
import br.com.cvc.reservafacil.testdevcore.exception.TaxCalculatorException;
import br.com.cvc.reservafacil.testdevcore.model.FinancialTransferScheduleDTO;
import br.com.cvc.reservafacil.testdevcore.utils.DateUtils;

/**
 * 
 * @author felipe.pelichero
 *
 * 1 de ago de 2017
 */
public class FinancialTypeBCalculator implements Calculator<FinancialTransferScheduleDTO>{

	protected FinancialTypeBCalculator() {}
	
	private static final int DEAD_LINE = 30;
	private static final Float TAX_LATES = 10F;
	private static final Float TAX_IN_DUE_TIME = 8F;

	private static final String NULL_TRANSFER_MSG_ERROR = "Financial transfer is null";
	private static final String SCHEDULE_DATE_IS_NULL_MSG_ERROR = "Schedule date is null.";

	
	@Override
	public BigDecimal calculate(FinancialTransferScheduleDTO dto) throws TaxCalculatorException{
		
		if(dto == null){
			throw new TaxCalculatorException(MessageFormat.format(NULL_TRANSFER_MSG_ERROR, dto));
		}
		
		if(dto.getTransfValue() == null){
			return BigDecimal.ZERO;
		}
		
		if(dto.getScheduleDate() == null){
			throw new TaxCalculatorException(MessageFormat.format(SCHEDULE_DATE_IS_NULL_MSG_ERROR, dto));
		}
	
		return new BigDecimal(resolveTax(dto));
	}

	/**
	 * 
	 * @param dto
	 * @return
	 */
	private Float resolveTax(FinancialTransferScheduleDTO dto) {
		return (DateUtils.daysBetween(LocalDate.now(), DateUtils.dateToTemporal(dto.getScheduleDate())) > DEAD_LINE)? TAX_LATES : TAX_IN_DUE_TIME;
	}
}
