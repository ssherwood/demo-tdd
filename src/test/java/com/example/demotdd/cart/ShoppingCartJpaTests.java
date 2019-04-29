package com.example.demotdd.cart;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(ShoppingCartService.class)
public class ShoppingCartJpaTests {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    public void shouldAutowire() throws Exception {
        // Given
        // When

        // Then
        assertThat(shoppingCartService).isNotNull();
    }

    @Test
    public void shouldCreateEmptyCart() throws Exception {
        // Given
        // When

        ShoppingCart cart = shoppingCartService.createCart();
        testEntityManager.flush();

        // Then
        assertThat(cart).isNotNull();
        assertThat(cart.getId()).isNotNull().isGreaterThan(0);
    }
}
