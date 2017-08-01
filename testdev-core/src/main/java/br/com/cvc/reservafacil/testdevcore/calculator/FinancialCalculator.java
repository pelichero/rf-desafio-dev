package br.com.cvc.reservafacil.testdevcore.calculator;

import br.com.cvc.reservafacil.testdevcore.model.FinancialTransferScheduleDTO;

/**
 * 
 * @author felipe.pelichero
 *
 * 1 de ago de 2017
 */
public interface FinancialCalculator {

	/**
	 * 
	 * @param financialTransferDTO
	 * @return
	 */
	public void calculateTax(FinancialTransferScheduleDTO financialTransferDTO);
	
}
