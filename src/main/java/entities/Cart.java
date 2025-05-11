package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cart {
    private final List<Product> cartProducts = new ArrayList<>();

    public void addProduct(Product product) {
        cartProducts.add(product);
    }

    public void removeProduct(Product product) {
        cartProducts.remove(product);
    }

    public void clearCart() {
        cartProducts.clear();
    }

    public void viewCart() {
        cartProducts.forEach(product ->
                System.out.println(product.displayDetails())
        );
    }

    public double calculateTotal() {
        return cartProducts.stream()
                .mapToDouble(Product::getProductPrice)
                .sum();
    }

    public void performCheckout() {
        if (isEmpty()) {
            System.out.println("Your cart is empty!");
            return;
        }

        Order newOrder = new Order(getCartProducts());
        clearCart();
        System.out.println("Order placed successfully!");
        System.out.println("Order summary:");
        System.out.println(newOrder);
    }
}
