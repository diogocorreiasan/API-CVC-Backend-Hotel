package br.com.cvc.domain.entity;

import java.util.List;

import lombok.Data;

@Data
public class Hotel {

	private Long id;
	private String name;
	private Integer cityCode;
	private String cityName;
	private List<Rooms> rooms;
	
}