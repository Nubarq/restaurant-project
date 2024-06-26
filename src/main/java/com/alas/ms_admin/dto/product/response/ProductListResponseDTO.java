package com.alas.ms_admin.dto.product.response;

import lombok.Data;

import java.util.List;

@Data
public class ProductListResponseDTO {
    List<ProductResponseDTO> list;
}
