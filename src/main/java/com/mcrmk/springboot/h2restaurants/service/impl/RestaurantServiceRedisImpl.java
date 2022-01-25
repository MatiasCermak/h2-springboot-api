package com.mcrmk.springboot.h2restaurants.service.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcrmk.springboot.h2restaurants.model.Restaurant;
import com.mcrmk.springboot.h2restaurants.repository.RestaurantRepositoryRedis;
import com.mcrmk.springboot.h2restaurants.service.RestaurantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("Redis")
public class RestaurantServiceRedisImpl implements RestaurantService, InitializingBean {

    @Autowired
    RestaurantRepositoryRedis restaurantRepositoryRedis;
    private ObjectMapper objectMapper = null;

    @Override
    public void afterPropertiesSet() throws Exception {
        objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm"));
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        try {
            log.info(objectMapper.writeValueAsString(restaurant));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return restaurantRepositoryRedis.save(restaurant);
    }

    @Override
    public Restaurant retrieve(Long id) {
        return restaurantRepositoryRedis.findById(id);
    }

    @Override
    public List<Restaurant> list(){
        return  restaurantRepositoryRedis.findAll();
    }

    @Override
    public Restaurant update(Restaurant restaurant){
        try {
            log.info(objectMapper.writeValueAsString(restaurant));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return restaurantRepositoryRedis.update(restaurant);
    }

    @Override
    public void delete(Long id){
        restaurantRepositoryRedis.delete(id);
    }

    @Override
    public Map<String, Object> retrieveMap(String restaurantJson) throws JsonProcessingException {
        return objectMapper.readValue(restaurantJson, Map.class);
    }
}
