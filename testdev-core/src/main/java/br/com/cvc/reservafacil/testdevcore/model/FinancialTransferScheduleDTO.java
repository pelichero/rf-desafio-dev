package br.com.cvc.reservafacil.testdevcore.model;

import java.math.BigDecimal;

import br.com.cvc.reservafacil.testdevcore.model.enums.TypeTransfEnum;

/**
 * 
 * @author felipe.pelichero
 *
 * 1 de ago de 2017
 */
public class FinancialTransferScheduleDTO{
	
	private String origenAcc;
	private String destAcc;
	private BigDecimal transfValue;
	private Float tax;
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
	
	public TypeTransfEnum getTypeTransf() {
		return typeTransf;
	}
	
	public void setTypeTransf(TypeTransfEnum typeTransf) {
		this.typeTransf = typeTransf;
	}

	@Override
	public String toString() {
		return "FinancialTransferDTO [origenAcc=" + origenAcc + ", destAcc=" + destAcc + ", transfValue=" + transfValue
				+ ", tax=" + tax + ", typeTransf=" + typeTransf + "]";
	}	
}
