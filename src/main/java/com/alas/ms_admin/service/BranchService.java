package com.alas.ms_admin.service;

import com.alas.ms_admin.dto.branch.request.CreateBranchRequestDto;
import com.alas.ms_admin.dto.branch.request.UpdateBranchRequestDto;
import com.alas.ms_admin.model.restaurant.Restaurant;

public interface BranchService {
    Restaurant createBranch(CreateBranchRequestDto createBranchRequestDto);
    Restaurant updateBranch(Integer id , UpdateBranchRequestDto updateBranchRequestDto);
    void deleteBranch(Integer id);
    Restaurant findBranchById(Integer id);
}
