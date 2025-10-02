package com.productCrud.productCrud.productCategory;

import com.productCrud.productCrud.productCategory.dto.ProductCategoryDto;

import java.util.List;

public interface ProductCategoryService {
    public ProductCategoryDto createProductCategory(ProductCategoryDto productCategoryDto);
    public ProductCategoryDto updateProductCategory(String id,ProductCategoryDto productCategoryDto);
    public boolean deleteProductCategory(String id);
    public List<ProductCategoryDto> getProductCategory(String id,String name);
}
