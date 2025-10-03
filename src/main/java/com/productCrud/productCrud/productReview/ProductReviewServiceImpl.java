package com.productCrud.productCrud.productReview;

import com.productCrud.productCrud.product.Product;
import com.productCrud.productCrud.product.ProductRepository;
import com.productCrud.productCrud.productReview.dto.ProductReviewDto;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductReviewServiceImpl implements ProductReviewService {

    @Autowired
    private ProductReviewRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductReviewDto crateProductReview(ProductReviewDto productReview) {
        ProductReview review = repository.save(ProductReviewMapper.toEntity(productReview));
        updateProductRating();
        return ProductReviewMapper.toDto(review);
    }

    @Override
    public ProductReviewDto updateProductReview(String id, ProductReviewDto productReview) {
        ObjectId objId = new ObjectId(id);
        return repository.findById(objId).map(existing -> {
            ProductReview review = ProductReviewMapper.toEntity(productReview);
            review.setId(existing.getId());
            repository.save(review);
            updateProductRating();
            return ProductReviewMapper.toDto(review);
        }).orElseThrow(() -> new RuntimeException("No Product review find with this id" + id));
    }

    @Override
    public boolean deleteProductReview(String id) {
        ObjectId objId = new ObjectId(id);
        if(repository.existsById(objId)){
            repository.deleteById(objId);
            updateProductRating();
            return true;
        }else return false;
    }

    @Override
    public List<ProductReviewDto> getProductReviewList(String id, String product, Integer rating) {
        return repository.findAll()
                .stream()
                .sorted(Comparator.comparing(ProductReview::getReview))
                .filter(r -> id == null || r.getId().toString().equals(id))
                .filter(r -> product == null || r.getProduct().equals(product))
                .filter(r -> rating == null || r.getRating().equals(rating))
                .map(ProductReviewMapper::toDto)
                .toList();
    }

    private void updateProductRating() {
        List<Product> products = productRepository.findAll();

        for (Product product : products) {
            List<ProductReview> productReviews = repository.findByProduct(product.getId().toString());

            if (!productReviews.isEmpty()) {
                double average = productReviews.stream()
                        .mapToInt(ProductReview::getRating)
                        .average()
                        .orElse(0.0); // fallback if no reviews

                double roundedAverage = BigDecimal.valueOf(average)
                        .setScale(2, RoundingMode.HALF_UP) // 2 decimal places
                        .doubleValue();

                product.setRating(roundedAverage);
                productRepository.save(product);
            }
        }
    }

}
