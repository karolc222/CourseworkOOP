package Interfaces;

import java.util.List;
import java.util.Scanner;

public interface Administrator {
    void displayAdministratorInterface();
    void addProductFromInput(Scanner scanner);
    void updateProductInfo (int productId);
    void removeProduct(int productId);
    void generateReport();
    void manageUsers();

    //Categories management
    void manageProductCategories();
    void addCategory(String category);
    void removeCategory(String category);
    List<String> listCategories();
}
