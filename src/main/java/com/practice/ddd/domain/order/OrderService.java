package com.practice.ddd.domain.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void save(Order order) {
        orderRepository.save(order);
    }

    public Order find(OrderNo no) {
        return orderRepository.findById(no).orElse(null);
    }

}
