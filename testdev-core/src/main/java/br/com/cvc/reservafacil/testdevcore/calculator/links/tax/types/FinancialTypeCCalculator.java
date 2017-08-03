package br.com.cvc.reservafacil.testdevcore.calculator.links.tax.types;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.NavigableMap;
import java.util.TreeMap;

import br.com.cvc.reservafacil.testdevcore.calculator.Calculator;
import br.com.cvc.reservafacil.testdevcore.model.FinancialTransferScheduleDTO;
import br.com.cvc.reservafacil.testdevcore.utils.DateUtils;

/**
 * 
 * @author felipe.pelichero
 *
 * 1 de ago de 2017
 */
public class FinancialTypeCCalculator implements Calculator<FinancialTransferScheduleDTO>{

	private static final NavigableMap<Integer, Float> taxes; 

	static{
		taxes = new TreeMap<>();		
		taxes.put(31, 0.012F);
		taxes.put(30, 0.021F);
		taxes.put(25, 0.043F);
		taxes.put(20, 0.054F);
		taxes.put(15, 0.067F);
		taxes.put(10, 0.074F);
		taxes.put(5,  0.083F);
	}	
	
	protected FinancialTypeCCalculator() {}
		
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
		
		return dto.getTransfValue().multiply(new BigDecimal(taxes.get(taxes.ceilingKey(daysBetween(dto)))));
	}

	private int daysBetween(FinancialTransferScheduleDTO dto) {
		return new Long(DateUtils.daysBetween(LocalDate.now(), DateUtils.dateToTemporal(dto.getScheduleDate()))).intValue();
	}
}