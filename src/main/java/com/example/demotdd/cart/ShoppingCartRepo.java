package com.example.demotdd.cart;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public interface ShoppingCartRepo extends JpaRepository<ShoppingCart, Long> {

    Page<ShoppingCart> findByCreationDateAfter(Instant instant, Pageable pageable);
}
