package com.Ecommerce.controller;

import com.Ecommerce.model.Cart;
import com.Ecommerce.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    /** ✅ Add product to cart */
    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestParam Long userId,
                                          @RequestParam Long productId,
                                          @RequestParam Integer quantity) {
        Cart updatedCart = cartService.addToCart(userId, productId, quantity);
        return new ResponseEntity<>(updatedCart, HttpStatus.OK);
    }

    /** ✅ Get user's cart */
    @GetMapping("/{userId}")
    public ResponseEntity<Cart> getCart(@PathVariable Long userId) {
        Cart cart = cartService.getCart(userId);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    /** ✅ Remove product from cart */
    @DeleteMapping("/remove")
    public ResponseEntity<Cart> removeFromCart(@RequestParam Long userId,
                                               @RequestParam Integer productId) {
        Cart updatedCart = cartService.removeFromCart(userId, productId);
        return new ResponseEntity<>(updatedCart, HttpStatus.OK);
    }

    /** ✅ Clear cart */
    @DeleteMapping("/clear/{userId}")
    public ResponseEntity<String> clearCart(@PathVariable Long userId) {
        cartService.clearCart(userId);
        return new ResponseEntity<>("Cart cleared successfully", HttpStatus.OK);
    }
}
