package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.WeatherData;
import com.example.services.WeatherDetails;

@RestController
public class Controller {
@Autowired
WeatherDetails details;
@RequestMapping("/name")
public WeatherData name() {
	return details.getWeatherDetails("delhi");
}
}
