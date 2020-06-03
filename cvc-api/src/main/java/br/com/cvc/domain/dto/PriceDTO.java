package br.com.cvc.domain.dto;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class PriceDTO {

	private BigDecimal pricePerDayAdult;
	private BigDecimal pricePerDayChild;
	
	public PriceDTO(BigDecimal pricePerDayAdult, BigDecimal pricePerDayChild) {
		this.pricePerDayAdult = pricePerDayAdult;
		this.pricePerDayChild = pricePerDayChild;
	}
	
}
