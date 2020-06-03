package br.com.cvc.domain.utils;

import java.time.Duration;
import java.time.LocalDate;

public class RangeDays {

	public static long days(LocalDate checkin, LocalDate checkout) {
        return Duration.between(checkin.atStartOfDay(), checkout.atStartOfDay()).toDays();
    }
	  
}