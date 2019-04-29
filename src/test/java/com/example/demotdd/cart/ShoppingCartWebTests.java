package com.example.demotdd.cart;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ShoppingCartController.class)
public class ShoppingCartWebTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ShoppingCartService shoppingCartService;

    @Test
    public void shouldCreateEmptyCart() throws Exception {
        // Given
        ShoppingCart shoppingCart = ShoppingCart.builder().id(42L).build();
        given(shoppingCartService.createCart()).willReturn(shoppingCart);

        // When
        // Then
        mockMvc.perform(post("/api/cart")
                .accept(MediaType.APPLICATION_JSON))
                //.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("id").doesNotExist())
                .andExpect(jsonPath("globalId").isNotEmpty())
                .andExpect(jsonPath("creationDate").isNotEmpty());
    }
}
