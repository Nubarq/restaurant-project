package com.alas.ms_admin.service.impl;

import com.alas.ms_admin.dto.restaurant.request.CreateRestaurantRequestDto;
import com.alas.ms_admin.dto.restaurant.request.UpdateRestaurantRequestDto;
import com.alas.ms_admin.dto.restaurant.response.CreateRestaurantResponseDto;
import com.alas.ms_admin.dto.restaurant.response.UpdateRestaurantResponseDto;
import com.alas.ms_admin.mapper.restaurant.RestaurantMapper;
import com.alas.ms_admin.model.restaurant.Restaurant;
import com.alas.ms_admin.repository.restaurant.RestaurantRepository;
import com.alas.ms_admin.service.RestaurantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private RestaurantMapper mapper;

    public RestaurantServiceImpl(RestaurantMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public CreateRestaurantResponseDto createRestaurant(CreateRestaurantRequestDto createRestaurantRequestDto) {
        Restaurant restaurant = mapper.mapCreateRestaurantRequestDtoToEntity(createRestaurantRequestDto);
        Restaurant createdRestaurant = restaurantRepository.save(restaurant);
        return mapper.mapEntityToCreateRestauranResponsetDto(createdRestaurant);
    }

    @Override
    public CreateRestaurantResponseDto findRestaurantById(Integer id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        return mapper.mapEntityToCreateRestauranResponsetDto(restaurant);
    }

    @Override
    public List<CreateRestaurantResponseDto> findAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants.stream()
                .map(restaurant -> mapper.mapEntityToCreateRestauranResponsetDto(restaurant)).collect(Collectors.toList());
    }

    @Override
    public void deleteRestaurant(Integer id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
        if (restaurant.isActive()) {
            restaurant.setActive(false);
            restaurantRepository.save(restaurant);
        } else {
            throw new RuntimeException("Restaurant is not active already");
        }
    }

    @Override
    public UpdateRestaurantResponseDto updateRestaurant( UpdateRestaurantRequestDto updateRestaurantRequestDto) {

        Restaurant restaurant = restaurantRepository.findById(updateRestaurantRequestDto.getId())
                .orElseThrow(() -> new RuntimeException("not found"));
        log.info("Restaurant success find by id" +restaurant);
        restaurant = mapper.mapUpdateRestaurantRequestDtoToEntity(updateRestaurantRequestDto,restaurant);
        log.info("Restaurant success update by id");
        restaurant = restaurantRepository.save(restaurant);
        return mapper.mapEntityToUpdateRestaurantResponseDto(new UpdateRestaurantResponseDto(),restaurant);


    }

}
