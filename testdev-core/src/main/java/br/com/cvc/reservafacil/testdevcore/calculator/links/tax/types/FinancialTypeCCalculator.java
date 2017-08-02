package br.com.cvc.reservafacil.testdevcore.calculator.links.tax.types;

import java.math.BigDecimal;

import br.com.cvc.reservafacil.testdevcore.calculator.Calculator;
import br.com.cvc.reservafacil.testdevcore.model.FinancialTransferScheduleDTO;

/**
 * 
 * @author felipe.pelichero
 *
 * 1 de ago de 2017
 */
public class FinancialTypeCCalculator implements Calculator<FinancialTransferScheduleDTO>{

	protected FinancialTypeCCalculator() {}
	
	@Override
	public BigDecimal calculate(FinancialTransferScheduleDTO dto) {
	
		return BigDecimal.TEN;
	}

}
