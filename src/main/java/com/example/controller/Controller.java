package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.WeatherData;
import com.example.services.WeatherDetails;

@RestController
public class Controller {
@Autowired
WeatherDetails details;
@RequestMapping("/city/{name}")
public WeatherData name(@PathVariable("name") String city) {
	System.out.println(city);
	return details.getWeatherDetails(city);
}
}
