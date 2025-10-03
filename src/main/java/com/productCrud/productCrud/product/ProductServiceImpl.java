package com.productCrud.productCrud.product;

import com.productCrud.productCrud.product.dto.ProductDto;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = productRepository.save(ProductMapper.toEntity(productDto));
        return ProductMapper.toDto(product);
    }

    @Override
    public ProductDto updateProduct(String id, ProductDto productDto) {
        ObjectId objId = new ObjectId(id);
        return productRepository.findById(objId).map(existing -> {
            Product product = ProductMapper.toEntity(productDto);
            product.setId(existing.getId());
            productRepository.save(product);
            return ProductMapper.toDto(product);
        }).orElseThrow(() -> new RuntimeException("No Product found for " + id));
    }

    @Override
    public boolean deleteProduct(String id) {
        ObjectId objId = new ObjectId(id);
        if(productRepository.existsById(objId)){
            productRepository.deleteById(objId);
            return true;
        }else return false;
    }

    @Override
    public List<ProductDto> getProductList(String id, String name, String productCategory,Integer rating) {
        return productRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Product::getName))
                .filter(p -> id == null || p.getId().toString().equals(id))
                .filter(p -> name == null || p.getName().contains(name))
                .filter(p -> productCategory == null || p.getName()
                        .toLowerCase()
                        .contains(productCategory.toLowerCase())
                        || p.getId()
                        .toString()
                        .equals(productCategory))
                .filter(p -> rating == null || p.getRating() < rating)
                .map(ProductMapper::toDto)
                .toList();
    }
}
