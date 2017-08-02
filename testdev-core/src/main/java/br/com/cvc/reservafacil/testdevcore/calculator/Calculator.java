package br.com.cvc.reservafacil.testdevcore.calculator;

import java.math.BigDecimal;

/**
 * 
 * @author felipe.pelichero
 *
 * 2 de ago de 2017
 */
public interface Calculator<Calculable> {

	/**
	 * 
	 * @param dto
	 * @return
	 */
	public BigDecimal calculate(Calculable dto);
	
}
