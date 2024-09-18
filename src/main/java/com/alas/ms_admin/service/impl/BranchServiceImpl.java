package com.alas.ms_admin.service.impl;

import com.alas.ms_admin.dto.branch.request.CreateBranchRequestDto;
import com.alas.ms_admin.dto.branch.request.UpdateBranchRequestDto;
import com.alas.ms_admin.exeption.CustomException;
import com.alas.ms_admin.mapper.branch.BranchMapper;
import com.alas.ms_admin.model.branch.Branch;
import com.alas.ms_admin.model.restaurant.Restaurant;
import com.alas.ms_admin.repository.branch.BranchRepository;
import com.alas.ms_admin.repository.restaurant.RestaurantRepository;
import com.alas.ms_admin.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {
    private final BranchRepository branchRepository;

    private final RestaurantRepository restaurantRepository;

    private final BranchMapper mapper;


    @Override
    public Restaurant createBranch(CreateBranchRequestDto createBranchRequestDto) {
        Branch branch = mapper.mapCreateBranchRequestDtoToEntity(createBranchRequestDto);
        Integer restaurantId = createBranchRequestDto.getRestaurantId();
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new CustomException(" The restaurant it belongs to is not available anymore"));
        branch.setRestaurant(restaurant);
        mapper.mapEntityToCreateBranchResponsetDto(branchRepository.save(branch));
        return restaurant;
    }

    @Override
    public Restaurant updateBranch(Integer id, UpdateBranchRequestDto updateBranchRequestDto) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new CustomException("not found"));
        branch = mapper.mapUpdateBranchRequestDtoToEntity(updateBranchRequestDto,branch);
        Restaurant restaurant = restaurantRepository.findById(updateBranchRequestDto.getRestaurantId())
                .orElseThrow(() -> new CustomException("not found"));
        branch.setRestaurant(restaurant);
        branchRepository.save(branch);
        return restaurant;
    }

    @Override
    public void deleteBranch(Integer id) {
        Branch branch = branchRepository.findById(id).orElseThrow(() -> new CustomException("not found"));
        if (branch.isActive() == true) {
            branch.setActive(false);
            branchRepository.save(branch);
        } else {
            throw new CustomException("Branch is not active already");
        }
    }

    @Override
    public Restaurant findBranchById(Integer id) {
        Branch branch = branchRepository.findById(id).orElseThrow(() -> new CustomException("not found"));
        if (branch.isActive()== true) {
            Integer restaurantId = branch.getRestaurant().getId();
            Restaurant restaurant = restaurantRepository.findById(restaurantId)
                    .orElseThrow(() -> new CustomException("not found"));
            return restaurant;
        }
        else {
            throw new CustomException("Sorry, Branch Not Found");

        }
    }
}
