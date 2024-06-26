package com.alas.ms_admin.mapper.menu;

import com.alas.ms_admin.dto.menu.request.CreateMenuRequestDto;
import com.alas.ms_admin.dto.menu.request.UpdateMenuRequestDto;
import com.alas.ms_admin.dto.menu.response.CreateMenuResponseDto;
import com.alas.ms_admin.dto.menu.response.UpdateMenuResponseDto;
import com.alas.ms_admin.model.category.Category;
import com.alas.ms_admin.model.menu.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuMapper {
    Menu mapCreateMenuRequestDtoToEntity(CreateMenuRequestDto createMenuRequestDto);
    @Mapping(target="branchId", source="branch.id")
    @Mapping(target = "categoryIds", source = "categories")
    CreateMenuResponseDto mapEntityToCreateMenuResponsetDto(Menu menu);


    @Mapping(target="branchId", source="branch.id")
    @Mapping(target = "categoryIds", source = "categories")
    UpdateMenuResponseDto mapEntityToUpdateMenuResponseDto
            (Menu menu,@MappingTarget UpdateMenuResponseDto updateMenuResponseDto);

//    @Mapping(target="branch.id", source="branchId")
//    @Mapping(target = "categories", source = "categoryIds")
    Menu mapUpdateMenuRequestDtoToEntity
            (UpdateMenuRequestDto updateMenuRequestDto, @MappingTarget Menu menu);

    default List<Integer> mapCategoriesToCategoryIds(List<Category> categories) {
        if (categories == null) {
            return null;
        }
        return categories.stream()
                .map(Category::getId)
                .collect(Collectors.toList());
    }
}
