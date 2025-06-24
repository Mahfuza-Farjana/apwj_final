package com.Assignment.ShopManagement.service;

import com.Assignment.ShopManagement.entity.Product;
import com.Assignment.ShopManagement.repository.WishlistRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WishlistService {
    private final WishlistRepository wishlistRepository;

    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public void add(int userId, int productId) {
        wishlistRepository.add(userId, productId);
    }

    public void remove(int userId, int productId) {
        wishlistRepository.remove(userId, productId);
    }

    public List<Product> getWishlist(int userId) {
        return wishlistRepository.getWishlist(userId);
    }
}
