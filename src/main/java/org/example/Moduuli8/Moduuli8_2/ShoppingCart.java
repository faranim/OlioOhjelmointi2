package org.example.Moduuli8.Moduuli8_2;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, Double> items;

    public ShoppingCart() {
        items = new HashMap<>();
    }

    public void addItem(String name, double price) {
        items.put(name, price);
    }

    public void removeItem(String name) {
        items.remove(name);
    }

    public int getItemCount() {
        return items.size();
    }

    public double calculateTotal() {
        return items.values().stream().mapToDouble(Double::doubleValue).sum();
    }
}

