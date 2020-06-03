package br.com.cvc.domain.dto;

import java.util.List;

import lombok.Getter;

@Getter
public class HotelDTO {

	private Long id;
	private String name;
	private Integer cityCode;
	private String cityName;
	private List<RoomsDTO> rooms;
	
	public HotelDTO(Long id, String name, Integer cityCode, String cityName, List<RoomsDTO> rooms) {
		this.id = id;
		this.name = name;
		this.cityCode = cityCode;
		this.cityName = cityName;
		this.rooms = rooms;
	}
	
}
