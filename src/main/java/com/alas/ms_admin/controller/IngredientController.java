package com.alas.ms_admin.controller;

import com.alas.ms_admin.dto.Ingredient.request.CreateIngredientRequestDto;
import com.alas.ms_admin.dto.Ingredient.request.UpdateIngredientRequestDto;
import com.alas.ms_admin.dto.Ingredient.response.CreateIngredientResponseDto;
import com.alas.ms_admin.dto.Ingredient.response.UpdateIngredientResponseDto;
import com.alas.ms_admin.service.IngredientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class IngredientController {
    private IngredientService service;

    @PostMapping("/create/ingredient")
    public CreateIngredientResponseDto createIngredient(@RequestBody CreateIngredientRequestDto createIngredientRequestDto) {
        return service.createIngredient(createIngredientRequestDto);
    }

    @DeleteMapping("/delete/ingredient")
    public void deleteIngredient(Integer id) {
        service.deleteIngredient(id);
    }

    @GetMapping("/find/ingredient/ById")
    public CreateIngredientResponseDto findIngredientById(Integer id) {
        return service.findIngredientById(id);
    }

    @PutMapping("/update/ingredient")
    public UpdateIngredientResponseDto updateCategory
            (@RequestBody UpdateIngredientRequestDto updateIngredientRequestDto) {
        return service.updateIngredient( updateIngredientRequestDto);
    }

    @GetMapping("/findAll/ingredient")
    public List<CreateIngredientResponseDto> findAllIngredient() {
        return service.findAllIngredients();
    }
}

