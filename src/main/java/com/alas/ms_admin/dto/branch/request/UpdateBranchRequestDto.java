package com.alas.ms_admin.dto.branch.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBranchRequestDto {
    private String name;
    private Integer restaurantId;
}
