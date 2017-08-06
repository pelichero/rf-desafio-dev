package br.com.cvc.reservafacil.testdevapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cvc.reservafacil.testdevcore.exception.FinancialScheduleBusinessException;
import br.com.cvc.reservafacil.testdevcore.model.Calculable;
import br.com.cvc.reservafacil.testdevcore.services.FinancialTransferScheduleService;

@Controller
public class FinancialTransferController {

	@Autowired
	private FinancialTransferScheduleService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String calculatePricingTest(Model model){
		return "TESTE";	
		
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
