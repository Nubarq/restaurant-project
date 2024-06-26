package com.alas.ms_admin.controller;

import com.alas.ms_admin.dto.product.request.CreateProductRequestDto;
import com.alas.ms_admin.dto.product.request.UpdateProductRequestDto;
import com.alas.ms_admin.dto.product.response.CreateProductResponseDto;
import com.alas.ms_admin.dto.product.response.UpdateProductResponseDto;
import com.alas.ms_admin.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ProductController {
    private ProductService service;

    @PostMapping("/create/Product")
    public CreateProductResponseDto createProduct( @RequestParam List<Integer> ingredientIds,@RequestBody CreateProductRequestDto createProductRequestDto) {
        return service.createProduct(ingredientIds,createProductRequestDto);
    }

    @DeleteMapping("/delete/Product")
    public void deleteProduct(Integer id) {
        service.deleteProduct(id);
    }

    @GetMapping("/find/Product/ById")
    public CreateProductResponseDto findProductById(Integer id) {
        return service.findProductById(id);
    }

    @PutMapping("/update/Product")
    public UpdateProductResponseDto updateProduct
            ( @RequestParam List<Integer> ingredientIds, @RequestBody UpdateProductRequestDto updateProductRequestDto) {
        return service.updateProduct( ingredientIds,updateProductRequestDto);
    }

    @GetMapping("/findAll/Products")
    public List<CreateProductResponseDto> findAllProduct() {
        return service.findAllProducts();
    }
}

