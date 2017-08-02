package br.com.cvc.reservafacil.testdevcore.transfers;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.cvc.reservafacil.testdevcore.exception.FinancialScheduleBusinessException;
import br.com.cvc.reservafacil.testdevcore.model.FinancialTransferScheduleDTO;
import br.com.cvc.reservafacil.testdevcore.model.enums.TypeTransfEnum;
import br.com.cvc.reservafacil.testdevcore.services.FinancialTransferScheduleServiceImpl;

/**
 * 
 * @author felipe.pelichero
 *
 * 1 de ago de 2017
 */
@RunWith(SpringRunner.class)
public class TestTransferCalculation {
	
	@Autowired
	private FinancialTransferScheduleServiceImpl service;
	
	@Test
	public void testTransferCalcTypeA(){
		FinancialTransferScheduleDTO dto = new FinancialTransferScheduleDTO();
		dto.setTypeTransf(TypeTransfEnum.A);
		dto.setTransfValue(new BigDecimal("10000000"));
		dto.setOrigenAcc("bill gates");
		dto.setDestAcc("felipe");
		
		try {
			System.out.println(service.scheduleTransfer(dto));
		} catch (FinancialScheduleBusinessException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTransferCalcTypeB(){
	
	}
	
	@Test
	public void testTransferCalcTypeC(){
	
	}
	
	@Test
	public void testTransferCalcTypeD(){
	
	}
}
