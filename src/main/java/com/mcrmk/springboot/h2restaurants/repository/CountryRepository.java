package com.mcrmk.springboot.h2restaurants.repository;

import com.mcrmk.springboot.h2restaurants.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
}
