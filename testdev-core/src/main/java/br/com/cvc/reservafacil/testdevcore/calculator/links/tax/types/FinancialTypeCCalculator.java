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
		taxes.put(31, 1.2F);
		taxes.put(30, 2.1F);
		taxes.put(25, 4.3F);
		taxes.put(20, 5.4F);
		taxes.put(15, 6.7F);
		taxes.put(10, 7.4F);
		taxes.put(5,  8.3F);
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
		
		return dto.getTransfValue().add(new BigDecimal(taxes.get(taxes.ceilingKey(daysBetween(dto)))));
	}

	private int daysBetween(FinancialTransferScheduleDTO dto) {
		return new Long(DateUtils.daysBetween(LocalDate.now(), DateUtils.dateToTemporal(dto.getScheduleDate()))).intValue();
	}
}