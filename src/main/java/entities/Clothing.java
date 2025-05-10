package entities;

import java.util.Scanner;

public class Clothing extends Product {

    private String productBrand;
    private String size;
    private String colour;



    public Clothing(int productId, String productName, String productBrand, String productDescription, String productSize, String productColour, double productPrice) {
        //constructor method called  when a new object is created
        super(productId, productName, productDescription, productPrice);

        this.productBrand = productBrand;
        this.productCategory = "Clothing";
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override //Product class
    public String displayDetails() {
        return "Clothing: {" + productName + " (" + productBrand + ") - £" + productPrice;    }

    @Override
    protected void displayCategoryMenu(Scanner scanner) {
//        displayCreateProductMenu(scanner);
//
//        System.out.println("Set warranty period (in months): ");
//        this.productWarranty = Integer.parseInt(scanner.nextLine());
//        System.out.println("You set the warranty: " + this.productWarranty + "months");
//
//
//        System.out.println("Enter product brand: ");
//        this.productBrand = scanner.nextLine();
//        System.out.println("The brand of this product is" + this.productBrand);

    }


//    @Override
//    protected void displaySpecificEditMenu (Scanner scanner) {
//        System.out.println("Select size: S/M/L");
//        this.size = scanner.nextLine();
//        System.out.println("Selected size: " + this.size);
//
//        System.out.println("Select colour: S/M/L");
//        this.colour = scanner.nextLine();
//        System.out.println("Selected colour: " + this.colour);
//
//
//    }




}


