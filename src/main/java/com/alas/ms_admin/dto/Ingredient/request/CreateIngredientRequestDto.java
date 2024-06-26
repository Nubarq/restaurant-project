package com.alas.ms_admin.dto.Ingredient.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateIngredientRequestDto {
    private String name;
}
