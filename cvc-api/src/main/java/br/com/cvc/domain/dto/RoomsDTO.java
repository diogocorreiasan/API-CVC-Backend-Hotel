package br.com.cvc.domain.dto;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class RoomsDTO {

	private Long roomID;
	private String categoryName;
	private BigDecimal totalPrice;
	private PriceDTO priceDetail;
	
	public RoomsDTO(Long roomID, String categoryName, BigDecimal totalPrice, PriceDTO priceDetail) {
		this.roomID = roomID;
		this.categoryName = categoryName;
		this.totalPrice = totalPrice;
		this.priceDetail = priceDetail;
	}
	
}
