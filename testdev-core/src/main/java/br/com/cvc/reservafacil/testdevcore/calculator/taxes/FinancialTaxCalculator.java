package br.com.cvc.reservafacil.testdevcore.calculator.taxes;

import java.math.BigDecimal;
import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cvc.reservafacil.testdevcore.calculator.FinancialCalculatorChain;
import br.com.cvc.reservafacil.testdevcore.exception.CalculatorBusinessException;
import br.com.cvc.reservafacil.testdevcore.model.FinancialTransferScheduleDTO;

/**
 * 
 * @author felipe.pelichero
 *
 * 2 de ago de 2017
 */
@Component
public class FinancialTaxCalculator extends FinancialCalculatorChain<FinancialTransferScheduleDTO>{

	private final Logger Logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FinancialCalculatorTaxFactory factory;

	public FinancialTaxCalculator(){
		super(null);
	}
	
	public FinancialTaxCalculator(FinancialCalculatorChain<?> chain) {
		super(chain);
	}

	@Override
	public FinancialTransferScheduleDTO calculate(FinancialTransferScheduleDTO dto) throws CalculatorBusinessException {
		Logger.info(">>> Calculating taxes");
		
		BigDecimal tax = factory.createCalculator(dto).calculate(dto);
		
		dto.setTax(tax.floatValue());
		
		Logger.info(MessageFormat.format(" >>> Financial transfer tax is calculated : {0}", dto.getTax()));
		
		return dto; 
	}
}