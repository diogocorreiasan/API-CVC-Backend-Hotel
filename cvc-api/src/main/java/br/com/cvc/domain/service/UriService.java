package br.com.cvc.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.cvc.domain.utils.UriProperties;

@Service
public class UriService {
	
	@Autowired
	private UriProperties properties;
	
	public String getUri(String path, String id) {

		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme(properties.getHttps())
				.host(properties.getHostCvcBackendHotel())
				.path(path)
				.path(id)
				.build();
		
		return uri.toString();
	}

}
