package br.com.cvc.reservafacil.testdevcore.calculator.links.tax.types;

import java.math.BigDecimal;
import java.text.MessageFormat;

import br.com.cvc.reservafacil.testdevcore.calculator.Calculator;
import br.com.cvc.reservafacil.testdevcore.model.FinancialTransferScheduleDTO;

/**
 * 
 * @author felipe.pelichero
 *
 * 1 de ago de 2017
 */
public class FinancialTypeACalculator implements Calculator<FinancialTransferScheduleDTO>{

	protected FinancialTypeACalculator() {}

	private static final Float TAX = 2.0F;
	private static final Float AMMOUNT_PERCENTAGE = 0.003F;
	
	@Override
	public BigDecimal calculate(FinancialTransferScheduleDTO dto) {
		
		if(dto == null){
			throw new IllegalStateException(MessageFormat.format("Financial transfer is null", dto));
		}
		
		if(dto.getTransfValue() == null){
			return BigDecimal.ZERO;
		}
		
		return dto.getTransfValue().multiply(new BigDecimal(AMMOUNT_PERCENTAGE)).add(new BigDecimal(TAX));
	}
}
