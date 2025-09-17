package com.shoppingCartBackend.shoppingCartBackend.repository;

import com.shoppingCartBackend.shoppingCartBackend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
