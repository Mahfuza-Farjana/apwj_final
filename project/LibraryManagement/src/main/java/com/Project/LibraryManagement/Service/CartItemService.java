package com.Project.LibraryManagement.Service;

import com.Project.LibraryManagement.Entity.CartItem;
import com.Project.LibraryManagement.Repository.CartItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class CartItemService {

    private final CartItemRepository cartItemRepository;

    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public List<CartItem> getCartItemsByUser(int userId) {
        return cartItemRepository.getByUserId(userId);
    }

    public void addToCart(int userId, int bookId) {

        cartItemRepository.add(userId, bookId);
    }

    public void removeFromCart(int userId, int bookId) {
        cartItemRepository.remove(userId, bookId);
    }

    public void clearCart(int userId) {
        cartItemRepository.clearCart(userId);
    }
}
