package com.thoughtworks;

import java.sql.Timestamp;
import java.util.*;

class OrderUtil {

    Order createOrderInfo(List<Product> products, HashMap<Long, Integer> input, User user, UUID orderId) {
        if (products == null || input == null || user == null || orderId == null) {
            throw new IllegalArgumentException();
        }
        List<HashMap> productInfo = getProductInfo(products, input);
        int oderPrice = getOderPrice(productInfo);
        return getOrderInfo(productInfo, oderPrice, user, orderId);
    }

    List<HashMap> getProductInfo(List<Product> products, HashMap<Long, Integer> idCountMap) {
        if (products == null || idCountMap == null) {
            throw new IllegalArgumentException();
        }
        List<HashMap> result = new ArrayList<>();
        products.forEach(product -> {
            long productId = product.getId();
            if (idCountMap.containsKey(productId)) {
                HashMap<String, Object> map = new HashMap<>();
                Integer productCount = idCountMap.get(productId);
                map.put("productTotalPrice", product.getPrice() * productCount);
                map.put("productCount", productCount);
                map.put("product", product);
                result.add(map);
            }
        });
        return result;
    }

    int getOderPrice(List<HashMap> productInfo) {
        if (productInfo == null) {
            throw new IllegalArgumentException();
        }
        int totalPrice = 0;
        for (HashMap hashMap : productInfo) {
            totalPrice += (Integer) hashMap.get("productTotalPrice");
        }
        return totalPrice;
    }

    Order getOrderInfo(List<HashMap> productInfo, int orderPrice, User user, UUID orderId) {
        if (productInfo == null || orderPrice < 0 || user == null || orderId == null) {
            throw new IllegalArgumentException();
        }
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return new Order(orderId,user.getId(),productInfo,orderPrice,timestamp,OrderStatus.created);
    }

    UUID generateOrderId() {
        return UUID.randomUUID();
    }
}
