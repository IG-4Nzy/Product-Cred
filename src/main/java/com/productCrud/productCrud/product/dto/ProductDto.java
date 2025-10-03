package com.productCrud.productCrud.product.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class ProductDto {
    @Id
    private String id;
    private String name;
    private String category;
    private double rating;
}
