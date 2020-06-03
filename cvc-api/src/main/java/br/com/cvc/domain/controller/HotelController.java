package br.com.cvc.domain.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cvc.domain.dto.HotelDTO;
import br.com.cvc.domain.service.HotelService;
import br.com.cvc.domain.utils.UriProperties;

@RestController
@RequestMapping(value = "/v1/cvc")
public class HotelController {
	
	private HotelService hotelService;
	private UriProperties properties;
	
	@Autowired
	public HotelController(HotelService hotelService, UriProperties properties) {
		this.hotelService = hotelService;
		this.properties = properties;
	}

	@GetMapping("/city")
	public ResponseEntity<?> searchCityById(
			@RequestParam(value= "cityCode") Long cityCode,
			@RequestParam(value= "adults", defaultValue= "0") Integer adults,
			@RequestParam(value= "children", defaultValue= "0") Integer children,
			@RequestParam(value= "checkin") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate checkin,
			@RequestParam(value= "checkout") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate checkout){
		
		List<HotelDTO> hotelListDTO = 
				hotelService.search(cityCode, checkin, checkout, adults, children, properties.getHotelsAvail());
		
		if(hotelListDTO == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Start date cannot be greater than the end date");
		}
		
		return ResponseEntity.ok(hotelListDTO);
	}
	
	@GetMapping("/hotel/details")
	public ResponseEntity<?> searchDetail(
			@RequestParam(value = "hotelCode") Long hotelCode,
            @RequestParam(value = "adults", defaultValue= "0") Integer adults,
            @RequestParam(value = "children", defaultValue= "0") Integer children,
			@RequestParam(value = "checkin") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate checkin,
            @RequestParam(value = "checkout") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate checkout) {
		
		List<HotelDTO> hotelListDTO = 
				hotelService.search(hotelCode, checkin, checkout, adults, children, properties.getHotels());
				
		if(hotelListDTO == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Start date cannot be greater than the end date");
		}
		
		return ResponseEntity.ok(hotelListDTO);
	}
	
}
