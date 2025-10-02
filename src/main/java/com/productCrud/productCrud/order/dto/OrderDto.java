package com.productCrud.productCrud.order.dto;

import com.productCrud.productCrud.product.dto.ProductDto;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class OrderDto {
    @Id
    private String id;
    private String user;
    private String address;
    private List<String> products;
}
