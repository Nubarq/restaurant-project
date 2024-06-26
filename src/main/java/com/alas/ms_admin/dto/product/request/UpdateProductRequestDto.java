package com.alas.ms_admin.dto.product.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequestDto {
    private Integer id;
    private String name;
    private Integer categoryId;
    private Integer price;
    //private List<Integer> ingredientIds;

}
