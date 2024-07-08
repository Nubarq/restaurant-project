package com.alas.ms_admin.service.impl;

import com.alas.ms_admin.dto.menu.response.UpdateMenuResponseDto;
import com.alas.ms_admin.dto.product.request.CreateProductRequestDto;
import com.alas.ms_admin.dto.product.request.UpdateProductRequestDto;
import com.alas.ms_admin.dto.product.response.CreateProductResponseDto;
import com.alas.ms_admin.dto.product.response.UpdateProductResponseDto;
import com.alas.ms_admin.exeption.CustomException;
import com.alas.ms_admin.mapper.menu.MenuMapper;
import com.alas.ms_admin.mapper.product.ProductMapper;
import com.alas.ms_admin.model.branch.Branch;
import com.alas.ms_admin.model.category.Category;
import com.alas.ms_admin.model.ingredient.Ingredient;
import com.alas.ms_admin.model.menu.Menu;
import com.alas.ms_admin.model.product.Product;
import com.alas.ms_admin.repository.ingredient.IngredientRepository;
import com.alas.ms_admin.repository.menu.MenuRepository;
import com.alas.ms_admin.repository.product.ProductRepository;
import com.alas.ms_admin.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper mapper;
    private final IngredientRepository ingredientRepository;

    @Override
    public CreateProductResponseDto createProduct( List<Integer> ingredientIds,
                                                   CreateProductRequestDto createProductRequestDto) {
        Product product=new Product();
        List<Ingredient> ingredients =ingredientRepository.findAllById(ingredientIds);
        product.setIngredients(ingredients);
        product=mapper.mapCreateProductRequestDtoToEntity(createProductRequestDto);
        Product savedProduct=productRepository.save(product);
        return mapper.mapEntityToCreateProductResponsetDto(savedProduct);
    }

    @Override
    public UpdateProductResponseDto updateProduct(List<Integer> ingredientIds,
                                                  UpdateProductRequestDto updateProductRequestDto) {
        Product product =productRepository.
                findById(updateProductRequestDto.getId()).orElseThrow(() -> new CustomException("not found"));
        List<Ingredient> ingredients =ingredientRepository.findAllById(ingredientIds);
        product.setIngredients(ingredients);
        product = mapper.mapUpdateProductRequestDtoToEntity(updateProductRequestDto,product);
        product=productRepository.save(product);
        return mapper.mapEntityToUpdateProductResponseDto(product,new UpdateProductResponseDto());
    }

    @Override
    public void deleteProduct(Integer id) {
        Product product=productRepository.findById(id).orElseThrow(() -> new CustomException("not found"));
        if(product.isActive()==true){
            product.setActive(false);
            productRepository.save(product);
        }else {
            throw new CustomException("Branch is not active already");
        }
    }

    @Override
    public CreateProductResponseDto findProductById(Integer id) {
        Product product=productRepository.findById(id).orElseThrow(() -> new CustomException("not found"));
        return mapper.mapEntityToCreateProductResponsetDto(product);
    }

    @Override
    public List<CreateProductResponseDto> findAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> mapper.mapEntityToCreateProductResponsetDto(product)).collect(Collectors.toList());
    }
}
