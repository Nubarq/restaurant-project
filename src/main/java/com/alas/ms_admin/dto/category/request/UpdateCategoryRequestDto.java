package com.alas.ms_admin.dto.category.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryRequestDto {
    Integer id;
    private String name;
}
