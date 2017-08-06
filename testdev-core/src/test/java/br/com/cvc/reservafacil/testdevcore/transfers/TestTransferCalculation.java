package br.com.cvc.reservafacil.testdevcore.transfers;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class TestTransferCalculation {
	
	@Autowired
	private FinancialTransferScheduleServiceImpl service;
	
	private FinancialTransferScheduleDTO financialTransferScheduleDTO;
	private SimpleDateFormat sdf;
	
	@Before
	public void init(){
		financialTransferScheduleDTO = buildDTO();
		sdf = new SimpleDateFormat("dd/MM/yyyy");
	}
	
	@Test
	public void testTransferCalcTypeA(){		
		try {
			financialTransferScheduleDTO.setTypeTransf(TypeTransfEnum.A);
			
			System.out.println(service.scheduleTransfer(financialTransferScheduleDTO));
		} catch (FinancialScheduleBusinessException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTransferCalcTypeB(){
		try {
			financialTransferScheduleDTO.setTypeTransf(TypeTransfEnum.B);
			financialTransferScheduleDTO.setScheduleDate(sdf.format(Date.from(LocalDate.now().minusDays(31).atStartOfDay(ZoneId.systemDefault()).toInstant())));
			
			System.out.println(service.scheduleTransfer(financialTransferScheduleDTO));
		} catch (FinancialScheduleBusinessException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTransferCalcTypeC(){
		try {
			financialTransferScheduleDTO.setTypeTransf(TypeTransfEnum.C);
			financialTransferScheduleDTO.setScheduleDate(sdf.format(Date.from(LocalDate.now().minusDays(16).atStartOfDay(ZoneId.systemDefault()).toInstant())));

			System.out.println(service.scheduleTransfer(financialTransferScheduleDTO));
		} catch (FinancialScheduleBusinessException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTransferCalcTypeD(){
		try {
			financialTransferScheduleDTO.setScheduleDate(sdf.format(Date.from(LocalDate.now().minusDays(31).atStartOfDay(ZoneId.systemDefault()).toInstant())));
			financialTransferScheduleDTO.setTransfValue(new BigDecimal("120001"));
			financialTransferScheduleDTO.setTypeTransf(TypeTransfEnum.D);
			
			System.out.println(service.scheduleTransfer(financialTransferScheduleDTO));
		} catch (FinancialScheduleBusinessException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTransferListAll(){
		try {
			System.out.println(service.listAllScheduledTransfers());
		} catch (FinancialScheduleBusinessException e) {
			e.printStackTrace();
		}
	}
	
	private FinancialTransferScheduleDTO buildDTO() {
		FinancialTransferScheduleDTO dto = new FinancialTransferScheduleDTO();
	
		dto.setTransfValue(new BigDecimal("100"));
		dto.setOrigenAcc("bill gates");
		dto.setDestAcc("felipe");
		
		return dto;
	}
}
