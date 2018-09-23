package com.thoughtworks;

import java.sql.Timestamp;
import java.util.*;

class OrderUtil {

    Order createOrderInfo(List<Product> products, HashMap<Long, Integer> productMap, User user) {
        if (products == null || productMap == null || user == null) {
            throw new IllegalArgumentException();
        }
        GenerateId generateId = new GenerateId();
        UUID orderId = generateId.generateOrderId();
        List<HashMap> productInfo = getProductInfo(products, productMap);
        int oderPrice = getOderPrice(productInfo);
        return getOrderInfo(productInfo, oderPrice, user, orderId);
    }

    List<HashMap> getProductInfo(List<Product> products, HashMap<Long, Integer> productMap) {
        if (products == null || productMap == null) {
            throw new IllegalArgumentException();
        }
        List<HashMap> result = new ArrayList<>();
        products.forEach(product -> {
            long productId = product.getId();
            if (productMap.containsKey(productId)) {
                HashMap<String, Object> map = new HashMap<>();
                Integer productCount = productMap.get(productId);
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
        int orderPrice = 0;
        for (HashMap hashMap : productInfo) {
            orderPrice += (Integer) hashMap.get("productTotalPrice");
        }
        return orderPrice;
    }

    Order getOrderInfo(List<HashMap> productInfo, int orderPrice, User user, UUID orderId) {
        if (productInfo == null || orderPrice < 0 || user == null || orderId == null) {
            throw new IllegalArgumentException();
        }
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return new Order(orderId,user.getId(),productInfo,orderPrice,timestamp,OrderStatus.created);
    }
}
