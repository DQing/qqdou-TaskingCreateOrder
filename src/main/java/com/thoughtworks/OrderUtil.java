package com.thoughtworks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class OrderUtil {

    HashMap createOrderInfo(List<Product> products, HashMap<Long, Integer> input, User user) {
        List<HashMap> productInfo = getProductInfo(products, input);
        int oderPrice = getOderPrice(productInfo);
        return getOrderInfo(productInfo, oderPrice, user);
    }

    List<HashMap> getProductInfo(List<Product> products, HashMap<Long, Integer> input) {
        List<HashMap> result = new ArrayList<>();
        products.forEach(product -> {
            long productId = product.getId();
            if (input.containsKey(productId)) {
                HashMap<String, Object> map = new HashMap<>();
                int productPrice = product.getPrice() * input.get(productId);
                map.put("productTotalPrice", productPrice);
                map.put("productCount", input.get(productId));
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

    HashMap getOrderInfo(List<HashMap> productInfo, int orderPrice, User user) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("id", 1);
        result.put("userId", user.getId());
        result.put("products", productInfo);
        result.put("orderPrice", orderPrice);
        return result;
    }
}