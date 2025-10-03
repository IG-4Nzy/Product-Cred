package com.productCrud.productCrud.product;

import com.productCrud.productCrud.product.dto.ProductDto;
import org.bson.types.ObjectId;

public class ProductMapper {
    public  static ProductDto toDto(Product product){
        ProductDto dto = new ProductDto();
        dto.setId(product.getId().toString());
        dto.setName(product.getName());
        dto.setCategory(product.getCategory());
        dto.setRating(product.getRating());
        return dto;
    }

    public static Product toEntity(ProductDto productDto){
        Product entity = new Product();
        entity.setId(productDto.getId() != null ? new ObjectId(productDto.getId()) : new ObjectId());
        entity.setName(productDto.getName());
        entity.setCategory(productDto.getCategory());
        return entity;
    }
}
