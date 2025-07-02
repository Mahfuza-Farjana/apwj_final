package com.Project.LibraryManagement.API;

import com.Project.LibraryManagement.Entity.Wishlist;
import com.Project.LibraryManagement.Service.WishlistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistApi {

    private final WishlistService wishlistService;

    public WishlistApi(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    // Get wishlist items for a user
    @GetMapping("/{userId}")
    public ResponseEntity<List<Wishlist>> getWishlistByUser(@PathVariable int userId) {
        return ResponseEntity.ok(wishlistService.getWishlistByUser(userId));
    }

    // Add book to wishlist
    @PostMapping("/{userId}/add/{bookId}")
    public ResponseEntity<Void> addToWishlist(@PathVariable int userId, @PathVariable int bookId) {
        wishlistService.addToWishlist(userId, bookId);
        return ResponseEntity.ok().build();
    }

    // Remove book from wishlist
    @DeleteMapping("/{userId}/remove/{bookId}")
    public ResponseEntity<Void> removeFromWishlist(@PathVariable int userId, @PathVariable int bookId) {
        wishlistService.removeFromWishlist(userId, bookId);
        return ResponseEntity.ok().build();
    }
}
