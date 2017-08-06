package br.com.cvc.reservafacil.testdevcore.calculator.taxes;

import java.math.BigDecimal;
import java.text.MessageFormat;

import br.com.cvc.reservafacil.testdevcore.calculator.Calculator;
import br.com.cvc.reservafacil.testdevcore.exception.TaxCalculatorException;
import br.com.cvc.reservafacil.testdevcore.model.FinancialTransferScheduleDTO;

/**
 * 
 * @author felipe.pelichero
 *
 * 1 de ago de 2017
 */
public class FinancialTypeACalculator implements Calculator<FinancialTransferScheduleDTO>{

	private static final String NULL_TRANSFER_MSG_ERROR = "Financial transfer is null";

	protected FinancialTypeACalculator() {}

	private static final Float TAX = 2.0F;
	private static final Float AMMOUNT_PERCENTAGE = 0.003F;
	
	@Override
	public BigDecimal calculate(FinancialTransferScheduleDTO dto) throws TaxCalculatorException {
		
		if(dto == null){
			throw new TaxCalculatorException(MessageFormat.format(NULL_TRANSFER_MSG_ERROR, dto));
		}
		
		if(dto.getTransfValue() == null){
			return BigDecimal.ZERO;
		}
		
		return dto.getTransfValue().multiply(new BigDecimal(AMMOUNT_PERCENTAGE)).add(new BigDecimal(TAX));
	}
}
