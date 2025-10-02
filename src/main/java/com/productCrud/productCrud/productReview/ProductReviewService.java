package com.productCrud.productCrud.productReview;

import com.productCrud.productCrud.productReview.dto.ProductReviewDto;

import java.util.List;

public interface ProductReviewService {
    public ProductReviewDto crateProductReview(ProductReviewDto productReview);
    public ProductReviewDto updateProductReview(String id,ProductReviewDto productReview);
    public boolean deleteProductReview(String id);
    public List<ProductReviewDto> getProductReviewList(String id,String product,Integer rating);
}
