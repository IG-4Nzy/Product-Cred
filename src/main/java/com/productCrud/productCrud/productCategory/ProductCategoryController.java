package com.productCrud.productCrud.productCategory;

import com.productCrud.productCrud.productCategory.dto.ProductCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product-category")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @PostMapping("create-product-category")
    public ResponseEntity<ProductCategoryDto> createProductCategory(@RequestBody ProductCategoryDto productCategoryDto){
        ProductCategoryDto response = productCategoryService.createProductCategory(productCategoryDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("update-product-category/{id}")
    public ResponseEntity<ProductCategoryDto> updateProductCategory(@PathVariable String id,
                                                                    @RequestBody ProductCategoryDto productCategoryDto){
        ProductCategoryDto response = productCategoryService.updateProductCategory(id,productCategoryDto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("delete-product-category/{id}")
    public ResponseEntity<String> deleteProductCategory(@PathVariable String id){
        boolean deleted = productCategoryService.deleteProductCategory(id);
        String response = deleted ? "Product category deleted ":"Product category not found";
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("get-product-category-list")
    public ResponseEntity<List<ProductCategoryDto>> getProductCategoryList(@RequestParam(required = false) String id,
                                                                           @RequestParam(required = false) String name){
        List<ProductCategoryDto> response = productCategoryService.getProductCategory(id,name);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
