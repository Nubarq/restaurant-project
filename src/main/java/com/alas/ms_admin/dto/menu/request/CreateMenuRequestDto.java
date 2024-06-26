package com.alas.ms_admin.dto.menu.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMenuRequestDto {
    private Integer branchId;
    private List<Integer> categoryIds;

}
