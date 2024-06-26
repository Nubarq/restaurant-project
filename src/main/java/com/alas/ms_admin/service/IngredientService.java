package com.alas.ms_admin.service;

import com.alas.ms_admin.dto.Ingredient.request.CreateIngredientRequestDto;
import com.alas.ms_admin.dto.Ingredient.request.UpdateIngredientRequestDto;
import com.alas.ms_admin.dto.Ingredient.response.CreateIngredientResponseDto;
import com.alas.ms_admin.dto.Ingredient.response.UpdateIngredientResponseDto;
import com.alas.ms_admin.model.ingredient.Ingredient;

import java.util.List;

public interface IngredientService {
    CreateIngredientResponseDto createIngredient(CreateIngredientRequestDto createIngredientRequestDto);
    UpdateIngredientResponseDto updateIngredient( UpdateIngredientRequestDto updateIngredientRequestDto);
    void deleteIngredient(Integer id);
    CreateIngredientResponseDto findIngredientById(Integer id);
    List<CreateIngredientResponseDto> findAllIngredients();
}
