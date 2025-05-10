package entities;

import java.util.Scanner;

public class Clothing extends Product {
    private String productBrand;


    public Clothing(int id, String name, String brand, String category, String description, String size, String colour, double price) {
        //constructor method called  when a new object is created
        this.productId = id;
        this.productName = name;
        this.productBrand = brand;
        this.productCategory = category;
        this.productDescription = description;
        this.productPrice = price;
    }


    @Override
    public String displayDetails()  {
        return "Clothing: " + productName + " (" + productBrand + ") - £" + productPrice;    }

    @Override
    protected void displayCategoryMenu(Scanner scanner) {
        this.displayCreateProductMenu(scanner);
        System.out.println("Enter clothing brand: ");
        this.productBrand = scanner.nextLine();

    }


}


