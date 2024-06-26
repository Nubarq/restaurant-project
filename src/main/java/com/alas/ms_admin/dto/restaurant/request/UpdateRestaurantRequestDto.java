package com.alas.ms_admin.dto.restaurant.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRestaurantRequestDto {
    private Integer id;
    private String name;
    private String info;}
