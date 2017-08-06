package br.com.cvc.reservafacil.testdevcore.calculator;

import br.com.cvc.reservafacil.testdevcore.exception.CalculatorBusinessException;
import br.com.cvc.reservafacil.testdevcore.model.Calculable;

/**
 * 
 * @author felipe.pelichero
 *
 * 2 de ago de 2017
 */
public abstract class FinancialCalculatorChain<T extends Calculable>{
	
	protected FinancialCalculatorChain<?> next;
	protected Calculable calculated;
	
	public FinancialCalculatorChain(FinancialCalculatorChain<?> chain) {
		setNext(chain);
	}
	
	public void setNext(FinancialCalculatorChain<?> calcChain) {
		if (next == null) {
			next = calcChain;
		} else {
			next.setNext(calcChain);
		}
	}
	
	public abstract T calculate(T dto) throws CalculatorBusinessException;
}