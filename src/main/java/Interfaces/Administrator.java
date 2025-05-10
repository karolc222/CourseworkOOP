package Interfaces;

import java.util.Scanner;

public interface Administrator {
    void displayAdministratorInterface();
    void addProductFromInput(java.util.Scanner scanner);
    void updateProductInfo (int productId);
    void removeProduct(int productId);
    void manageProductCategories();
    void generateReport();
    void manageUsers();
    
}
