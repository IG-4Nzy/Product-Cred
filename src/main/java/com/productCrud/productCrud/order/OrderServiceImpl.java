package com.productCrud.productCrud.order;

import com.productCrud.productCrud.order.dto.OrderDto;
import com.productCrud.productCrud.order.dto.OrderResponseDto;
import com.productCrud.productCrud.product.ProductMapper;
import com.productCrud.productCrud.product.ProductRepository;
import com.productCrud.productCrud.product.dto.ProductDto;
import com.productCrud.productCrud.user.User;
import com.productCrud.productCrud.user.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    private User getUser(String id) {
        return userRepository
                .findById(new ObjectId(id))
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    private List<ProductDto> getProducts(List<String> products) {
        return productRepository.findAll()
                .stream()
                .filter(p -> products.contains(p.getId().toString()))
                .map(ProductMapper::toDto)
                .toList();
    }

    @Override
    public OrderResponseDto createOrder(OrderDto orderDto) {
        User user = getUser(orderDto.getUser());
        List<ProductDto> products = getProducts(orderDto.getProducts());
        Order order = orderRepository.save(OrderMapper.toEntity(orderDto, user,products));
        return OrderMapper.toDto(order);
    }

    @Override
    public OrderResponseDto updateOrder(String id, OrderDto orderDto) {
        ObjectId objId = new ObjectId(id);
        User user = getUser(orderDto.getUser());
        List<ProductDto> products = getProducts(orderDto.getProducts());
        return orderRepository.findById(objId).map(existing -> {
            Order order = OrderMapper.toEntity(orderDto, user,products);
            order.setId(existing.getId());
            orderRepository.save(order);
            return OrderMapper.toDto(order);
        }).orElseThrow(() -> new RuntimeException("Invalid Order"));
    }

    @Override
    public boolean deleteOrder(String id) {
        ObjectId objId = new ObjectId(id);
        if (orderRepository.existsById(objId)) {
            orderRepository.deleteById(objId);
            return true;
        } else return false;
    }

    @Override
    public List<OrderResponseDto> getOrderList(String id, String user) {
        return orderRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Order::getId))
                .filter(o -> id == null || o.getId().toString().equals(id))
                .filter(o -> user == null || o.getUser().getId().toString().equals(user) || o.getUser().getName().toLowerCase().contains(user.toLowerCase()))
                .map(OrderMapper::toDto)
                .toList();
    }
}
