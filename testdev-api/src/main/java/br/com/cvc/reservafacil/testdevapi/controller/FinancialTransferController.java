package br.com.cvc.reservafacil.testdevapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cvc.reservafacil.testdevcore.exception.FinancialScheduleBusinessException;
import br.com.cvc.reservafacil.testdevcore.model.Calculable;
import br.com.cvc.reservafacil.testdevcore.model.FinancialTransferScheduleDTO;
import br.com.cvc.reservafacil.testdevcore.services.FinancialTransferScheduleService;

@Controller
public class FinancialTransferController {

	@Autowired
	private FinancialTransferScheduleService service;
	
	@RequestMapping(value = "/scheduleFinancialTransfer", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<Calculable>> scheduleFinancialTransfer(@RequestBody FinancialTransferScheduleDTO financialTransfer){
		try {
			
			service.scheduleTransfer(financialTransfer);
			
		} catch (FinancialScheduleBusinessException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@RequestMapping(value = "/listTransfers", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Calculable>> listAll(){
		try {
			return new ResponseEntity<> (service.listAllScheduledTransfers(),  HttpStatus.OK);
		} catch (FinancialScheduleBusinessException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
