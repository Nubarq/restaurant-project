package com.alas.ms_admin.mapper.category;

import com.alas.ms_admin.dto.category.request.CreateCategoryRequestDto;
import com.alas.ms_admin.dto.category.request.UpdateCategoryRequestDto;
import com.alas.ms_admin.dto.category.response.CreateCategoryResponseDto;
import com.alas.ms_admin.dto.category.response.UpdateCategoryResponseDto;
import com.alas.ms_admin.model.category.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {
    Category mapCreateCategoryRequestDtoToEntity(CreateCategoryRequestDto createCategoryRequestDto);
    CreateCategoryResponseDto mapEntityToCreateCategoryResponsetDto(Category category);


    UpdateCategoryResponseDto mapEntityToUpdateCategoryResponseDto
            (Category category,@MappingTarget UpdateCategoryResponseDto updateCategoryResponseDto);


    Category mapUpdateCategoryRequestDtoToEntity
            (UpdateCategoryRequestDto updateCategoryRequestDto, @MappingTarget Category category);
}
