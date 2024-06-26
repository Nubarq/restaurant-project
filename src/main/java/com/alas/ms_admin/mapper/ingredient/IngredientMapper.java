package com.alas.ms_admin.mapper.ingredient;

import com.alas.ms_admin.dto.Ingredient.request.CreateIngredientRequestDto;
import com.alas.ms_admin.dto.Ingredient.request.UpdateIngredientRequestDto;
import com.alas.ms_admin.dto.Ingredient.response.CreateIngredientResponseDto;
import com.alas.ms_admin.dto.Ingredient.response.UpdateIngredientResponseDto;
import com.alas.ms_admin.model.ingredient.Ingredient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IngredientMapper {
    Ingredient mapCreateIngredientRequestDtoToEntity(CreateIngredientRequestDto createIngredientRequestDto);

    CreateIngredientResponseDto mapEntityToCreateIngredientResponsetDto(Ingredient ingredient);

    UpdateIngredientResponseDto mapEntityToUpdateIngredientResponseDto
            (Ingredient ingredient,@MappingTarget UpdateIngredientResponseDto updateIngredientResponseDto);

    Ingredient mapUpdateIngredientRequestDtoToEntity
            (UpdateIngredientRequestDto updateIngredientRequestDto, @MappingTarget Ingredient ingredient);
}
