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
    private List<String> categories = new ArrayList<>();

    public ECommerceSystem(List<Product> products) {
        this.products = products;
        stubdata();

        //Populating categories from the seeded products
        for (Product product : products) {
            if (!categories.contains(product.getProductCategory())) {
                categories.add(product.getProductCategory());
            }

        }

    }

    private void stubdata() {
    }

    private static final List<Electronics> inventory = new ArrayList<>();


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
                    //1.Add new product in inventory
                    Product product = Product.displayProductMenu(scanner);
                    System.out.println(product.displayDetails());
                    products.add(product);
                    break;

                case 2:
                    //Edit product information
                    System.out.println("Choose product to edit by Id ");
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
                    //3. Remove product from inventory
                    System.out.println("Choose product to remove by Id");
                    int removeProductId = scanner.nextInt();
                    scanner.nextLine();
                    removeProduct(removeProductId);
                    break;

                case 4:
                    //3. Manage product categories
                    manageProductCategories();
                    break;

                case 5:
                    //5.Generate sales report
                    System.out.println("Generate sales report");
                    break;

                case 6:
                    //6.Back to previous menu
                    System.out.println("Back to main menu");
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
                    //Shows sub-menu for each category and lists every product
                    Product.displayBrowseProductMenu(scanner, products);
                    break;

                case 2:
                    //Find first product that contains keyword
                    boolean productSearchRunning = true;

                    while (productSearchRunning) {
                        System.out.println("Enter keyword to search for a product:");
                        String keyword = scanner.nextLine();
                        Optional<Product> searchProduct = searchProduct(keyword);
                        if (searchProduct.isPresent()) {
                            System.out.println(searchProduct.get().displayDetails());
                            System.out.println(" 1. Add to shopping cart");
                            System.out.println(" 2. Back to Customer Menu");
                            int cartOption = scanner.nextInt();

                            switch (cartOption) {
                                case 1: {
                                    cart.addProduct(searchProduct.get());
                                    System.out.println("Product added to shopping cart");
                                }
                                case 2: productSearchRunning = false;
                            }
                        } else {
                            System.out.println("Product not found");
                            productSearchRunning = false;
                        }
                    }

                    break;

                case 3:
                    System.out.println("Enter product Id to add to cart");
                    int productId = Integer.parseInt(scanner.nextLine());
                    Optional<Product> opt = findProductById(productId);
                    if (opt.isPresent()) {
                        cart.addProduct(opt.get());
                        System.out.println("Product added to the cart.");
                    } else {
                        System.out.println("Product not found.");
                    }

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
        boolean managing = true;
        while (managing) {
            System.out.println("\n--- Manage Categories ---");
            System.out.println("1. List categories");
            System.out.println("2. Add category");
            System.out.println("3. Remove category");
            System.out.println("4. Back to Admin Menu");
            System.out.println("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Existing categories:");
                    for (String cat : categories) {
                        System.out.println(" - " + cat);
                    }
                    break;

                case 2:
                    System.out.println("Enter new category name: ");
                    String newCat = scanner.nextLine();
                    if (newCat.isEmpty()) {
                        System.out.println("Category name cannot be empty.");
                    } else if (!categories.contains(newCat)) {
                        categories.add(newCat);
                        System.out.println("Category added.");
                    } else {
                        System.out.println("Category already exists.");
                    }
                    break;

                case 3:
                    System.out.println("Enter category name to remove: ");
                    String remCat = scanner.nextLine();
                    if (categories.remove(remCat)) {
                        System.out.println("Category removed.");
                    } else {
                        System.out.println("Category not found.");
                    }
                    break;
                case 4:
                    managing = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
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
    public void addCategory(String category) {
        if (category != null && !category.isEmpty() && !categories.contains(category)) {
            categories.add(category);
        }
    }
    @Override
    public void removeCategory(String category) {
        categories.remove(category);
    }
    @Override
    public List<String> listCategories() {
        return new ArrayList<>(categories);
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
