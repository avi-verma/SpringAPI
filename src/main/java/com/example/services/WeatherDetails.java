package com.example.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.pojo.WeatherData;

@Service
@Component
public class WeatherDetails {
	public WeatherData getWeatherDetails(String cityName) {
		RestTemplate template=new RestTemplate();
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		UriComponents builder=UriComponentsBuilder.fromHttpUrl("https://api.openweathermap.org/data/2.5/weather")
				.queryParam("q",cityName)
				.queryParam("appid", "191cc3c51a402049241235af01f9e78f").build();
		HttpEntity<String> entity=new HttpEntity<String>(headers);
		ResponseEntity<WeatherData> response=template.exchange(builder.toUriString(), HttpMethod.GET, entity, WeatherData.class);
		
		System.out.println(response.getBody().getDt());
		return response.getBody();
		
	}
}
