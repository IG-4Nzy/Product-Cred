package com.productCrud.productCrud.order;

import com.productCrud.productCrud.product.dto.ProductDto;
import com.productCrud.productCrud.user.User;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "orders")
@Data
public class Order {
    @Id
    private ObjectId id;
    private User user;
    private String address;
    private List<ProductDto> products;
}
