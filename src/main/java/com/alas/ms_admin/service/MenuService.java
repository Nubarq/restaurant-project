package com.alas.ms_admin.service;

import com.alas.ms_admin.dto.menu.request.UpdateMenuRequestDto;
import com.alas.ms_admin.dto.menu.response.CreateMenuResponseDto;
import com.alas.ms_admin.dto.menu.response.UpdateMenuResponseDto;
import com.alas.ms_admin.model.category.Category;

import java.util.List;

public interface MenuService {
    CreateMenuResponseDto createMenu(List<Integer> categoryIds , Integer branchId);
    UpdateMenuResponseDto updateMenu(UpdateMenuRequestDto updateMenuRequestDto, List<Integer> categoryId);
    void deleteMenu(Integer id);
    CreateMenuResponseDto findMenuById(Integer id);
    List<CreateMenuResponseDto> findAllMenus();
}
