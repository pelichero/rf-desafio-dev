package br.com.cvc.reservafacil.testdevcore.transfers;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.cvc.reservafacil.testdevcore.exception.FinancialScheduleBusinessException;
import br.com.cvc.reservafacil.testdevcore.model.Calculable;
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
	
	private static final String DEST_ACC = "felipe";
	private static final String ORIGEN_ACC = "bill gates";

	@Autowired
	private FinancialTransferScheduleServiceImpl service;
	
	private SimpleDateFormat sdf;
	
	@Before
	public void init(){
		sdf = new SimpleDateFormat("dd/MM/yyyy");
	}
	
	@Test
	public void testTransferCalcTypeA(){
		final String EXPECTED = "FinancialTransferScheduleDTO [origenAcc=bill gates, destAcc=felipe, transfValue=100, tax=2.3, scheduleDate=null, typeTransf=A]";
		
		try {
			FinancialTransferScheduleDTO dto = new FinancialTransferScheduleDTO();	
			dto.setOrigenAcc(ORIGEN_ACC);
			dto.setDestAcc(DEST_ACC);
			dto.setTypeTransf(TypeTransfEnum.A);
			dto.setTransfValue(new BigDecimal("100"));

			service.scheduleTransfer(dto);

			Assert.assertNotNull(dto.getTax());
			Assert.assertEquals(EXPECTED, dto.toString());
		} catch (FinancialScheduleBusinessException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTransferCalcTypeB_Ate_30_Dias(){
		String scheduledDate = sdf.format(Date.from(LocalDate.now().minusDays(28).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		
		final String EXPECTED = "FinancialTransferScheduleDTO [origenAcc=bill gates, destAcc=felipe, transfValue=100, tax=8.0, scheduleDate="+scheduledDate+", typeTransf=B]";
		
		try {
			FinancialTransferScheduleDTO dto = new FinancialTransferScheduleDTO();	
			dto.setOrigenAcc(ORIGEN_ACC);
			dto.setDestAcc(DEST_ACC);
			dto.setTypeTransf(TypeTransfEnum.B);
			dto.setTransfValue(new BigDecimal("100"));
			dto.setScheduleDate(scheduledDate);
			
			service.scheduleTransfer(dto);
			
			Assert.assertNotNull(dto.getTax());
			Assert.assertEquals(EXPECTED, dto.toString());
		} catch (FinancialScheduleBusinessException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTransferCalcTypeB_Apos_30_Dias(){
		String scheduledDate = sdf.format(Date.from(LocalDate.now().minusDays(31).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		
		final String EXPECTED = "FinancialTransferScheduleDTO [origenAcc=bill gates, destAcc=felipe, transfValue=100, tax=10.0, scheduleDate="+scheduledDate+", typeTransf=B]";
		
		try {
			FinancialTransferScheduleDTO dto = new FinancialTransferScheduleDTO();	
			dto.setOrigenAcc(ORIGEN_ACC);
			dto.setDestAcc(DEST_ACC);
			dto.setTypeTransf(TypeTransfEnum.B);
			dto.setTransfValue(new BigDecimal("100"));
			dto.setScheduleDate(scheduledDate);
			
			service.scheduleTransfer(dto);
			
			Assert.assertNotNull(dto.getTax());
			Assert.assertEquals(EXPECTED, dto.toString());
		} catch (FinancialScheduleBusinessException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTransferCalcTypeC_Ate_5_dias(){
		String scheduledDate = sdf.format(Date.from(LocalDate.now().minusDays(4).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		
		final String EXPECTED = "FinancialTransferScheduleDTO [origenAcc=bill gates, destAcc=felipe, transfValue=100, tax=8.299999, scheduleDate="+scheduledDate+", typeTransf=C]";
		
		try {
			FinancialTransferScheduleDTO dto = new FinancialTransferScheduleDTO();	
			dto.setOrigenAcc(ORIGEN_ACC);
			dto.setDestAcc(DEST_ACC);
			dto.setTypeTransf(TypeTransfEnum.C);
			dto.setTransfValue(new BigDecimal("100"));
			dto.setScheduleDate(scheduledDate);

			service.scheduleTransfer(dto);
			
			Assert.assertNotNull(dto.getTax());
			Assert.assertEquals(EXPECTED, dto.toString());
		} catch (FinancialScheduleBusinessException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTransferCalcTypeC_Ate_10_dias(){
		String scheduledDate = sdf.format(Date.from(LocalDate.now().minusDays(9).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		
		final String EXPECTED = "FinancialTransferScheduleDTO [origenAcc=bill gates, destAcc=felipe, transfValue=100, tax=7.4, scheduleDate="+scheduledDate+", typeTransf=C]";
		
		try {
			FinancialTransferScheduleDTO dto = new FinancialTransferScheduleDTO();	
			dto.setOrigenAcc(ORIGEN_ACC);
			dto.setDestAcc(DEST_ACC);
			dto.setTypeTransf(TypeTransfEnum.C);
			dto.setTransfValue(new BigDecimal("100"));
			dto.setScheduleDate(scheduledDate);

			service.scheduleTransfer(dto);
			
			Assert.assertNotNull(dto.getTax());
			Assert.assertEquals(EXPECTED, dto.toString());
		} catch (FinancialScheduleBusinessException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTransferCalcTypeC_Ate_15_dias(){
		String scheduledDate = sdf.format(Date.from(LocalDate.now().minusDays(14).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		
		final String EXPECTED = "FinancialTransferScheduleDTO [origenAcc=bill gates, destAcc=felipe, transfValue=100, tax=6.7000003, scheduleDate="+scheduledDate+", typeTransf=C]";
		
		try {
			FinancialTransferScheduleDTO dto = new FinancialTransferScheduleDTO();	
			dto.setOrigenAcc(ORIGEN_ACC);
			dto.setDestAcc(DEST_ACC);
			dto.setTypeTransf(TypeTransfEnum.C);
			dto.setTransfValue(new BigDecimal("100"));
			dto.setScheduleDate(scheduledDate);

			service.scheduleTransfer(dto);
			
			Assert.assertNotNull(dto.getTax());
			Assert.assertEquals(EXPECTED, dto.toString());
		} catch (FinancialScheduleBusinessException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTransferCalcTypeC_Ate_20_dias(){
		String scheduledDate = sdf.format(Date.from(LocalDate.now().minusDays(19).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		
		final String EXPECTED = "FinancialTransferScheduleDTO [origenAcc=bill gates, destAcc=felipe, transfValue=100, tax=5.4, scheduleDate="+scheduledDate+", typeTransf=C]";
		
		try {
			FinancialTransferScheduleDTO dto = new FinancialTransferScheduleDTO();	
			dto.setOrigenAcc(ORIGEN_ACC);
			dto.setDestAcc(DEST_ACC);
			dto.setTypeTransf(TypeTransfEnum.C);
			dto.setTransfValue(new BigDecimal("100"));
			dto.setScheduleDate(scheduledDate);

			service.scheduleTransfer(dto);
			
			Assert.assertNotNull(dto.getTax());
			Assert.assertEquals(EXPECTED, dto.toString());
		} catch (FinancialScheduleBusinessException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTransferCalcTypeC_Ate_25_dias(){
		String scheduledDate = sdf.format(Date.from(LocalDate.now().minusDays(24).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		
		final String EXPECTED = "FinancialTransferScheduleDTO [origenAcc=bill gates, destAcc=felipe, transfValue=100, tax=4.3, scheduleDate="+scheduledDate+", typeTransf=C]";
		
		try {
			FinancialTransferScheduleDTO dto = new FinancialTransferScheduleDTO();	
			dto.setOrigenAcc(ORIGEN_ACC);
			dto.setDestAcc(DEST_ACC);
			dto.setTypeTransf(TypeTransfEnum.C);
			dto.setTransfValue(new BigDecimal("100"));
			dto.setScheduleDate(scheduledDate);

			service.scheduleTransfer(dto);
			
			Assert.assertNotNull(dto.getTax());
			Assert.assertEquals(EXPECTED, dto.toString());
		} catch (FinancialScheduleBusinessException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTransferCalcTypeC_Ate_30_dias(){
		String scheduledDate = sdf.format(Date.from(LocalDate.now().minusDays(29).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		
		final String EXPECTED = "FinancialTransferScheduleDTO [origenAcc=bill gates, destAcc=felipe, transfValue=100, tax=2.1, scheduleDate="+scheduledDate+", typeTransf=C]";
		
		try {
			FinancialTransferScheduleDTO dto = new FinancialTransferScheduleDTO();	
			dto.setOrigenAcc(ORIGEN_ACC);
			dto.setDestAcc(DEST_ACC);
			dto.setTypeTransf(TypeTransfEnum.C);
			dto.setTransfValue(new BigDecimal("100"));
			dto.setScheduleDate(scheduledDate);

			service.scheduleTransfer(dto);
			
			Assert.assertNotNull(dto.getTax());
			Assert.assertEquals(EXPECTED, dto.toString());
		} catch (FinancialScheduleBusinessException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTransferCalcTypeC_Apos_30_dias(){
		String scheduledDate = sdf.format(Date.from(LocalDate.now().minusDays(31).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		
		final String EXPECTED = "FinancialTransferScheduleDTO [origenAcc=bill gates, destAcc=felipe, transfValue=100, tax=1.2, scheduleDate="+scheduledDate+", typeTransf=C]";
		
		try {
			FinancialTransferScheduleDTO dto = new FinancialTransferScheduleDTO();	
			dto.setOrigenAcc(ORIGEN_ACC);
			dto.setDestAcc(DEST_ACC);
			dto.setTypeTransf(TypeTransfEnum.C);
			dto.setTransfValue(new BigDecimal("100"));
			dto.setScheduleDate(scheduledDate);

			service.scheduleTransfer(dto);
			
			Assert.assertNotNull(dto.getTax());
			Assert.assertEquals(EXPECTED, dto.toString());
		} catch (FinancialScheduleBusinessException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTransferCalcTypeD_Ate_25k(){
		String scheduledDate = sdf.format(Date.from(LocalDate.now().minusDays(31).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		
		final String EXPECTED = "FinancialTransferScheduleDTO [origenAcc=bill gates, destAcc=felipe, transfValue=24999, tax=76.997, scheduleDate="+scheduledDate+", typeTransf=D]";
		
		try {
			FinancialTransferScheduleDTO dto = new FinancialTransferScheduleDTO();	
			dto.setOrigenAcc(ORIGEN_ACC);
			dto.setDestAcc(DEST_ACC);
			dto.setScheduleDate(scheduledDate);
			dto.setTransfValue(new BigDecimal("24999"));
			dto.setTypeTransf(TypeTransfEnum.D);
			
			service.scheduleTransfer(dto);

			Assert.assertNotNull(dto.getTax());
			Assert.assertEquals(EXPECTED, dto.toString());
		} catch (FinancialScheduleBusinessException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTransferCalcTypeD_Entre_25K_e_120k(){
		String scheduledDate = sdf.format(Date.from(LocalDate.now().minusDays(31).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		
		final String EXPECTED = "FinancialTransferScheduleDTO [origenAcc=bill gates, destAcc=felipe, transfValue=80000, tax=10.0, scheduleDate="+scheduledDate+", typeTransf=D]";
		
		try {
			FinancialTransferScheduleDTO dto = new FinancialTransferScheduleDTO();	
			dto.setOrigenAcc(ORIGEN_ACC);
			dto.setDestAcc(DEST_ACC);
			dto.setScheduleDate(scheduledDate);
			dto.setTransfValue(new BigDecimal("80000"));
			dto.setTypeTransf(TypeTransfEnum.D);
			
			service.scheduleTransfer(dto);

			Assert.assertNotNull(dto.getTax());
			Assert.assertEquals(EXPECTED, dto.toString());
		} catch (FinancialScheduleBusinessException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTransferCalcTypeD_Maior_120k(){
		String scheduledDate = sdf.format(Date.from(LocalDate.now().minusDays(31).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		
		final String EXPECTED = "FinancialTransferScheduleDTO [origenAcc=bill gates, destAcc=felipe, transfValue=125000, tax=1500.0, scheduleDate="+scheduledDate+", typeTransf=D]";
		
		try {
			FinancialTransferScheduleDTO dto = new FinancialTransferScheduleDTO();	
			dto.setOrigenAcc(ORIGEN_ACC);
			dto.setDestAcc(DEST_ACC);
			dto.setScheduleDate(scheduledDate);
			dto.setTransfValue(new BigDecimal("125000"));
			dto.setTypeTransf(TypeTransfEnum.D);
			
			service.scheduleTransfer(dto);

			Assert.assertNotNull(dto.getTax());
			Assert.assertEquals(EXPECTED, dto.toString());
		} catch (FinancialScheduleBusinessException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTransferListAll(){
		try {
			List<Calculable> financialTransfers = service.listAllScheduledTransfers();
			
			Assert.assertNotNull(financialTransfers);
			Assert.assertEquals(13, financialTransfers.size());
		} catch (FinancialScheduleBusinessException e) {
			e.printStackTrace();
		}
	}
}
