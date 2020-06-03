package br.com.cvc.domain.service;

import java.time.LocalDate;
import java.util.List;

import br.com.cvc.domain.dto.HotelDTO;
import br.com.cvc.domain.entity.Hotel;

public interface PriceTotalService {

	public List<HotelDTO> totalCalculationcommissionHotelList(List<Hotel> list, LocalDate dateStart, LocalDate dateEnd, Integer adults, Integer children);
	
}