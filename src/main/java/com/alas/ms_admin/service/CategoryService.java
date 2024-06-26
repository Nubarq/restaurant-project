package com.alas.ms_admin.service;

import com.alas.ms_admin.dto.category.request.CreateCategoryRequestDto;
import com.alas.ms_admin.dto.category.request.UpdateCategoryRequestDto;
import com.alas.ms_admin.dto.category.response.CreateCategoryResponseDto;
import com.alas.ms_admin.dto.category.response.UpdateCategoryResponseDto;
import com.alas.ms_admin.model.category.Category;

import java.util.List;

public interface CategoryService {
    CreateCategoryResponseDto createCategory(CreateCategoryRequestDto createCategoryRequestDto);
    UpdateCategoryResponseDto updateCategory(UpdateCategoryRequestDto updateCategoryRequestDto);
    void deleteCategory(Integer id);
    CreateCategoryResponseDto findCategoryById(Integer id);
    List<CreateCategoryResponseDto> findAllCategory();
}
