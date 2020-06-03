package br.com.cvc.domain.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties("uri.broker")
@Data
public class UriProperties {

	private String https;
	
	private String hotelsAvail;
	
	private String hotels;
	
	private String hostCvcBackendHotel;

	
}
