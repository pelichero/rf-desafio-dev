package br.com.cvc.reservafacil.testdevcore.repository;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import br.com.cvc.reservafacil.testdevcore.model.Calculable;

/**
 * 
 * @author felipe.pelichero
 *
 * 3 de ago de 2017
 */
@Repository
public class FinancialTransferRepository{	

	private final Logger Logger = LoggerFactory.getLogger(this.getClass());
	
	private static Map<Integer, Calculable> mapBase;
	
	public FinancialTransferRepository() {
		mapBase = new HashMap<>();
	}
	
	public void save(Calculable financialTransferDTO){
		Logger.debug(MessageFormat.format(">>> saving financial transfer: ", financialTransferDTO));
		
		mapBase.put(financialTransferDTO.hashCode(), financialTransferDTO);
	}
	
	public List<Calculable> listAll(){
		Logger.debug(">>> Listing all financial transfers");
		
		return new ArrayList<>(mapBase.values());
	}
}