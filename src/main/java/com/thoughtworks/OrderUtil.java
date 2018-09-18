package com.thoughtworks;

import java.util.*;

class OrderUtil {

    HashMap createOrderInfo(List<Product> products, HashMap<Long, Integer> input, User user, UUID orderId) {
        List<HashMap> productInfo = getProductInfo(products, input);
        int oderPrice = getOderPrice(productInfo);
        return getOrderInfo(productInfo, oderPrice, user, orderId);
    }

    List<HashMap> getProductInfo(List<Product> products, HashMap<Long, Integer> idCountMap) {
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
        int totalPrice = 0;
        for (HashMap hashMap : productInfo) {
            totalPrice += (Integer) hashMap.get("productTotalPrice");
        }
        return totalPrice;
    }

    HashMap getOrderInfo(List<HashMap> productInfo, int orderPrice, User user, UUID orderId) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("id", orderId);
        result.put("userId", user.getId());
        result.put("products", productInfo);
        result.put("orderPrice", orderPrice);
        return result;
    }

    public UUID generateOrderId() {
        return UUID.randomUUID();
    }
}
