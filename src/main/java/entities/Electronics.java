package entities;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


import java.util.Scanner;

public class Electronics extends Product {

    private String productBrand;
    private int productWarranty;

    public Electronics (int productId, String productName, String productDescription, String productBrand, int productWarranty, int productPrice) {
        super(productId, productName, productDescription, productPrice);
        this.productBrand = productBrand;
        this.productWarranty = productWarranty;
        this.productCategory = "Electronics";
    }

    public Electronics() {
        this.productCategory = "Electronics";
    }


    @Override //Product class
    public String displayDetails() {
        return "Electronics: " + productName
                + " by " + productBrand
                + " (" + productWarranty + " months warranty) - £"
                + productPrice;
    }

    @Override
    protected void displayCategoryMenu(Scanner scanner) {
        displayCreateProductMenu(scanner);

        System.out.println("Set warranty period (in months): ");
        this.productWarranty = Integer.parseInt(scanner.nextLine());
        System.out.println("You set the warranty: " + this.productWarranty + "months");


        System.out.println("Enter product brand: ");
        this.productBrand = scanner.nextLine();
        System.out.println("The brand of this product is" + this.productBrand);

    }

}


    



