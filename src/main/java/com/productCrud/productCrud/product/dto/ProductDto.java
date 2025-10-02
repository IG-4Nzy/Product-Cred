package com.productCrud.productCrud.product.dto;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class ProductDto {
    @Id
    private String id;
    private String name;
    private String category;
}
