package com.Project.LibraryManagement.API;

import com.Project.LibraryManagement.Entity.CartItem;
import com.Project.LibraryManagement.Service.CartItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartItemApi {

    private final CartItemService cartItemService;

    public CartItemApi(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    // Get all cart items for a user
    @GetMapping("/{userId}")
    public ResponseEntity<List<CartItem>> getCartItems(@PathVariable int userId) {
        return ResponseEntity.ok(cartItemService.getCartItemsByUser(userId));
    }

    // Add book to cart
    @PostMapping("/{userId}/add/{bookId}")
    public ResponseEntity<Void> addToCart(@PathVariable int userId, @PathVariable int bookId) {
        cartItemService.addToCart(userId, bookId);
        return ResponseEntity.ok().build();
    }

    // Remove book from cart
    @DeleteMapping("/{userId}/remove/{bookId}")
    public ResponseEntity<Void> removeFromCart(@PathVariable int userId, @PathVariable int bookId) {
        cartItemService.removeFromCart(userId, bookId);
        return ResponseEntity.ok().build();
    }

    // Clear entire cart for user
    @DeleteMapping("/{userId}/clear")
    public ResponseEntity<Void> clearCart(@PathVariable int userId) {
        cartItemService.clearCart(userId);
        return ResponseEntity.ok().build();
    }
}
