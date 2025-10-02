package com.productCrud.productCrud.productCategory;

import com.productCrud.productCrud.productCategory.dto.ProductCategoryDto;
import org.bson.types.ObjectId;

public class ProductCategoryMapper {
    public static ProductCategoryDto toDto(ProductCategory productCategory) {
        ProductCategoryDto dto = new ProductCategoryDto();
        dto.setId(productCategory.getId().toString());
        dto.setName(productCategory.getName());
        return dto;
    }

    public static ProductCategory toEntity(ProductCategoryDto productCategoryDto) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(productCategoryDto.getId() != null ? new ObjectId(productCategoryDto.getId()) : new ObjectId());
        productCategory.setName(productCategoryDto.getName());
        return productCategory;
    }
}
