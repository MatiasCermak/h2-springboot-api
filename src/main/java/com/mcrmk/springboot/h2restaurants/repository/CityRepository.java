package com.mcrmk.springboot.h2restaurants.repository;

import com.mcrmk.springboot.h2restaurants.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
}
