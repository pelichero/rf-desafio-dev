package br.com.cvc.reservafacil.testdevapi.controller;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cvc.reservafacil.testdevapi.bean.ErrorResponse;
import br.com.cvc.reservafacil.testdevcore.exception.FinancialScheduleBusinessException;
import br.com.cvc.reservafacil.testdevcore.model.Calculable;
import br.com.cvc.reservafacil.testdevcore.model.FinancialTransferScheduleDTO;
import br.com.cvc.reservafacil.testdevcore.model.enums.TypeTransfEnum;
import br.com.cvc.reservafacil.testdevcore.services.FinancialTransferScheduleService;

@Controller
public class FinancialTransferController {

	private static final String SCHEDULE_DATE_NULL_MSG_ERROR = "You must inform the schedulle date of your transfer.";
	private static final String FINANCIAL_TRANSFER_IS_NULL_MSG_ERROR = "Financial transfer is null.";
	private static final String TYPE_TRANSF_NULL_MSG_ERROR = "You must inform the type of your financial transfer. please select between [{0}].";
	private static final String VALUE_TRANSF_NULL_MSG_ERROR = "You must inform the ammount of your financial transfer.";

	@Autowired
	private FinancialTransferScheduleService service;
	
	@RequestMapping(value = "/scheduleFinancialTransfer", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<Calculable>> scheduleFinancialTransfer(@RequestBody FinancialTransferScheduleDTO financialTransfer){
		try {
			if(financialTransfer == null){
				throw new IllegalArgumentException(FINANCIAL_TRANSFER_IS_NULL_MSG_ERROR);
			}
			
			if(financialTransfer.getTypeTransf() == null){
				throw new IllegalArgumentException(MessageFormat.format(TYPE_TRANSF_NULL_MSG_ERROR, Arrays.toString(TypeTransfEnum.values())));
			}
			
			if(financialTransfer.getTransfValue() == null){
				throw new IllegalArgumentException(VALUE_TRANSF_NULL_MSG_ERROR);
			}
			
			if(financialTransfer.getScheduleDate() == null){
				throw new IllegalArgumentException(SCHEDULE_DATE_NULL_MSG_ERROR);
			}
			
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
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
		error.setMessage(ex.getMessage());
		
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}
	
	@ExceptionHandler(FinancialScheduleBusinessException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(FinancialScheduleBusinessException ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(ex.getMessage());
		
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}
}
