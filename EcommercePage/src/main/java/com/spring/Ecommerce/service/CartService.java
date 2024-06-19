package com.spring.Ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.Ecommerce.model.Cart;
import com.spring.Ecommerce.model.Order;
import com.spring.Ecommerce.model.Product;
import com.spring.Ecommerce.model.User;
import com.spring.Ecommerce.repository.CartRepository;
import com.spring.Ecommerce.repository.OrderRepository;
import com.spring.Ecommerce.repository.ProductRepository;
import com.spring.Ecommerce.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public List<Cart> getCartItems(Long userId) {
        return cartRepository.findByUserId(userId);
    }
    
    @Transactional
    public void addToCart(Long userId, Long productId) {
        Cart cart = new Cart();

        User user = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + userId));
        cart.setUser(user);
        
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID: " + productId));
            cart.setProduct(product);

        cartRepository.save(cart);
    }

    @Transactional
    public void removeFromCart(Long userId, Long productId) {
        cartRepository.deleteByUserIdAndProductId(userId, productId);
    }
    
    @Transactional
    public int getCartCount(Long userId) {
        return cartRepository.findByUserId(userId).size();
    }
    
    
    public void placeOrder(User user, double totalAmount) {
        Order order = new Order();
        order.setUser(user);
        order.setTotalAmount(totalAmount);
        order.setOrderDate(LocalDateTime.now());
        orderRepository.save(order);
    }
}