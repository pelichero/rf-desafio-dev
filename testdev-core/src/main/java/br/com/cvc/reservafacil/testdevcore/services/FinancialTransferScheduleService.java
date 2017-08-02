package br.com.cvc.reservafacil.testdevcore.services;

import java.util.List;

import br.com.cvc.reservafacil.testdevcore.exception.FinancialScheduleBusinessException;
import br.com.cvc.reservafacil.testdevcore.model.FinancialTransferScheduleDTO;

/**
 * 
 * @author felipe.pelichero
 *
 * 1 de ago de 2017
 */
public interface FinancialTransferScheduleService {

	/**
	 * 
	 * @param scheduleFinancialTransfer
	 * @throws FinancialScheduleBusinessException
	 */
	public FinancialTransferScheduleDTO scheduleTransfer(FinancialTransferScheduleDTO scheduleFinancialTransfer) throws FinancialScheduleBusinessException;
	
	/**
	 * 
	 * @return
	 * @throws FinancialScheduleBusinessException
	 */
	public List<FinancialTransferScheduleDTO> listAllScheduledTransfers() throws FinancialScheduleBusinessException;
	
}
