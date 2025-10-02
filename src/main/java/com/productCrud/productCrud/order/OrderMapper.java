package com.productCrud.productCrud.order;

import com.productCrud.productCrud.order.dto.OrderDto;
import com.productCrud.productCrud.order.dto.OrderResponseDto;
import com.productCrud.productCrud.product.dto.ProductDto;
import com.productCrud.productCrud.user.User;
import com.productCrud.productCrud.user.UserMapper;
import com.productCrud.productCrud.user.dto.UserDto;
import org.bson.types.ObjectId;

import java.util.List;

public class OrderMapper {

    public static OrderResponseDto toDto(Order order){
        OrderResponseDto dto = new OrderResponseDto();
        UserDto userDto = UserMapper.toDto(order.getUser());

        dto.setId(order.getId().toString());
        dto.setAddress(order.getAddress());
        dto.setUser(userDto);
        dto.setProducts(order.getProducts());
        return dto;
    }

    public static Order toEntity(OrderDto orderDto,User user, List<ProductDto> products){
        Order order = new Order();
        order.setId(orderDto.getId() == null ? new ObjectId(): new ObjectId(orderDto.getId()));
        order.setAddress(orderDto.getAddress());
        order.setUser(user);
        order.setProducts(products);
        return order;
    }
}
