package com.Project.LibraryManagement.Service;

import com.Project.LibraryManagement.Entity.Wishlist;
import com.Project.LibraryManagement.Repository.WishlistRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class WishlistService {

    private final WishlistRepository wishlistRepository;

    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public List<Wishlist> getWishlistByUser(int userId) {
        return wishlistRepository.getByUserId(userId);
    }

    public void addToWishlist(int userId, int bookId) {
        Wishlist item = new Wishlist(null, userId, bookId, LocalDateTime.now());
        wishlistRepository.add(userId, bookId);
    }

    public void removeFromWishlist(int userId, int bookId) {
        wishlistRepository.remove(userId, bookId);
    }
}
