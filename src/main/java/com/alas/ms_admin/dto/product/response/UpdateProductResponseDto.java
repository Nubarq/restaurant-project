package com.alas.ms_admin.dto.product.response;

import lombok.Data;

import java.util.List;

@Data
public class UpdateProductResponseDto {
    private Integer id;
    private String name;
    private Integer categoryId;
    private Integer price;
    private List<Integer> ingredientIds;

}
