package com.ass1.inv.service;

import com.ass1.inv.model.Order;
import com.ass1.inv.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order order) {
        if (orderRepository.existsById(id)) {
            order.setOrderId(id);
            return orderRepository.save(order);
        }
        return null;
    }

//    public Order updateOrder(Long id, Order order) {
//        Optional<Order> optionalOrder = orderRepository.findById(id);
//        if (optionalOrder.isPresent()) {
//            Order existingOrder = optionalOrder.get();
//            existingOrder.setCustomerId(order.getCustomerId());
//            existingOrder.setOrderDate(order.getOrderDate());
//            existingOrder.setStatus(order.getStatus());
//            existingOrder.setTotalAmount(order.getTotalAmount());
//            return orderRepository.save(existingOrder);
//        } else {
//            return null;
//        }
//    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
