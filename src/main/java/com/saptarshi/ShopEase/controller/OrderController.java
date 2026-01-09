package com.saptarshi.ShopEase.controller;

import com.saptarshi.ShopEase.models.Order;
import com.saptarshi.ShopEase.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SuppressWarnings("unused")
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping()
    public ResponseEntity<?> createOrder(@RequestBody Order order){
        service.createOrder(order);
        return ResponseEntity.ok().build();
    }
}
