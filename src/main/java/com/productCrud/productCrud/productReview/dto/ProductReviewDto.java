package com.productCrud.productCrud.productReview.dto;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
public class ProductReviewDto {
    @Id
    private String id;
    private String product;
    private String review;
    private Integer rating;
}
