package br.com.cvc.reservafacil.testdevcore.services;

import java.text.MessageFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cvc.reservafacil.testdevcore.calculator.taxes.FinancialTaxCalculator;
import br.com.cvc.reservafacil.testdevcore.exception.FinancialScheduleBusinessException;
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

	private final Logger Logger = LoggerFactory.getLogger(this.getClass()); 

	private static final String TRANSF_TYPE_IS_NULL_MSG_ERROR = "Transf type is null. Can't calculate tax.";
	private static final String FINANCIAL_SCHEDULE_IS_NULL_MSG_ERROR = "Financial schedule is null.";
	
	@Autowired
	private FinancialTaxCalculator calculator;
	
	@Autowired
	private FinancialTransferRepository financialRepository;
	
	@Override
	public Calculable scheduleTransfer(FinancialTransferScheduleDTO scheduleFinancialTransfer) throws FinancialScheduleBusinessException {
		Logger.debug(">>> Scheduling financial transfer");
		
		if(scheduleFinancialTransfer == null){
			Logger.error(FINANCIAL_SCHEDULE_IS_NULL_MSG_ERROR);
			throw new FinancialScheduleBusinessException(FINANCIAL_SCHEDULE_IS_NULL_MSG_ERROR);
		}
		
		if(scheduleFinancialTransfer.getTypeTransf() == null){
			Logger.error(TRANSF_TYPE_IS_NULL_MSG_ERROR);
			throw new FinancialScheduleBusinessException(TRANSF_TYPE_IS_NULL_MSG_ERROR);
		}
				
		FinancialTransferScheduleDTO calculatedFinancialTransfer = calculator.calculate(scheduleFinancialTransfer);
		
		financialRepository.save(calculatedFinancialTransfer);
		
		Logger.debug(MessageFormat.format(">>> Financial transfer schedulled {0}", scheduleFinancialTransfer));
		
		return calculatedFinancialTransfer;		
	}

	@Override
	public List<Calculable> listAllScheduledTransfers() throws FinancialScheduleBusinessException {
		Logger.debug(">>> Listing all scheduled transfers");
		
		return financialRepository.listAll();
	}

}
