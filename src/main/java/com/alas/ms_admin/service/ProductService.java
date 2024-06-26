package com.alas.ms_admin.service;

import com.alas.ms_admin.dto.product.request.CreateProductRequestDto;
import com.alas.ms_admin.dto.product.request.UpdateProductRequestDto;
import com.alas.ms_admin.dto.product.response.CreateProductResponseDto;
import com.alas.ms_admin.dto.product.response.UpdateProductResponseDto;
import com.alas.ms_admin.model.menu.Menu;

import java.util.List;

public interface ProductService {
    CreateProductResponseDto createProduct(List<Integer> ingredientIds,CreateProductRequestDto createProductRequestDto);
    UpdateProductResponseDto updateProduct(List<Integer> ingredientIds,UpdateProductRequestDto updateProductRequestDto);
    void deleteProduct(Integer id);
    CreateProductResponseDto findProductById(Integer id);
    List<CreateProductResponseDto> findAllProducts();
}
