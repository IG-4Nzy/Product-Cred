package com.productCrud.productCrud.productCategory;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productCategories")
@Data
public class ProductCategory {
    @Id
    private ObjectId id;
    private String name;
}
