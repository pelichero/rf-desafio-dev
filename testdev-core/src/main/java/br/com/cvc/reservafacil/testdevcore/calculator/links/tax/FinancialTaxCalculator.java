package br.com.cvc.reservafacil.testdevcore.calculator.links.tax;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cvc.reservafacil.testdevcore.calculator.chain.FinancialCalculatorChain;
import br.com.cvc.reservafacil.testdevcore.calculator.links.tax.types.FinancialCalculatorFactory;
import br.com.cvc.reservafacil.testdevcore.model.FinancialTransferScheduleDTO;

/**
 * 
 * @author felipe.pelichero
 *
 * 2 de ago de 2017
 */
@Component
public class FinancialTaxCalculator extends FinancialCalculatorChain<FinancialTransferScheduleDTO>{

	@Autowired
	private FinancialCalculatorFactory factory;

	public FinancialTaxCalculator(){
		super(null);
	}
	
	public FinancialTaxCalculator(FinancialCalculatorChain<?> chain) {
		super(chain);
	}

	@Override
	public FinancialTransferScheduleDTO calculate(FinancialTransferScheduleDTO dto) {
		BigDecimal tax = factory.createCalculator(dto).calculate(dto);
		
		dto.setTax(tax.floatValue());
		
		return dto; 
	}
}
