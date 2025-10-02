package com.productCrud.productCrud.productCategory.dto;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
public class ProductCategoryDto {
    @Id
    private String id;
    private String name;
}
