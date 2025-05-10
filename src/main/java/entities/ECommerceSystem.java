package entities;
import Interfaces.Customer;
import Interfaces.Administrator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ECommerceSystem implements Administrator, Customer {
    private Scanner scanner = new Scanner(System.in); //available to all methods  of the class
    private List<Product> products = new ArrayList<>();
    private Cart cart = new Cart();

    public ECommerceSystem(List<Product> products) {
        this.products = products;
//        stubdata();

    }

    private static final List<Electronics> inventory = new ArrayList<>();

//    private void stubdata() {
//        //electronics inventory
//        products.add(new Electronics());
//        products.add(new Electronics());
//        products.add(new Electronics());
//        products.add(new Electronics());
//        products.add(new Electronics());
//
//        //books inventory
//        //clothing inventory
//        //self-care inventory
//        //events inventory
//    }



    public void displayAdministratorInterface() {
        System.out.println("Administrator interface");
        boolean adminRunning = true;

        while (adminRunning) {
            System.out.println("\n--- Administrator Menu ---");
            System.out.println("1. Add new product in inventory"); //partially done
            System.out.println("2. Edit product information"); //
            System.out.println("3. Remove product  from inventory");
            System.out.println("4. Manage product categories");
            System.out.println("5. Generate report");
            System.out.println("6. Back to Main Menu");
            System.out.println("Choose option");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    Product product = Product.displayProductMenu(scanner);
                    System.out.println(product.displayDetails());
                    products.add(product);
                    break;

                case 2:
                    System.out.println("Choose product to edit by Id");
                    int productId = scanner.nextInt();
                    scanner.nextLine();
                    Optional<Product> productById = findProductById(productId);
                    if (productById.isPresent()) {
                        System.out.println(productById.get().displayDetails());
                        productById.get().displayEditProductMenu(scanner);
                    } else {
                        System.out.println("Product not found");
                    }
                    break;

                case 3:
                    System.out.print("Choose product to remove by Id");
                    int removeProductId = scanner.nextInt();
                    scanner.nextLine();
                    removeProduct(removeProductId);
                    break;

                case 4:
                    System.out.print("Choose category");
                    break;
                case 5:
                    System.out.print("Generate sales report");
                    break;

                case 6:
                    System.out.print("Back to main menu");
                    adminRunning = false;
                    break;
                default:
                    System.out.println("Unrecognised input, choose again.");
            }
        }
    }

    public void displayCustomerInterface() {
        System.out.println("Customer interface");
        boolean customerRunning = true;

        while (customerRunning) {
            System.out.println("\n--- Customer Menu ---");
            System.out.println("1. Browse all products");
            System.out.println("2. Search for a product");
            System.out.println("3. Add new product to cart");
            System.out.println("4. View customer cart");
            System.out.println("5. Manage customer cart");
            System.out.println("6. Checkout");
            System.out.println("Choose option");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    Product.displayBrowseProductMenu(scanner, products);
                    break;

                case 2:
                    System.out.print("Enter keyword to search for a product:");
                    String keyword = scanner.nextLine();
                    Optional<Product> searchProduct = searchProduct(keyword);
                    if (searchProduct.isPresent()) {
                        System.out.println(searchProduct.get().displayDetails());
                        System.out.println(" 1. Add to shopping cart");
                        int cartOption = scanner.nextInt();

                        if (cartOption == 1) {
                            cart.addProduct(searchProduct.get());
                        }


                    }

                    break;

                case 3:
                    System.out.print("Enter product Id to add to cart");
                    String ProductId = scanner.nextLine();
                    /*Product product = getProductById(productId);
                    if (product != null) {
                        cart.addProduct(product);
                        System.out.println("Product added to the cart.");
                    } else {
                        System.out.println("Product not found.");
                    }*/

                    break;

                case 4:
                    List<Product> cartProducts = cart.viewCart();
                    System.out.println(cartProducts);
                    break;

                case 5:
                    System.out.print("Manage cart");
                    break;

                case 6: //checkout
                    /*if (cart.isEmpty()) {
                        System.out.println("Cart is empty.");
                    } else {
                        double total = cart.getTotalPrice();
                        Order order = new Order(cart.getItems(), total);
                        order.displayOrderSummary();
                        cart.clear();
                        System.out.println("Checkout complete.");
                    }*/
                    break;

                case 7:
                    customerRunning = false;
                    System.out.println("Back to Main Menu");
                    break;

                default:
                    System.out.println("Unrecognised input, choose again.");
            }
        }
    }
    @Override
    public void addProductFromInput(Scanner scanner) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateProductInfo(int productId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeProduct(int productId) {
        Optional<Product> first = findProductById(productId);
        first.ifPresent(product -> products.remove(product));
    }

    private Optional <Product> findProductById(int productId) {
        return products.stream().filter(product -> product.getProductId() == productId).findFirst();

    }

    @Override
    public void manageProductCategories() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void generateReport() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void manageUsers() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void browseProducts() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<Product> searchProduct(String keyword) {
        return products.stream()
                .filter(product -> product.getProductName().equalsIgnoreCase(keyword))
                .findFirst();
    }

    @Override
    public void addToCart(int productId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void viewCart() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void checkout() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
