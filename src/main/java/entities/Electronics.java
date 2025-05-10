package entities;

import java.util.Scanner;

public class Electronics extends Product {
    private String productBrand;
    private int productWarranty;


    public Electronics () {
        
        //constructor method called  when a new object is created   
        int id = 0;
        String name = "";
        int price = 0;
        String category = "";
        String brand = "";
        int warranty = 0;
        String description = "";


        this.productId = id;
            this.productName  = name;  
            this.productCategory = category;
            this.productDescription = description;
            this.productPrice = price;
            this.productBrand = brand;
            this.productWarranty = warranty;
    }


    @Override
    public String displayDetails() {
        return "Electronics: " + productName
                + " by " + productBrand
                + " (" + productWarranty + " months warranty) - £"
                + productPrice;
    }

    @Override
    protected void displayCreateProductMenu(Scanner scanner) {
        System.out.println("Set warranty period (in months): ");
       this.productWarranty = Integer.parseInt(scanner.nextLine());
        System.out.println("You set the warranty: " + this.productWarranty + "months");


        System.out.println("Enter product brand: ");
        this.productBrand = scanner.nextLine();
        System.out.println("The brand of this product is" + this.productBrand);
    }


    @Override
    protected void displayCategoryMenu(Scanner scanner) {
        this.displayCreateProductMenu(scanner);
        System.out.println("Enter product brand: ");
        this.productBrand = scanner.nextLine();
        
    }


    
}


