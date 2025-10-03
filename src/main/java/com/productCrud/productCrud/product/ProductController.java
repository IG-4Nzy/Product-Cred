package com.productCrud.productCrud.product;

import com.productCrud.productCrud.product.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("create-product")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        ProductDto response = productService.createProduct(productDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("update-product/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable String id,
                                                    @RequestBody ProductDto productDto){
        ProductDto response = productService.updateProduct(id,productDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("delete-product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id){
        boolean deleted = productService.deleteProduct(id);
        String response = deleted ? "Product deleted" : "Product not found";
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("get-product-list")
    public ResponseEntity<List<ProductDto>> getProductList(@RequestParam(required = false) String id,
                                                           @RequestParam(required = false) String name,
                                                           @RequestParam (required = false) String productCategory,
                                                           @RequestParam(required = false) Integer rating){
        List<ProductDto> response = productService.getProductList(id,name,productCategory,rating);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
