package br.com.cvc.reservafacil.testdevcore.calculator.chain;

/**
 * 
 * @author felipe.pelichero
 *
 * 2 de ago de 2017
 */
public abstract class FinancialCalculatorChain<Calculable>{
	
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
	
	public abstract Calculable calculate(Calculable dto);
}