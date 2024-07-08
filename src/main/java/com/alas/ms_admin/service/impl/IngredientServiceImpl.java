package com.alas.ms_admin.service.impl;

import com.alas.ms_admin.dto.Ingredient.request.CreateIngredientRequestDto;
import com.alas.ms_admin.dto.Ingredient.request.UpdateIngredientRequestDto;
import com.alas.ms_admin.dto.Ingredient.response.CreateIngredientResponseDto;
import com.alas.ms_admin.dto.Ingredient.response.UpdateIngredientResponseDto;
import com.alas.ms_admin.dto.category.response.CreateCategoryResponseDto;
import com.alas.ms_admin.dto.category.response.UpdateCategoryResponseDto;
import com.alas.ms_admin.exeption.CustomException;
import com.alas.ms_admin.mapper.category.CategoryMapper;
import com.alas.ms_admin.mapper.ingredient.IngredientMapper;
import com.alas.ms_admin.model.category.Category;
import com.alas.ms_admin.model.ingredient.Ingredient;
import com.alas.ms_admin.repository.category.CategoryRepository;
import com.alas.ms_admin.repository.ingredient.IngredientRepository;
import com.alas.ms_admin.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;
    private final IngredientMapper mapper;
    @Override
    public CreateIngredientResponseDto createIngredient(CreateIngredientRequestDto createIngredientRequestDto) {
        Ingredient ingredient=mapper.mapCreateIngredientRequestDtoToEntity(createIngredientRequestDto);
        Ingredient savedIngredient=ingredientRepository.save(ingredient);
        CreateIngredientResponseDto ingredientResponseDto=mapper.
                mapEntityToCreateIngredientResponsetDto(savedIngredient);
        return ingredientResponseDto;
    }

    @Override
    public UpdateIngredientResponseDto updateIngredient( UpdateIngredientRequestDto updateIngredientRequestDto) {
        Ingredient ingredient =ingredientRepository.findById(updateIngredientRequestDto.getId()).
                orElseThrow(() -> new CustomException("not found"));
        ingredient = mapper.mapUpdateIngredientRequestDtoToEntity(updateIngredientRequestDto,ingredient);
        ingredient=ingredientRepository.save(ingredient);
        return mapper.mapEntityToUpdateIngredientResponseDto(ingredient,new UpdateIngredientResponseDto());
    }

    @Override
    public void deleteIngredient(Integer id) {
        Ingredient ingredient=ingredientRepository.findById(id).orElseThrow(() -> new CustomException("not found"));
        if(ingredient.isActive()==true){
            ingredient.setActive(false);
            ingredientRepository.save(ingredient);
        }else {
            throw new CustomException("Branch is not active already");
        }
    }

    @Override
    public CreateIngredientResponseDto findIngredientById(Integer id) {
        Ingredient ingredient=ingredientRepository.findById(id).orElseThrow(() -> new CustomException("not found"));
        return mapper.mapEntityToCreateIngredientResponsetDto(ingredient);
    }

    @Override
    public List<CreateIngredientResponseDto> findAllIngredients() {
        List<Ingredient> ingredients=ingredientRepository.findAll();
        return ingredients.stream()
                .map(ingredient -> mapper.
                        mapEntityToCreateIngredientResponsetDto(ingredient)).collect(Collectors.toList());
    }
}
