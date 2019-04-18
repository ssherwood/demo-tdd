package com.example.demotdd.cart;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;

@Data
@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue
    private Long id;
    private Instant creationDate = Instant.now();
}
