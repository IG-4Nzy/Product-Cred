package com.productCrud.productCrud.productReview;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
@Data
public class ProductReview {
    @Id
    private ObjectId id;
    private String product;
    private String review;
    private Integer rating;
}
