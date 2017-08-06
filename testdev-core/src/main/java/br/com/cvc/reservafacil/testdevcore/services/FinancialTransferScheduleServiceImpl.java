package br.com.cvc.reservafacil.testdevcore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cvc.reservafacil.testdevcore.calculator.taxes.FinancialTaxCalculator;
import br.com.cvc.reservafacil.testdevcore.exception.FinancialScheduleBusinessException;
import br.com.cvc.reservafacil.testdevcore.exception.TaxCalculationBusinessException;
import br.com.cvc.reservafacil.testdevcore.model.Calculable;
import br.com.cvc.reservafacil.testdevcore.model.FinancialTransferScheduleDTO;
import br.com.cvc.reservafacil.testdevcore.repository.FinancialTransferRepository;

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
	
	@Autowired
	private FinancialTransferRepository financialRepository;
	
	@Override
	public Calculable scheduleTransfer(FinancialTransferScheduleDTO scheduleFinancialTransfer) throws FinancialScheduleBusinessException {
		if(scheduleFinancialTransfer == null){
			throw new IllegalStateException("Financial schedule is null.");
		}
		
		if(scheduleFinancialTransfer.getTypeTransf() == null){
			throw new TaxCalculationBusinessException("Transf type is null. Can't calculate tax.");
		}
				
		FinancialTransferScheduleDTO calculatedFinancialTransfer = calculator.calculate(scheduleFinancialTransfer);
		
		financialRepository.save(calculatedFinancialTransfer);
		
		return calculatedFinancialTransfer;		
	}

	@Override
	public List<Calculable> listAllScheduledTransfers() throws FinancialScheduleBusinessException {
		return financialRepository.listAll();
	}

}
