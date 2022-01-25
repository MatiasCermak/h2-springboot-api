package com.mcrmk.springboot.h2restaurants.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mcrmk.springboot.h2restaurants.model.Restaurant;

import java.util.List;
import java.util.Map;

public interface RestaurantService {

    public Restaurant create(Restaurant restaurant);
    public Restaurant retrieve(Long id);
    public List<Restaurant> list();
    public Restaurant update(Restaurant restaurant);
    public void delete(Long id);
    public Map<String, Object> retrieveMap(String restaurantJson) throws JsonProcessingException;
}
