package com.thoughtworks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Application {
    List<HashMap> getProductPrice(List<Product> products, HashMap<Long, Integer> input) {
        List<HashMap> result = new ArrayList<>();
        products.forEach(product -> {
            long productId = product.getId();
            if (input.containsKey(productId)) {
                HashMap<String, Object> map = new HashMap<>();
                int productPrice = product.getPrice() * input.get(productId);
                map.put("productPrice", productPrice);
                map.put("product", product);
                result.add(map);
            }
        });
        return result;
    }

    int getOderPrice(List<HashMap> productPrice) {
        int totalPrice = 0;
        for (HashMap hashMap : productPrice) {
            totalPrice += (Integer) hashMap.get("productPrice");
        }
        return totalPrice;
    }

    HashMap getOrderInfo(List<HashMap> productInfo, int orderPrice) {
        HashMap result = new HashMap();
        result.put("id", 1);
        result.put("userId", 1);
        result.put("products", productInfo);
        result.put("orderPrice", orderPrice);
        return result;
    }
}
