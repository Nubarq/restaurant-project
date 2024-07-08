package com.alas.ms_admin.service.impl;

import com.alas.ms_admin.dto.menu.request.UpdateMenuRequestDto;
import com.alas.ms_admin.dto.menu.response.CreateMenuResponseDto;
import com.alas.ms_admin.dto.menu.response.UpdateMenuResponseDto;
import com.alas.ms_admin.exeption.CustomException;
import com.alas.ms_admin.mapper.menu.MenuMapper;
import com.alas.ms_admin.model.branch.Branch;
import com.alas.ms_admin.model.category.Category;
import com.alas.ms_admin.model.menu.Menu;
import com.alas.ms_admin.repository.branch.BranchRepository;
import com.alas.ms_admin.repository.category.CategoryRepository;
import com.alas.ms_admin.repository.menu.MenuRepository;
import com.alas.ms_admin.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;
    private  final CategoryRepository categoryRepository;
    private  final BranchRepository branchRepository;

    private final MenuMapper mapper;
    @Override
    public CreateMenuResponseDto createMenu(List<Integer> categoryIds , Integer branchId ) {
        Menu menu = new Menu();
        List<Category> categories =categoryRepository.findAllById(categoryIds);
        Branch branch = branchRepository.findById(branchId).get();
        menu.setBranch(branch);
        menu.setCategories(categories);
        menu = menuRepository.save(menu);
        return mapper.mapEntityToCreateMenuResponsetDto(menu);
    }

    @Override
    public UpdateMenuResponseDto updateMenu(UpdateMenuRequestDto updateMenuRequestDto, List<Integer> categoryId) {
        Menu menu =menuRepository.findById(updateMenuRequestDto.getId()).
                orElseThrow(() -> new CustomException("not found"));
        List<Category> categories =categoryRepository.findAllById(categoryId);
        Branch branch = branchRepository.findById(updateMenuRequestDto.getBranchId()).get();
        menu.setBranch(branch);
        menu.setCategories(categories);
        menu=menuRepository.save(menu);
        return mapper.mapEntityToUpdateMenuResponseDto(menu,new UpdateMenuResponseDto());
    }

    @Override
    public void deleteMenu(Integer id) {
        Menu menu=menuRepository.findById(id).orElseThrow(() -> new CustomException("not found"));
        if(menu.isActive()==true){
            menu.setActive(false);
            menuRepository.save(menu);
        }else {
            throw new CustomException("Branch is not active already");
        }
    }

    @Override
    public CreateMenuResponseDto findMenuById(Integer id) {
        Menu menu=menuRepository.findById(id).orElseThrow(() -> new CustomException("not found"));
        return mapper.mapEntityToCreateMenuResponsetDto(menu);
    }

    @Override
    public List<CreateMenuResponseDto> findAllMenus() {
        List<Menu> menus = menuRepository.findAll();
        return menus.stream()
                .map(menu -> mapper.mapEntityToCreateMenuResponsetDto(menu)).collect(Collectors.toList());
    }
}
