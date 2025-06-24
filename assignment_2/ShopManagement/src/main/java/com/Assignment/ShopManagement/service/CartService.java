package com.Assignment.ShopManagement.service;

import com.Assignment.ShopManagement.entity.CartItem;
import com.Assignment.ShopManagement.repository.CartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addOrUpdate(int userId, int productId, int quantity) {
        cartRepository.addOrUpdate(userId, productId, quantity);
    }

    public void remove(int userId, int productId) {
        cartRepository.remove(userId, productId);
    }

    public List<CartItem> getCart(int userId) {
        return cartRepository.getCart(userId);
    }
}
