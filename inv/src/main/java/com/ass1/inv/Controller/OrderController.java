package com.ass1.inv.Controller;

import com.ass1.inv.exception.BadRequestException;
import com.ass1.inv.exception.ResourceNotFoundException;
import com.ass1.inv.model.Order;
import com.ass1.inv.service.OrderService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable(name = "id") long id) {
        Order order = orderService.getOrderById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@Valid @RequestBody Order order) {
        if (order.getOrderId() != null) {
            throw new BadRequestException("Order", "id");
        }
        if (order.getCustomerId() == null) {
            throw new BadRequestException("Order", "customer id");
        }
        Order createdOrder = orderService.createOrder(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@Valid @RequestBody Order order,
                                             @PathVariable(name = "id") long id) {
        orderService.getOrderById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));

        Order updatedOrder = orderService.updateOrder(id, order);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable(name = "id") long id) {
        orderService.getOrderById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));

        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
