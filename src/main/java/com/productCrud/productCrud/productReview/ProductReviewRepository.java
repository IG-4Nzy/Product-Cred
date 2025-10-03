package com.productCrud.productCrud.productReview;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReviewRepository extends MongoRepository<ProductReview, ObjectId> {
    List<ProductReview> findByProduct(String string);
}
