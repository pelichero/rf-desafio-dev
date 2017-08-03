package br.com.cvc.reservafacil.testdevcore.calculator.links.tax.types;

import java.math.BigDecimal;
import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cvc.reservafacil.testdevcore.calculator.Calculator;
import br.com.cvc.reservafacil.testdevcore.model.FinancialTransferScheduleDTO;

/**
 * 
 * @author felipe.pelichero
 *
 * 1 de ago de 2017
 */
@Component
public class FinancialTypeDCalculator implements Calculator<FinancialTransferScheduleDTO>{

	protected FinancialTypeDCalculator(){}
	
	@Autowired
	private FinancialCalculatorFactory factory;
	
	@Override
	public BigDecimal calculate(FinancialTransferScheduleDTO dto) {
		
		if(dto == null){
			throw new IllegalStateException(MessageFormat.format("Financial transfer is null.", dto));
		}
		
		if(dto.getTransfValue() == null){
			return BigDecimal.ZERO;
		}
		
		return factory.createCalculator(dto.getTransfValue()).calculate(dto); 
	}

}
