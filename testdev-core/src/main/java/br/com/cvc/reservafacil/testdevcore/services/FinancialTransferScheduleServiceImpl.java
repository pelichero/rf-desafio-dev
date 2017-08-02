package br.com.cvc.reservafacil.testdevcore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cvc.reservafacil.testdevcore.calculator.links.tax.FinancialTaxCalculator;
import br.com.cvc.reservafacil.testdevcore.exception.FinancialScheduleBusinessException;
import br.com.cvc.reservafacil.testdevcore.exception.TaxCalculationBusinessException;
import br.com.cvc.reservafacil.testdevcore.model.FinancialTransferScheduleDTO;

/**
 * 
 * @author felipe.pelichero
 *
 * 2 de ago de 2017
 */
@Component
public class FinancialTransferScheduleServiceImpl implements FinancialTransferScheduleService{

	@Autowired
	private FinancialTaxCalculator calculator;
	
	@Override
	public FinancialTransferScheduleDTO scheduleTransfer(FinancialTransferScheduleDTO scheduleFinancialTransfer) throws FinancialScheduleBusinessException {
		if(scheduleFinancialTransfer == null){
			throw new IllegalStateException("Financial schedule is null.");
		}
		
		if(scheduleFinancialTransfer.getTypeTransf() == null){
			throw new TaxCalculationBusinessException("Transf type is null. Can't calculate tax.");
		}
		
		calculator.calculate(scheduleFinancialTransfer);
		
		return null;		
	}

	@Override
	public List<FinancialTransferScheduleDTO> listAllScheduledTransfers() throws FinancialScheduleBusinessException {


		return null;
	}

}
