package br.com.cvc.reservafacil.testdevcore.calculator.links.tax.types;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.time.LocalDate;

import br.com.cvc.reservafacil.testdevcore.calculator.Calculator;
import br.com.cvc.reservafacil.testdevcore.model.FinancialTransferScheduleDTO;
import br.com.cvc.reservafacil.testdevcore.utils.DateUtils;

/**
 * 
 * @author felipe.pelichero
 *
 * 1 de ago de 2017
 */
public class FinancialTypeBCalculator implements Calculator<FinancialTransferScheduleDTO>{

	private static final int DEAD_LINE = 30;

	protected FinancialTypeBCalculator() {}
	
	private static final Float TAX_LATES = 10F;
	private static final Float TAX_IN_DUE_TIME = 8F;

	@Override
	public BigDecimal calculate(FinancialTransferScheduleDTO dto) {
		
		if(dto == null){
			throw new IllegalStateException(MessageFormat.format("Financial transfer is null.", dto));
		}
		
		if(dto.getTransfValue() == null){
			return BigDecimal.ZERO;
		}
		
		if(dto.getScheduleDate() == null){
			throw new IllegalStateException(MessageFormat.format("Schedule date is null.", dto));
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
