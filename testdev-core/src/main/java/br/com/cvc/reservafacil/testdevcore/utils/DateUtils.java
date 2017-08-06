package br.com.cvc.reservafacil.testdevcore.utils;

import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;

/**
 * 
 * @author felipe.pelichero
 *
 * 3 de ago de 2017
 */
public class DateUtils {
	
	public static final String DATE_PATTERN = "dd/MM/yyyy";

	public static long daysBetween(Temporal start, Temporal end) {
		return ChronoUnit.DAYS.between(start, end) * -1;
	}

	public static Temporal dateToTemporal(Date date){
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}	
}
