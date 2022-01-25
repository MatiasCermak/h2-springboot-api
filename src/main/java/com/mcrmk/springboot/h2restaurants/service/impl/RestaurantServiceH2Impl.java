package com.mcrmk.springboot.h2restaurants.service.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcrmk.springboot.h2restaurants.model.Restaurant;
import com.mcrmk.springboot.h2restaurants.repository.RestaurantRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Map;

@Service("H2")
public class RestaurantServiceH2Impl implements  InitializingBean  {

    @Autowired
    private RestaurantRepository restaurantRepository;
    private ObjectMapper objectMapper = null;

    @Override
    public void afterPropertiesSet() throws Exception {
        objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm"));
    }

    public Restaurant create(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Restaurant retrieve(Long id) {
        return restaurantRepository.findById(id).orElse(new Restaurant());
    }

    public Map<String, Object> retrieveMap(String restaurantJson) {
        return objectMapper.convertValue(objectMapper.convertValue(restaurantJson, Restaurant.class), Map.class);
    }
}
