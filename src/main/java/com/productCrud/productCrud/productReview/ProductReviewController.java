package com.productCrud.productCrud.productReview;

import com.productCrud.productCrud.productReview.dto.ProductReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product-review")
public class ProductReviewController {

    @Autowired
    ProductReviewService productReviewService;

    @PostMapping("create-product-review")
    public ResponseEntity<ProductReviewDto> createProductReview(@RequestBody ProductReviewDto productReviewDto){
        ProductReviewDto response = productReviewService.crateProductReview(productReviewDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("update-product-review/{id}")
    public ResponseEntity<ProductReviewDto> updateProductReview(@PathVariable String id,
                                                                @RequestBody ProductReviewDto productReviewDto){
        ProductReviewDto response = productReviewService.updateProductReview(id,productReviewDto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("delete-product-review/{id}")
    public ResponseEntity<String> deleteProductReview(@PathVariable String id){
        boolean deleted = productReviewService.deleteProductReview(id);
        String response = deleted ? "Product review deleted" : "No Product review found";
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("get-product-review-list")
    public ResponseEntity<List<ProductReviewDto>> getProductReviewList(@RequestParam(required = false) String id,
                                                                       @RequestParam(required = false) String product,
                                                                       @RequestParam(required = false) Integer rating){
        List<ProductReviewDto> response = productReviewService.getProductReviewList(id,product,rating);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
