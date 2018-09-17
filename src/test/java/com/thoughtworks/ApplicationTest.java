package com.thoughtworks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest {
    private Application application = new Application();
    private List<Product> products;
    @BeforeEach
    void init() {
        products = Arrays.asList(new Product(1, "pencil", 2),
                new Product(2, "phone", 1600),
                new Product(3, "cake", 10),
                new Product(4, "water", 3),
                new Product(5, "table", 100));
    }
    @Test
    void should_get_products_totalPrice() {
        HashMap<Long, Integer> input = new HashMap<>();
        input.put(1L, 2);
        input.put(2L, 1);
        List<HashMap> productPrice = application.getProductPrice(products, input);

        assertEquals(2, productPrice.size());
        assertEquals(productPrice.get(0).get("productPrice"), 4);
        assertEquals(productPrice.get(0).get("product"), products.get(0));
        assertEquals(productPrice.get(1).get("productPrice"), 1600);
        assertEquals(productPrice.get(1).get("product"), products.get(1));
    }

    @Test
    void should_get_order_total_price() {
        HashMap<Long, Integer> input = new HashMap<>();
        input.put(1L, 2);
        input.put(2L, 1);
        List<HashMap> productPrice = application.getProductPrice(products, input);
        int orderPrice = application.getOderPrice(productPrice);
        assertEquals(1604, orderPrice);
    }
}
