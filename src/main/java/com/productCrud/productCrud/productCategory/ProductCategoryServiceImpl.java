package com.productCrud.productCrud.productCategory;

import com.productCrud.productCrud.productCategory.dto.ProductCategoryDto;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public ProductCategoryDto createProductCategory(ProductCategoryDto productCategoryDto) {
        ProductCategory productCategory = ProductCategoryMapper.toEntity(productCategoryDto);
        repository.save(productCategory);
        return ProductCategoryMapper.toDto(productCategory);
    }

    @Override
    public ProductCategoryDto updateProductCategory(String id, ProductCategoryDto productCategoryDto) {
        ObjectId objId = new ObjectId(id);
        return repository.findById(objId).map(existing -> {
            ProductCategory category = ProductCategoryMapper.toEntity(productCategoryDto);
            category.setId(existing.getId());
            repository.save(category);
            return ProductCategoryMapper.toDto(category);
        }).orElseThrow(() -> new RuntimeException("No Product category with id"+id));
    }

    @Override
    public boolean deleteProductCategory(String id) {
        ObjectId objId = new ObjectId(id);
        if(repository.existsById(objId)){
            repository.deleteById(objId);
            return true;
        }else return false;
    }

    @Override
    public List<ProductCategoryDto> getProductCategory(String id, String name) {
        return repository.findAll()
                .stream().sorted(Comparator.comparing(ProductCategory::getName))
                .filter(p ->id == null || p.getId().toString().equals(id))
                .filter(p-> name == null || p.getName().toLowerCase().contains(name.toLowerCase()))
                .map(ProductCategoryMapper::toDto)
                .toList();
    }
}
