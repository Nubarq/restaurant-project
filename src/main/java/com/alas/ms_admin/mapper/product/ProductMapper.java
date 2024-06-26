package com.alas.ms_admin.mapper.product;

import com.alas.ms_admin.dto.product.request.CreateProductRequestDto;
import com.alas.ms_admin.dto.product.request.UpdateProductRequestDto;
import com.alas.ms_admin.dto.product.response.CreateProductResponseDto;
import com.alas.ms_admin.dto.product.response.UpdateProductResponseDto;
import com.alas.ms_admin.model.category.Category;
import com.alas.ms_admin.model.ingredient.Ingredient;
import com.alas.ms_admin.model.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
    @Mapping(target = "category.id", source = "categoryId")
    //@Mapping(target = "ingredients", source = "ingredientIds")
    Product mapCreateProductRequestDtoToEntity(CreateProductRequestDto createProductRequestDto);


    @Mapping(target = "categoryId", source = "category.id")
    @Mapping(target = "ingredientIds", source = "ingredients")
    CreateProductResponseDto mapEntityToCreateProductResponsetDto(Product product);

    @Mapping(target = "categoryId", source = "category.id")
    @Mapping(target = "ingredientIds", source = "ingredients")
    UpdateProductResponseDto mapEntityToUpdateProductResponseDto
            (Product product,@MappingTarget UpdateProductResponseDto updateProductResponseDto);

    @Mapping(target = "category.id", source = "categoryId")
    //@Mapping(target = "ingredients", source = "ingredientIds")
    Product mapUpdateProductRequestDtoToEntity
            (UpdateProductRequestDto updateProductRequestDto, @MappingTarget Product product);

    default List<Integer> mapIngredientsToIngredientIds(List<Ingredient> ingredients) {
        if (ingredients == null) {
            return null;
        }
        return ingredients.stream()
                .map(Ingredient::getId)
                .collect(Collectors.toList());
    }
}
