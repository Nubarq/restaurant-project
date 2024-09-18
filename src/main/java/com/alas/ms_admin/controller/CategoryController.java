package com.alas.ms_admin.controller;

import com.alas.ms_admin.dto.category.request.CreateCategoryRequestDto;
import com.alas.ms_admin.dto.category.request.UpdateCategoryRequestDto;
import com.alas.ms_admin.dto.category.response.CreateCategoryResponseDto;
import com.alas.ms_admin.dto.category.response.UpdateCategoryResponseDto;
import com.alas.ms_admin.service.CategoryService;
;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CategoryController {
    private CategoryService service;

    @PostMapping("/create/category")
    public CreateCategoryResponseDto createCategory(@RequestBody CreateCategoryRequestDto createCategoryRequestDto) {
        return service.createCategory(createCategoryRequestDto);
    }

    @DeleteMapping("/delete/category")
    public void deleteCategory(Integer id) {
        service.deleteCategory(id);
    }

    @GetMapping("/find/category/ById")
    public CreateCategoryResponseDto findCategoryById(Integer id) {
        return service.findCategoryById(id);
    }

    @PutMapping("/update/category")
    public UpdateCategoryResponseDto updateCategory
            (@RequestBody UpdateCategoryRequestDto updateCategoryRequestDto) {
        return service.updateCategory(updateCategoryRequestDto);
    }

    @GetMapping("/findAll/categories")
    public List<CreateCategoryResponseDto> findAllCategory() {
        return service.findAllCategory();
    }
}
