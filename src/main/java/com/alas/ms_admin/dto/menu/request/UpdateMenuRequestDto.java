package com.alas.ms_admin.dto.menu.request;

import com.alas.ms_admin.model.branch.Branch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMenuRequestDto {
    private Integer id;
    private Integer branchId;
    //private List<Integer> categoryIds;
}
