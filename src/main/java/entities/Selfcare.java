package entities;

import java.util.Scanner;


public class Selfcare extends Product {
    private String brand;
    private String type;



    public Selfcare (int id, String name, String brand, String type, String category, String description, double price) {

        //constructor method called  when a new object is created
        this.productId = id;
        this.productName  = name;
        this.brand = brand;
        this.type = type;
        this.productCategory = category;
        this.productDescription = description;
        this.productPrice = price;
    }

    @Override
    public String displayDetails() {
        return "Selfcare: " + productName + " by " + brand + " (" + type + ") - £" + productPrice;
    }

    @Override
    protected void displayCategoryMenu(Scanner scanner) {
        this.displayCreateProductMenu(scanner);

        System.out.println("Enter product type: ");
        this.type = scanner.nextLine();

        System.out.println("Enter product brand: ");
        this.brand = scanner.nextLine();

    }


}


