package com.productCrud.productCrud.order.dto;

import com.productCrud.productCrud.product.dto.ProductDto;
import com.productCrud.productCrud.user.dto.UserDto;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class OrderResponseDto {
    @Id
    private String id;
    private UserDto user;
    private String address;
    private List<ProductDto> products;
}
