package com.mcrmk.springboot.h2restaurants;

import com.mcrmk.springboot.h2restaurants.model.City;
import com.mcrmk.springboot.h2restaurants.model.Country;
import com.mcrmk.springboot.h2restaurants.model.Restaurant;
import com.mcrmk.springboot.h2restaurants.repository.CityRepository;
import com.mcrmk.springboot.h2restaurants.repository.CountryRepository;
import com.mcrmk.springboot.h2restaurants.repository.RestaurantRepositoryRedis;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class H2restaurantsApplication {

	public static void main(String[] args) {
		SpringApplication.run(H2restaurantsApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDatabase(RestaurantRepositoryRedis restaurantRepository, CityRepository cityRepository, CountryRepository countryRepository) {
		return (args) -> {
			Country argentina = countryRepository.save(Country.builder().name("Argentina").build());
			Country croacia = countryRepository.save(Country.builder().name("Croacia").build());
			countryRepository.save(Country.builder().name("México").build());
			countryRepository.save(Country.builder().name("Brasil").build());
			countryRepository.save(Country.builder().name("Colombia").build());

			City bsas = cityRepository.save(City.builder().name("Buenos Aires").country(argentina).id(1L).build());
			City zagreb = cityRepository.save(City.builder().name("Zagreb").country(croacia).build());

			Restaurant res = restaurantRepository.save(Restaurant.builder().name("Los hermanos").city(bsas).horaFin("22:00").horaInicio("09:00").id(1L).build());
			restaurantRepository.save(Restaurant.builder().name("Restaurante").city(zagreb).horaFin("22:00").horaInicio("09:00").id(2L).build());
			System.out.println(res.getId());
		};
	}

}
