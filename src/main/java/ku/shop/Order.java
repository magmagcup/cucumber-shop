package ku.shop;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private List<OrderItem> items;
    private LocalDateTime date;
    private List<Exception> exceptions;

    public Order(int id) {
        this.id = id;
        this.items = new ArrayList<>();
        this.date = LocalDateTime.now();
        this.exceptions = new ArrayList<>();
    }

    public Order() {
        this.id = 0;
        this.items = new ArrayList<>();
        this.date = LocalDateTime.now();
    }

    public void addError(Exception e) {
        this.exceptions.add(e);
    }

    public void addItem(Product prod, int quantity) {
        items.add(new OrderItem(prod, quantity));
    }

    public int getNumberOfOrder() {
        return this.items.size();
    }

    public double getTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    public List<Exception> getExceptions() {
        return exceptions;
    }
}
