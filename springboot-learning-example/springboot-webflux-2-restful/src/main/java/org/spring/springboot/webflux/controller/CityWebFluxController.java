package org.spring.springboot.webflux.controller;

import org.spring.springboot.domain.City;
import org.spring.springboot.handler.CityHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/city")
public class CityWebFluxController {

	@Autowired
	private CityHandler cityHandler;

	@GetMapping(value = "/{id}")
	public Mono<City> findCityById(@PathVariable("id") Long id) {
		return cityHandler.findCityById(id);
	}

	@GetMapping()
	public Flux<City> findAllCity() {
		return cityHandler.findAllCity();
	}

	@GetMapping("/save")
	public Mono<Long> saveCity(City city) {
		return cityHandler.save(city);
	}

	@GetMapping("/modify")
	public Mono<Long> modifyCity(City city) {
		return cityHandler.modifyCity(city);
	}

	@GetMapping(value = "delete/{id}")
	public Mono<Long> deleteCity(@PathVariable("id") Long id) {
		return cityHandler.deleteCity(id);
	}
}