package com.productCrud.productCrud.order;

import com.productCrud.productCrud.order.dto.OrderDto;
import com.productCrud.productCrud.order.dto.OrderResponseDto;

import java.util.List;

public interface OrderService {
    public OrderResponseDto createOrder(OrderDto orderDto);
    public OrderResponseDto updateOrder(String id,OrderDto orderDto);
    public boolean deleteOrder(String id);
    public List<OrderResponseDto> getOrderList(String id,String user);
}
