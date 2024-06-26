package com.alas.ms_admin.controller;

import com.alas.ms_admin.dto.menu.request.CreateMenuRequestDto;
import com.alas.ms_admin.dto.menu.request.UpdateMenuRequestDto;
import com.alas.ms_admin.dto.menu.response.CreateMenuResponseDto;
import com.alas.ms_admin.dto.menu.response.UpdateMenuResponseDto;
import com.alas.ms_admin.model.category.Category;
import com.alas.ms_admin.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class MenuController {
    private MenuService service;

    @PostMapping("/create/menu")
    public CreateMenuResponseDto createMenu(@RequestParam List<Integer> categoryIds,@RequestParam Integer id) {
        return service.createMenu(categoryIds,id);
    }

    @DeleteMapping("/delete/menu")
    public void deeleteMenu(Integer id) {
        service.deleteMenu(id);
    }

    @GetMapping("/find/menu/byId")
    public CreateMenuResponseDto findMenuById(Integer id) {
        return service.findMenuById(id);
    }

    @PutMapping("/update/menu")
    public UpdateMenuResponseDto updateMenu
            ( @RequestBody UpdateMenuRequestDto updateMenuRequestDto,@RequestParam List<Integer> categoryId) {
        return service.updateMenu( updateMenuRequestDto,categoryId);
    }

    @GetMapping("/findAll/menus")
    public List<CreateMenuResponseDto> findAllMenu() {
        return service.findAllMenus();
    }
}

