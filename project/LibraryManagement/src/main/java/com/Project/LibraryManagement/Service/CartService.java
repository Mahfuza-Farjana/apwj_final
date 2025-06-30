package com.Project.LibraryManagement.Service;

import com.Project.LibraryManagement.Entity.CartItem;
import com.Project.LibraryManagement.Repository.CartItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private CartItemRepository cartRepo;

    public void addToCart(int userId, int bookId) {
        cartRepo.add(userId, bookId);
    }

    public void removeFromCart(int userId, int bookId) {
        cartRepo.remove(userId, bookId);
    }

    public List<CartItem> getUserCart(int userId) {
        return cartRepo.getByUserId(userId);
    }

    public void clearCart(int userId) {
        cartRepo.clearCart(userId);
    }
}
