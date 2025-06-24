package com.Assignment.ShopManagement.api;

import com.Assignment.ShopManagement.entity.*;
import com.Assignment.ShopManagement.service.*;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class ShopManagementApi {



        private static final Logger logger = Logger.getLogger(ShopManagementApi.class.getName());

        private final UserService userService;
        private final ProductService productService;
        private final WishlistService wishlistService;
        private final CartService cartService;
        private final OrderService orderService;

        public ShopManagementApi(UserService userService, ProductService productService,
                            WishlistService wishlistService, CartService cartService,
                            OrderService orderService) {
            this.userService = userService;
            this.productService = productService;
            this.wishlistService = wishlistService;
            this.cartService = cartService;
            this.orderService = orderService;
        }



        @PostMapping("/users")
        public void registerUser(@Valid @RequestBody User user, BindingResult result) {
            if (result.hasErrors()) {
                logger.warning(Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
                return;
            }
            userService.save(user);
        }



        @PostMapping("/products")
        public void addProduct(@RequestBody Product product) {
            productService.save(product);
        }

        @PutMapping("/products/{id}")
        public void updateProduct(@PathVariable int id, @RequestBody Product product) {
            product.setId(id);
            productService.update(product);
        }

        @DeleteMapping("/products/{id}")
        public void deleteProduct(@PathVariable int id) {
            productService.delete(id);
        }

        @GetMapping("/products")
        public List<Product> getAllProducts() {
            return productService.findAll();
        }



        @PostMapping("/wishlist/{userId}/{productId}")
        public void addToWishlist(@PathVariable int userId, @PathVariable int productId) {
            wishlistService.add(userId, productId);
        }

        @DeleteMapping("/wishlist/{userId}/{productId}")
        public void removeFromWishlist(@PathVariable int userId, @PathVariable int productId) {
            wishlistService.remove(userId, productId);
        }

        @GetMapping("/wishlist/{userId}")
        public List<Product> getWishlist(@PathVariable int userId) {
            return wishlistService.getWishlist(userId);
        }



        @PostMapping("/cart/{userId}/{productId}/{quantity}")
        public void addToCart(@PathVariable int userId, @PathVariable int productId, @PathVariable int quantity) {
            cartService.addOrUpdate(userId, productId, quantity);
        }

        @DeleteMapping("/cart/{userId}/{productId}")
        public void removeFromCart(@PathVariable int userId, @PathVariable int productId) {
            cartService.remove(userId, productId);
        }

        @GetMapping("/cart/{userId}")
        public List<CartItem> getCart(@PathVariable int userId) {
            return cartService.getCart(userId);
        }


        @PostMapping("/checkout/{userId}")
        public void checkout(@PathVariable int userId, @RequestParam("discountRate") double discountRate) {
            orderService.checkout(userId, discountRate);
        }

        @GetMapping("/orders/{userId}")
        public List<Order> getOrders(@PathVariable int userId) {
            return orderService.getUserOrders(userId);
        }

        @GetMapping("/orders/items/{orderId}")
        public List<OrderItem> getOrderItems(@PathVariable int orderId) {
            return orderService.getOrderItems(orderId);
        }

        @GetMapping("/report/monthly")
        public List<Object[]> getMonthlyReport() {
            return orderService.getMonthlyReport();
        }
}
