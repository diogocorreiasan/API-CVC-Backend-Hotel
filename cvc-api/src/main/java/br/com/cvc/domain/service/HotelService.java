package br.com.cvc.domain.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.cvc.domain.dto.HotelDTO;
import br.com.cvc.domain.entity.Hotel;
import br.com.cvc.domain.service.impl.PriceTotalServiceImpl;

@Service
public class HotelService {
	
	private UriService uriService;
	private PriceTotalServiceImpl priceTotalService;
	
	@Autowired
	public HotelService(UriService uriService, PriceTotalServiceImpl priceTotalService) {
		this.uriService = uriService;
		this.priceTotalService = priceTotalService;
	}

	public List<HotelDTO> search(Long code, LocalDate checkin, LocalDate checkout, Integer adults, Integer children, String path) {
		
		String uri = uriService.getUri(path, code.toString());
		
		List<Hotel> hotelList = Arrays.asList(new RestTemplate().getForObject(uri, Hotel[].class));
		
		 List<HotelDTO> listHotelDTO = 
				 priceTotalService.totalCalculationcommissionHotelList(hotelList, checkin, checkout, adults, children);
		
		return listHotelDTO;
	}

}
