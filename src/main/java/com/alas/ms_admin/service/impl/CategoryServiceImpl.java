package com.alas.ms_admin.service.impl;

import com.alas.ms_admin.dto.category.request.CreateCategoryRequestDto;
import com.alas.ms_admin.dto.category.request.UpdateCategoryRequestDto;
import com.alas.ms_admin.dto.category.response.CreateCategoryResponseDto;
import com.alas.ms_admin.dto.category.response.UpdateCategoryResponseDto;
import com.alas.ms_admin.exeption.CustomException;
import com.alas.ms_admin.mapper.category.CategoryMapper;
import com.alas.ms_admin.model.category.Category;
import com.alas.ms_admin.repository.category.CategoryRepository;
import com.alas.ms_admin.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper mapper;

    @Override
    public CreateCategoryResponseDto createCategory(CreateCategoryRequestDto createCategoryRequestDto) {
        Category category=mapper.mapCreateCategoryRequestDtoToEntity(createCategoryRequestDto);
        Category savedCategory=categoryRepository.save(category);
        CreateCategoryResponseDto categoryResponseDto=mapper.mapEntityToCreateCategoryResponsetDto(savedCategory);
        return categoryResponseDto;
    }

    @Override
    public UpdateCategoryResponseDto updateCategory(UpdateCategoryRequestDto updateCategoryRequestDto) {
        Category category =categoryRepository.
                findById(updateCategoryRequestDto.getId()).orElseThrow(() -> new CustomException("not found"));
        category = mapper.mapUpdateCategoryRequestDtoToEntity(updateCategoryRequestDto,category);
        category=categoryRepository.save(category);
        return mapper.mapEntityToUpdateCategoryResponseDto(category,new UpdateCategoryResponseDto());
    }

    @Override
    public void deleteCategory(Integer id) {
        Category category=categoryRepository.findById(id).orElseThrow(() -> new CustomException("not found"));
        if(category.isActive()==true){
            category.setActive(false);
            categoryRepository.save(category);
        }else {
            throw new CustomException("Branch is not active already");
        }
    }

    @Override
    public CreateCategoryResponseDto findCategoryById(Integer id) {
        Category category=categoryRepository.findById(id).orElseThrow(() -> new CustomException("not found"));
        return mapper.mapEntityToCreateCategoryResponsetDto(category);
    }

    @Override
    public List<CreateCategoryResponseDto> findAllCategory() {
        List<Category> categories=categoryRepository.findAll();
        return categories.stream()
                .map(category -> mapper.mapEntityToCreateCategoryResponsetDto(category)).collect(Collectors.toList());
    }
}
