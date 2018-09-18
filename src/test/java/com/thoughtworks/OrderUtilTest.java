package com.thoughtworks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class OrderUtilTest {
    private OrderUtil orderUtil = new OrderUtil();
    private List<Product> products;
    private User user;


    @BeforeEach
    void init() {
        products = Arrays.asList(new Product(1, "pencil", 2),
                new Product(2, "phone", 1600),
                new Product(3, "cake", 10),
                new Product(4, "water", 3),
                new Product(5, "table", 100));
        user = new User(1, "zhang san");
    }

    @Test
    void should_get_products_totalPrice() {
        HashMap<Long, Integer> idCountMap = new HashMap<>();
        idCountMap.put(1L, 2);
        idCountMap.put(2L, 1);
        List<HashMap> productInfo = orderUtil.getProductInfo(products, idCountMap);

        assertEquals(2, productInfo.size());
        assertIterableEquals(createProductInfo(), productInfo);
    }

    @Test
    void should_get_order_total_price() {
        List<HashMap> productInfo = createProductInfo();
        int orderPrice = orderUtil.getOderPrice(productInfo);
        assertEquals(1604, orderPrice);
    }

    @Test
    void should_get_order_info() {
        List<HashMap> productInfo = createProductInfo();
        int orderPrice = 1604;

        OrderUtil mock = mock(OrderUtil.class);
        when(mock.generateOrderId()).thenReturn(UUID.fromString("bab9b263-b837-4e2a-b5bb-5e5a1c6b1bf3"));
        UUID orderId = mock.generateOrderId();

        HashMap orderInfo = orderUtil.getOrderInfo(productInfo, orderPrice, user, orderId);
        assertEquals(UUID.fromString("bab9b263-b837-4e2a-b5bb-5e5a1c6b1bf3"), orderInfo.get("id"));
        assertEquals(user.getId(), orderInfo.get("userId"));
        assertEquals(productInfo, orderInfo.get("products"));
        assertEquals(orderPrice, orderInfo.get("orderPrice"));
    }

    @Test
    void should_create_order_info() {
        HashMap<Long, Integer> idCountMap = new HashMap<>();
        idCountMap.put(1L, 2);
        idCountMap.put(2L, 1);

        OrderUtil mock = mock(OrderUtil.class);
        when(mock.generateOrderId()).thenReturn(UUID.fromString("bab9b263-b837-4e2a-b5bb-5e5a1c6b1bf3"));
        UUID orderId = mock.generateOrderId();

        HashMap orderInfo = orderUtil.createOrderInfo(products, idCountMap, user,orderId);

        assertEquals(UUID.fromString("bab9b263-b837-4e2a-b5bb-5e5a1c6b1bf3"), orderInfo.get("id"));
        assertEquals(1L, orderInfo.get("userId"));
        assertEquals(createProductInfo(), orderInfo.get("products"));
        assertEquals(1604, orderInfo.get("orderPrice"));
    }

    private List<HashMap> createProductInfo() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("productTotalPrice", 4);
        map.put("productCount", 2);
        map.put("product", products.get(0));
        HashMap<String, Object> anotherMap = new HashMap<>();
        anotherMap.put("productTotalPrice", 1600);
        anotherMap.put("productCount", 1);
        anotherMap.put("product", products.get(1));
        return Arrays.asList(map, anotherMap);
    }
}
