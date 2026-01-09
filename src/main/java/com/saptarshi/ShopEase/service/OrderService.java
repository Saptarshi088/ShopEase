package com.saptarshi.ShopEase.service;

import com.saptarshi.ShopEase.models.Order;
import com.saptarshi.ShopEase.models.OrderItem;
import com.saptarshi.ShopEase.models.Product;
import com.saptarshi.ShopEase.repository.OrderRepository;
import com.saptarshi.ShopEase.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderService(ProductRepository productRepository,
                        OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Transactional
    public void createOrder(Order incomingOrder) {

        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("CREATED");

        List<OrderItem> persistedItems = new ArrayList<>();

        for (OrderItem item : incomingOrder.getItems()) {

            Product product = productRepository.findById(
                    item.getProduct().getId()
            ).orElseThrow(() ->
                    new RuntimeException("Product not found with id: " +
                            item.getProduct().getId())
            );

            int requestedQty = item.getQuantity();

            if (product.getStockQuantity() < requestedQty) {
                throw new RuntimeException(
                        "Insufficient stock for product: " + product.getName()
                );
            }

            product.setStockQuantity(
                    product.getStockQuantity() - requestedQty
            );

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItem.setQuantity(requestedQty);
            orderItem.setPriceAtPurchase(product.getPrice());

            persistedItems.add(orderItem);
        }

        order.setItems(persistedItems);

        orderRepository.save(order);
    }
}
