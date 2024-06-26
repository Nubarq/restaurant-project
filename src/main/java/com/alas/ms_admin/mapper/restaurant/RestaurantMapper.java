package com.alas.ms_admin.mapper.restaurant;

import com.alas.ms_admin.dto.restaurant.request.CreateRestaurantRequestDto;
import com.alas.ms_admin.dto.restaurant.request.UpdateRestaurantRequestDto;
import com.alas.ms_admin.dto.restaurant.response.CreateRestaurantResponseDto;
import com.alas.ms_admin.dto.restaurant.response.UpdateRestaurantResponseDto;
import com.alas.ms_admin.model.restaurant.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestaurantMapper {

    Restaurant mapCreateRestaurantRequestDtoToEntity(CreateRestaurantRequestDto createRestaurantRequestDto);
    @Mapping(source = "active", target = "active") // Explicitly map isActive to isactive
    CreateRestaurantResponseDto mapEntityToCreateRestauranResponsetDto(Restaurant restaurant);


    UpdateRestaurantResponseDto mapEntityToUpdateRestaurantResponseDto
            (@MappingTarget UpdateRestaurantResponseDto updateRestaurantResponseDto, Restaurant restaurant);


    Restaurant mapUpdateRestaurantRequestDtoToEntity
            ( UpdateRestaurantRequestDto updateRestaurantRequestDto, @MappingTarget Restaurant restaurant);


}
