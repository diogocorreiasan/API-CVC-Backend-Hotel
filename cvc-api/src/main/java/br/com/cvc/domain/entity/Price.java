package br.com.cvc.domain.entity;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Price {

	private BigDecimal adult;
	private BigDecimal child;
	
}
