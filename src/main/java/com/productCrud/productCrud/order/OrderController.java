package com.productCrud.productCrud.order;

import com.productCrud.productCrud.order.dto.OrderDto;
import com.productCrud.productCrud.order.dto.OrderResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService service;

    @PostMapping("create-order")
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderDto orderDto){
        OrderResponseDto response = service.createOrder(orderDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("update-order/{id}")
    public ResponseEntity<OrderResponseDto> updateOrder(@PathVariable String id,
                                                @RequestBody OrderDto orderDto){
        OrderResponseDto response = service.updateOrder(id,orderDto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("delete-order/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable String id){
        boolean deleted = service.deleteOrder(id);
        String response = deleted ? "Order deleted" : "Invalid order";
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("get-order-list")
    public ResponseEntity<List<OrderResponseDto>> getOrderList(@RequestParam(required = false) String id,
                                                       @RequestParam(required = false) String user){
        List<OrderResponseDto> response = service.getOrderList(id,user);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
