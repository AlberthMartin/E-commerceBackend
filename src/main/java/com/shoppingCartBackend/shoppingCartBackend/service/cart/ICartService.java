package com.shoppingCartBackend.shoppingCartBackend.service.cart;

import com.shoppingCartBackend.shoppingCartBackend.model.Cart;
import com.shoppingCartBackend.shoppingCartBackend.model.User;

import java.math.BigDecimal;

public interface ICartService {
    Cart getCart(Long cartId);
    void clearCart(Long cartId);
    BigDecimal getTotalPrice(Long cartId);

    Long initializeNewCart();

    Cart getCartByUserId(Long userId);
}
