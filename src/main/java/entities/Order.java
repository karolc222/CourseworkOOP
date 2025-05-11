package entities;

import java.util.List;

public class Order {
    private static int nextId = 1;  // auto-incrementing order ID
    private int orderId;
    private List<Product> items;
    private double totalPrice;


    public Order(List<Product> items) {
        this.orderId = nextId++;
        this.items = items;
        this.totalPrice = 0;
        for (Product p : items) {
            this.totalPrice += p.getProductPrice();
        }
    }

    public int getOrderId() {
        return orderId;
    }

    public List<Product> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        String result = "Order ID: " + orderId + "\n";
        for (Product p : items) {
            result += p.getProductName() + " - £" + p.getProductPrice() + "\n";
        }
        result += "Total: £" + totalPrice;
        return result;
    }
}