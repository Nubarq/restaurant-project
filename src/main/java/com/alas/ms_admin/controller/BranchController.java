package com.alas.ms_admin.controller;

import com.alas.ms_admin.dto.branch.request.CreateBranchRequestDto;
import com.alas.ms_admin.dto.branch.request.UpdateBranchRequestDto;
import com.alas.ms_admin.model.restaurant.Restaurant;
import com.alas.ms_admin.service.BranchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class BranchController {
    private BranchService branchService;

    @PostMapping("/create/branch")
    public Restaurant createBranch(@RequestBody CreateBranchRequestDto createBranchRequestDto) {
        Restaurant restaurant = branchService.createBranch(createBranchRequestDto);
        return restaurant;
    }

    @PutMapping("/update/branch/{id}")
    public Restaurant updateBranch(@PathVariable Integer id, @RequestBody UpdateBranchRequestDto updateBranchRequestDto) {
        Restaurant restaurant = branchService.updateBranch(id,updateBranchRequestDto);
        return restaurant;
    }

    @DeleteMapping("/delete/branch/{id}")
    public void deleteBranch(@PathVariable Integer id) {
        branchService.deleteBranch(id);
    }

    @GetMapping("/find/branch/byId")
    public Restaurant findBranchById(@RequestParam Integer id) {
        return branchService.findBranchById(id);
    }
}
