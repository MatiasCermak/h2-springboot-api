package com.mcrmk.springboot.h2restaurants.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mcrmk.springboot.h2restaurants.model.Restaurant;
import com.mcrmk.springboot.h2restaurants.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    @Qualifier("Redis")
    private RestaurantService restaurantService;

    @GetMapping("{id}")
    public Restaurant retrieveRestaurant(@PathVariable Long id){
        return restaurantService.retrieve(id);
    }

    @GetMapping("")
    public List<Restaurant> listRestaurants(){
        return restaurantService.list();
    }

    @PutMapping("")
    public Restaurant updateRestaurant(@RequestBody Restaurant restaurant){
        return restaurantService.update(restaurant);
    }

    @DeleteMapping("{id}")
    public void deleteRestaurant(@PathVariable Long id){
        restaurantService.delete(id);
    }

    @PostMapping("/map")
    public Map<String, Object> retrieveRestaurantMapped(@RequestBody String restaurantJson) throws JsonProcessingException {
        return restaurantService.retrieveMap(restaurantJson);
    }

    @PostMapping("")
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant){
        return restaurantService.create(restaurant);
    }
}
