package com.mcrmk.springboot.h2restaurants.repository;

import com.mcrmk.springboot.h2restaurants.model.Restaurant;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class RestaurantRepositoryRedis {
    public static final String RESTAURANT_KEY = "RESTAURANT";
    private HashOperations hashOperations;
    private RedisTemplate redisTemplate;

    public RestaurantRepositoryRedis(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    public Restaurant save(Restaurant restaurant){
        hashOperations.put(RESTAURANT_KEY, restaurant.getId(), restaurant);
        return restaurant;
    }

    public List<Restaurant> findAll(){
        return hashOperations.values(RESTAURANT_KEY);
    }

    public Restaurant findById(Long id){
        return  (Restaurant) hashOperations.get(RESTAURANT_KEY, id);
    }

    public Restaurant update(Restaurant restaurant){
        return save(restaurant);
    }

    public void delete(Long id){
        hashOperations.delete(RESTAURANT_KEY, id);
    }

}
