package entities;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


public abstract class Product {
    protected static int nextId = 1;
    protected int productId;
    protected String productName;
    protected String productDescription;
    protected String productCategory;
    protected double productPrice;

    public Product() {}

    //constructor to initialise id, name description and price
    public Product( String productName, String productDescription, double productPrice) {
        this.productId = nextId++;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }

    //Abstract method to be implemented by subclasses
    public abstract String displayDetails();

    //getters to read product data
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }


    //setters to update product data
    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProductPrice(double ProductPrice) {
        this.productPrice = productPrice;
    }


    //Method for creating new Products used by all subclasses
    protected void displayCreateProductMenu(Scanner scanner) {

        System.out.println("Enter product name: ");
        this.productName = scanner.nextLine();
        System.out.println("You chose: " + this.productName);

        System.out.println("Enter product description: ");
        this.productDescription = scanner.nextLine();
        System.out.println("You chose: " + this.productDescription);

        System.out.println("Enter product price: ");
        this.productPrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("You set the price at: " + this.productPrice);

        System.out.println("Enter product category: ");
        this.productCategory = scanner.nextLine();
        System.out.println("You set the category: " + this.productCategory);
    }

    //method for editing product information
    protected void displayEditProductMenu(Scanner scanner) {

        System.out.println("Edit product name: " + this.productName);
        String productName1 = scanner.nextLine();
        if (!productName1.isEmpty()) {
            this.productName = productName1;
            System.out.println("You chose: " + this.productName);
        }

        System.out.println("Edit product description: " + this.productDescription);
        String productDescription = scanner.nextLine();
        if (!productDescription.isEmpty()) {
            this.productDescription = productDescription;
            System.out.println("You chose: " + this.productDescription);
        }

        System.out.println("Edit product price: " + this.productPrice);
        double productPrice = scanner.nextDouble();
        scanner.nextLine();
        if (productPrice > 0) {
            this.productPrice = productPrice;
            System.out.println("You set the price at: " + this.productPrice);
        }

        System.out.println("Enter product category: ");
        String productCategory = scanner.nextLine();
        if (!productCategory.isEmpty()) {
            this.productCategory = productCategory;
            System.out.println("You set the category: " + this.productCategory);
        }
    }

    protected abstract void displayCategoryMenu(Scanner scanner);


    //Menu for adding new products
    public static Product displayProductMenu(Scanner scanner) {

        Product product = null;
        //Category menu
        boolean productMenuRunning = true;
        while (productMenuRunning) {
            System.out.println("\n--- Choose product category---");
            System.out.println("1. Electronics");
            System.out.println("2. Books");
            System.out.println("3. Clothing");
            System.out.println("4. Self-care");
            System.out.println("5. Events");
            System.out.println("6. Back to Main Menu");
            System.out.println("Choose option");

            int option = scanner.nextInt();
            scanner.nextLine();

            //Category options menu for product creation
            switch (option) {
                case 1:
                    //1.Electronics
                    System.out.println("Creating a new Electronics Product");
                    product = new Electronics();
                    product.displayCategoryMenu(scanner);
                    break;


                case 2:
                    //2.Books
                    System.out.println("Creating a new Books Product");
                    product = new Book();
                    product.displayCategoryMenu(scanner);
                    break;

                case 3:
                    //3.Clothing
                    System.out.println("Creating a new Clothing Product");
                    product = new Clothing();
                    product.displayCategoryMenu(scanner);
                    break;

                case 4:
                    //4.Self-care
                    System.out.println("Creating a new Self-care Product");
//                  product = new Selfcare();
                    product.displayCategoryMenu(scanner);
                    break;

                case 5:
                    //5.Accessories
                    System.out.println("Creating a new Accessory Product");
//                    product = new Accessory();
                    product.displayCategoryMenu(scanner);
                    break;

                case 6:
                    System.out.println("Back to main menu");
                    productMenuRunning = false;
                    break;
                default:
                    System.out.println("Unrecognised input, choose again.");
            }

        }

        return product;
    }

    public static void displayBrowseProductMenu(Scanner scanner, List<Product> products) {

        boolean productMenuRunning = true;
        while (productMenuRunning) {
            System.out.println("\n--- Choose product category---");
            System.out.println("1. Electronics");
            System.out.println("2. Books");
            System.out.println("3. Clothing");
            System.out.println("4. Self-care");
            System.out.println("5. Accessories");
            System.out.println("6. Back to Main Menu");
            System.out.println("Choose option");

            int option = scanner.nextInt();
            scanner.nextLine();


            Map<String, List<Product>> productsByCategory = null;

            //Category menu
            switch (option) {
                case 1:
                    System.out.println("Listing all Electronics Products");
                    productsByCategory =
                            products.stream().collect(Collectors.groupingBy(Product::getProductCategory));
                    productsByCategory.get("Electronics").forEach(product -> {System.out.println(product.displayDetails());});
                    break;

                case 2:
                    System.out.println("Listing all Book Products");
                    productsByCategory =
                            products.stream().collect(Collectors.groupingBy(Product::getProductCategory));
                    productsByCategory.get("Book").forEach(product -> {System.out.println(product.displayDetails());});
                    break;

                case 3:
                    System.out.println("Listing all Clothing Products");
                    productsByCategory =
                            products.stream().collect(Collectors.groupingBy(Product::getProductCategory));
                    productsByCategory.get("Clothing").forEach(product -> {System.out.println(product.displayDetails());});
                    break;

                case 4:
                    System.out.println("Listing all Self-care Products");
                    productsByCategory =
                            products.stream().collect(Collectors.groupingBy(Product::getProductCategory));
                    productsByCategory.get("Selfcare").forEach(product -> {System.out.println(product.displayDetails());});
                    break;

                case 5:
                    System.out.println("Listing all Accessory Products");
                    productsByCategory =
                            products.stream().collect(Collectors.groupingBy(Product::getProductCategory));
                    productsByCategory.get("Accessory").forEach(product -> {System.out.println(product.displayDetails());});
                    break;

                case 6:
                    System.out.println("Back to main menu");
                    productMenuRunning = false;
                    break;
                default:
                    System.out.println("Unrecognised input, choose again.");
            }

        }
    }
}
