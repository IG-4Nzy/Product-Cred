package com.productCrud.productCrud.productReview;

import com.productCrud.productCrud.productReview.dto.ProductReviewDto;
import org.bson.types.ObjectId;

public class ProductReviewMapper {
    public static ProductReviewDto toDto(ProductReview productReview){
        ProductReviewDto dto = new ProductReviewDto();
        dto.setId(productReview.getId().toString());
        dto.setProduct(productReview.getProduct());
        dto.setReview(productReview.getReview());
        dto.setRating(productReview.getRating());
        return dto;
    }

    public static ProductReview toEntity(ProductReviewDto dto){
        ProductReview entity = new ProductReview();
        entity.setId(dto.getId() == null ? new ObjectId() : new ObjectId(dto.getId()));
        entity.setProduct(dto.getProduct());
        entity.setReview(dto.getReview());
        entity.setRating(dto.getRating());
        return entity;
    }
}
