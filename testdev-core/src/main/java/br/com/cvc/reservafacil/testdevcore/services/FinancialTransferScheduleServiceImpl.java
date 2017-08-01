package br.com.cvc.reservafacil.testdevcore.services;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.cvc.reservafacil.testdevcore.model.FinancialTransferScheduleDTO;

@Component
public class FinancialTransferScheduleServiceImpl implements FinancialTransferScheduleService{

	@Override
	public void scheduleTransfer(FinancialTransferScheduleDTO scheduleFinancialTransfer) {
		//TODO
	}

	@Override
	public List<FinancialTransferScheduleDTO> listAllScheduledTransfers() {
		//TODO
		return null;
	}

}
