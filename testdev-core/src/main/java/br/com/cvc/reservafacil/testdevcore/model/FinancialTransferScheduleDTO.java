package br.com.cvc.reservafacil.testdevcore.model;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.cvc.reservafacil.testdevcore.model.enums.TypeTransfEnum;
import br.com.cvc.reservafacil.testdevcore.utils.DateUtils;

/**
 * 
 * @author felipe.pelichero
 *
 * 1 de ago de 2017
 */
public class FinancialTransferScheduleDTO implements Calculable{
	
	private String origenAcc;
	private String destAcc;
	private BigDecimal transfValue;
	private Float tax;
	private String scheduleDate;
	private TypeTransfEnum typeTransf;
	
	public String getOrigenAcc() {
		return origenAcc;
	}
	
	public void setOrigenAcc(String origenAcc) {
		this.origenAcc = origenAcc;
	}
	
	public String getDestAcc() {
		return destAcc;
	}
	
	public void setDestAcc(String destAcc) {
		this.destAcc = destAcc;
	}
	
	public BigDecimal getTransfValue() {
		return transfValue;
	}
	
	public void setTransfValue(BigDecimal transfValue) {
		this.transfValue = transfValue;
	}
	
	public Float getTax() {
		return tax;
	}
	
	public void setTax(Float tax) {
		this.tax = tax;
	}
	
	public Date getScheduleDate() {
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtils.DATE_PATTERN);		
		Date parsedDate = null;		
		try {
			parsedDate = sdf.parse(this.scheduleDate);
		} catch (ParseException e) {
			e.printStackTrace();
		} 		
		return parsedDate;
	}

	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public TypeTransfEnum getTypeTransf() {
		return typeTransf;
	}
	
	public void setTypeTransf(TypeTransfEnum typeTransf) {
		this.typeTransf = typeTransf;
	}

	@Override
	public String toString() {
		return "FinancialTransferScheduleDTO [origenAcc=" + origenAcc + ", destAcc=" + destAcc + ", transfValue="
				+ transfValue + ", tax=" + tax + ", scheduleDate=" + scheduleDate + ", typeTransf=" + typeTransf + "]";
	}
}