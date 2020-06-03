package br.com.cvc.domain.service.impl;

import static br.com.cvc.domain.utils.RangeDays.days;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cvc.domain.dto.HotelDTO;
import br.com.cvc.domain.dto.PriceDTO;
import br.com.cvc.domain.dto.RoomsDTO;
import br.com.cvc.domain.entity.Hotel;
import br.com.cvc.domain.entity.Rooms;
import br.com.cvc.domain.service.PriceTotalService;

@Service
public class PriceTotalServiceImpl implements PriceTotalService{
	
	private static final BigDecimal COMISSION = new BigDecimal(0.7);

	@Override
	public List<HotelDTO> totalCalculationcommissionHotelList(List<Hotel> list, LocalDate checkin, 
			LocalDate checkout, Integer adults, Integer children) {
		
		if(checkin.isAfter(checkout)) {
			return null;
		}
		
		Long days = days(checkin, checkout);
		
		List<HotelDTO> hotelsDTO = new ArrayList<>();
		
		list.forEach(hotel -> {
			
			List<RoomsDTO> roomsDTO = calculationComission(hotel.getRooms(), days, adults, children);
			HotelDTO hotelDTO = new HotelDTO(hotel.getId(), hotel.getName(), hotel.getCityCode(), hotel.getCityName(), roomsDTO);
			
			hotelsDTO.add(hotelDTO);
		});
		
		return hotelsDTO;
	}

	private List<RoomsDTO> calculationComission(List<Rooms> rooms, Long days, Integer adults, Integer children) {
		List<RoomsDTO> roomsListDTO = new ArrayList<RoomsDTO>();
		
		rooms.forEach(room -> {
			PriceDTO priceDetail = new PriceDTO(
					room.getPrice().getAdult().multiply(BigDecimal.valueOf(adults))
					.multiply(BigDecimal.valueOf(days)).divide(COMISSION, RoundingMode.HALF_UP), 
					
					room.getPrice().getChild().multiply(BigDecimal.valueOf(children))
					.multiply(BigDecimal.valueOf(days)).divide(COMISSION, RoundingMode.HALF_UP)
					);
			
			RoomsDTO roomsDTO = new RoomsDTO(room.getRoomID(), room.getCategoryName(), 
					priceDetail.getPricePerDayAdult().add(priceDetail.getPricePerDayChild()), priceDetail);
			
			roomsListDTO.add(roomsDTO);
			
		});
		
		return roomsListDTO;
	}

}
