package br.com.cvc.reservafacil.testdevcore.services;

import java.util.List;

import br.com.cvc.reservafacil.testdevcore.model.FinancialTransferScheduleDTO;

public interface FinancialTransferScheduleService {

	public void scheduleTransfer(FinancialTransferScheduleDTO scheduleFinancialTransfer);
	
	public List<FinancialTransferScheduleDTO> listAllScheduledTransfers();
	
}
