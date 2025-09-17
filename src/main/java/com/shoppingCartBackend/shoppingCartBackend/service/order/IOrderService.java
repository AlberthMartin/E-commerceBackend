package com.shoppingCartBackend.shoppingCartBackend.service.order;

import com.shoppingCartBackend.shoppingCartBackend.model.Order;

public interface IOrderService {
    Order placeOrder(Long userId);
    Order getOrderById(Long orderId);
}
