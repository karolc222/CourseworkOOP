package Interfaces;

import entities.Product;

import java.util.Optional;

public interface Customer {

    void displayCustomerInterface();
    void browseProducts();
    Optional<Product> searchProduct(String keyword);
    void addToCart(int productId);
    void viewCart();
    void checkout();
    
}
