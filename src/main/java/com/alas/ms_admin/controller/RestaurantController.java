package com.alas.ms_admin.controller;

import com.alas.ms_admin.dto.restaurant.request.CreateRestaurantRequestDto;
import com.alas.ms_admin.dto.restaurant.request.UpdateRestaurantRequestDto;
import com.alas.ms_admin.dto.restaurant.response.CreateRestaurantResponseDto;
import com.alas.ms_admin.dto.restaurant.response.UpdateRestaurantResponseDto;
import com.alas.ms_admin.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class RestaurantController {
    private RestaurantService restaurantService;

    @PostMapping("/create/restaurant")
    public CreateRestaurantResponseDto createRestaurant(
            @RequestBody CreateRestaurantRequestDto createRestaurantRequestDto) {
        return restaurantService.createRestaurant(createRestaurantRequestDto);
    }

    @DeleteMapping("/delete/restaurant")
    public void deleteRestaurant(@RequestParam Integer id) {
        restaurantService.deleteRestaurant(id);
    }

    @GetMapping("/find/Restaurant/ById")
    public CreateRestaurantResponseDto findRestaurantById(@RequestParam Integer id) {
        return  restaurantService.findRestaurantById(id);
    }

    @PutMapping("/update/restaurant")
    public UpdateRestaurantResponseDto updateRestaurant(
             @RequestBody UpdateRestaurantRequestDto updateRestaurantRequestDto) {
        return restaurantService.updateRestaurant(updateRestaurantRequestDto);
    }


    }

