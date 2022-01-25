package com.mcrmk.springboot.h2restaurants.repository;

import com.mcrmk.springboot.h2restaurants.model.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
}
