package com.Assignment.ShopManagement.service;

import com.Assignment.ShopManagement.entity.CartItem;
import com.Assignment.ShopManagement.entity.Order;
import com.Assignment.ShopManagement.entity.OrderItem;
import com.Assignment.ShopManagement.entity.Product;
import com.Assignment.ShopManagement.repository.CartRepository;
import com.Assignment.ShopManagement.repository.OrderRepository;
import com.Assignment.ShopManagement.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, CartRepository cartRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public void checkout(int userId, double discountRate) {
        List<CartItem> cartItems = cartRepository.getCart(userId);
        double total = 0.0;
        List<OrderItem> orderItems = new ArrayList<>();

        for (CartItem cartItem : cartItems) {
            Product product = productRepository.findById(cartItem.getProductId());
            double price = product.getPrice().doubleValue();
            int quantity = cartItem.getQuantity();
            double discount = 0.0;

            if (product.getExpiryDate() != null && !product.getExpiryDate().isAfter(LocalDate.now().plusDays(3))) {
                discount = price * discountRate;
            }

            double finalPrice = (price - discount) * quantity;
            total += finalPrice;

            OrderItem item = new OrderItem();
            item.setProductId(product.getId());
            item.setQuantity(quantity);
            item.setPrice(price);
            item.setDiscount(discount);
            orderItems.add(item);
        }

        Order order = new Order();
        order.setUserId(userId);
        order.setOrderDate(LocalDate.now());
        order.setTotalPrice(total);
        int orderId = orderRepository.save(order);

        for (OrderItem item : orderItems) {
            item.setOrderId(orderId);
            orderRepository.saveOrderItem(item);
        }
    }

    public List<Order> getUserOrders(int userId) {
        return orderRepository.findByUserId(userId);
    }

    public List<OrderItem> getOrderItems(int orderId) {
        return orderRepository.findItemsByOrderId(orderId);
    }

    public List<Object[]> getMonthlyReport() {
        return orderRepository.getMonthlySalesReport();
    }
}
