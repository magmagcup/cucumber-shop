package ku.shop;

import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {
    private Map<String, Product> products;
    private Map<String, Integer> products_quantity;

    public ProductCatalog() {
        products = new HashMap<>();
        products_quantity = new HashMap<>();
    }

    public void addProduct(String name, double price, int quantity) {
        products.put(name, new Product(name, price));
        products_quantity.put(name, quantity);
    }

    public Product getProduct(String name) {
        return products.get(name);
    }

    public int getQuantity(String name) {
        return products_quantity.get(name);
    }

}
