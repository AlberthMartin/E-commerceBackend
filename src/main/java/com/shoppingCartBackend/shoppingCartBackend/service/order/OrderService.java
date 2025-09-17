package com.shoppingCartBackend.shoppingCartBackend.service.order;

import com.shoppingCartBackend.shoppingCartBackend.enums.OrderStatus;
import com.shoppingCartBackend.shoppingCartBackend.exeptions.ResourceNotFoundException;
import com.shoppingCartBackend.shoppingCartBackend.model.Cart;
import com.shoppingCartBackend.shoppingCartBackend.model.Order;
import com.shoppingCartBackend.shoppingCartBackend.model.OrderItem;
import com.shoppingCartBackend.shoppingCartBackend.model.Product;
import com.shoppingCartBackend.shoppingCartBackend.repository.OrderRepository;
import com.shoppingCartBackend.shoppingCartBackend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Override
    public Order placeOrder(Long userId) {
        return null;
    }

    private Order createOrder(Cart cart) {
        Order order = new Order();
        //TODO Set the User
        order.setOrderStatus(OrderStatus.PENDING);
        order.setOrderDate(LocalDate.now());
        return order;
    }

    private List<OrderItem> createOrderItems(Order order, Cart cart) {
        return cart.getItems().stream().map(cartItem -> {
            Product product = cartItem.getProduct();
            product.setInventory(product.getInventory() - cartItem.getQuantity()); //update inventory
            productRepository.save(product);
            return new OrderItem(
                    cartItem.getQuantity(),
                    cartItem.getUnitPrice(),
                    order,
                    product);
        }).toList();
    }


    private BigDecimal calculateTotalPrice(List<OrderItem> orderItemList) {
        return orderItemList
                .stream()
                .map(item -> item.getPrice()
                        .multiply(new BigDecimal(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

    }
}
