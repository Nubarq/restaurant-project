package com.alas.ms_admin.dto.menu.response;

import lombok.Data;

import java.util.List;

@Data
public class CreateMenuResponseDto {
    private Integer branchId;
    private List<Integer> categoryIds;

}
