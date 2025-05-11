package entities;

import java.util.List;
import java.util.ArrayList;

public class Checkout {
    private Cart cart;
    private List<Order> orderHistory;

    public Checkout(Cart cart) {
        this.cart = cart;
        this.orderHistory = new ArrayList<>();
    }

    public void performCheckout() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty!");
            return;
        }

        Order newOrder = new Order(cart.getCartProducts());
        orderHistory.add(newOrder);
        cart.clearCart();
        System.out.println("Order placed successfully!");
        System.out.println("Order summary:");
        System.out.println(newOrder);
    }
}
