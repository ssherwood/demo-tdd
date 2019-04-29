package com.example.demotdd.cart;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { ShoppingCartService.class })
public class ShoppingCartServiceTests {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @MockBean
    private ShoppingCartRepo shoppingCartRepo;

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
        Instant before = Instant.now();
        ShoppingCart mockCart = ShoppingCart.builder().id(11L).build();

        given(shoppingCartRepo.save(any()))
                .willReturn(mockCart);

        // When
        ShoppingCart shoppingCart = shoppingCartService.createCart();

        // Then
        assertThat(shoppingCart).isNotNull();
        assertThat(shoppingCart.getId()).isNotNull().isEqualTo(11L);
        assertThat(shoppingCart.getCreationDate()).isNotNull().isAfter(before);
    }
}
