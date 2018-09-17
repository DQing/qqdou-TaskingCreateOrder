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
}
