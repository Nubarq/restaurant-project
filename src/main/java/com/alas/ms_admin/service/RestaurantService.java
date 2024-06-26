package com.alas.ms_admin.service;

import com.alas.ms_admin.dto.restaurant.request.CreateRestaurantRequestDto;
import com.alas.ms_admin.dto.restaurant.request.UpdateRestaurantRequestDto;
import com.alas.ms_admin.dto.restaurant.response.CreateRestaurantResponseDto;
import com.alas.ms_admin.dto.restaurant.response.UpdateRestaurantResponseDto;

import java.util.List;

public interface RestaurantService {
    CreateRestaurantResponseDto createRestaurant(CreateRestaurantRequestDto createRestaurantRequestDto) ;
    CreateRestaurantResponseDto findRestaurantById(Integer id);
    List<CreateRestaurantResponseDto> findAllRestaurants();
    void  deleteRestaurant(Integer id);
    UpdateRestaurantResponseDto updateRestaurant(UpdateRestaurantRequestDto updateRestaurantRequestDto);
}
