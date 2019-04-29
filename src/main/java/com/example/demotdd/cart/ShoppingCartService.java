package com.example.demotdd.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepo shoppingCartRepo;

    @Autowired
    public ShoppingCartService(ShoppingCartRepo shoppingCartRepo) {
        this.shoppingCartRepo = shoppingCartRepo;
    }

    public ShoppingCart createCart() {
        return shoppingCartRepo.save(ShoppingCart.builder().build());
    }
}
