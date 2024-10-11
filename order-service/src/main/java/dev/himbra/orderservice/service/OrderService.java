package dev.himbra.orderservice.service;

import dev.himbra.orderservice.dto.OrderRequest;
import dev.himbra.orderservice.model.Order;
import dev.himbra.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    public void placeOrder(OrderRequest orderRequest){
        Order order=new Order();
        BeanUtils.copyProperties(orderRequest,order);
        orderRepository.save(order);
        log.info("Order placed successfully for item: {}", order.getId());

    }
}
