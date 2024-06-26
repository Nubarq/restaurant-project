package com.alas.ms_admin.dto.restaurant.response;

import lombok.Data;

@Data
public class CreateRestaurantResponseDto {
    private Integer id;
    private String name;
    private String info;
    private boolean isActive;
}
