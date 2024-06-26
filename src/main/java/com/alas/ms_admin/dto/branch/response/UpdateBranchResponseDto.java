package com.alas.ms_admin.dto.branch.response;

import lombok.Data;

@Data
public class UpdateBranchResponseDto {

    private Integer id;
    private String name;
    private Integer restaurantId;
}
