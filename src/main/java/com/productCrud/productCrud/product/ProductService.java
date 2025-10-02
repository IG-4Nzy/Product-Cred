package com.productCrud.productCrud.product;

import com.productCrud.productCrud.product.dto.ProductDto;

import java.util.List;

public interface ProductService {
    public ProductDto createProduct(ProductDto productDto);
    public ProductDto updateProduct(String id,ProductDto productDto);
    public boolean deleteProduct(String id);
    public List<ProductDto> getProductList(String id,String name,String productCategory);
}
