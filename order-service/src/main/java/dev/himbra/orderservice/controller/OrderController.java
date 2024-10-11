package dev.himbra.orderservice.controller;

import dev.himbra.orderservice.dto.OrderRequest;
import dev.himbra.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order/")
public class OrderController {
    private final OrderService orderService;
    @PostMapping("placeOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public void placeOrder(@RequestBody OrderRequest orderRequest){
        orderService.placeOrder(orderRequest);
    }

}
