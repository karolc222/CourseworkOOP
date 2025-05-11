package entities;
import java.util.Scanner;

public class Clothing extends Product {

    private String productBrand;
    private char productSize;
    private String productColour;


    public Clothing(String productName, String productBrand, String productDescription, char productSize, String productColour, double productPrice) {
        super(productName, productDescription, productPrice);
        this.productBrand = productBrand;
        this.productSize = productSize;
        this.productColour = productColour;
        this.productCategory = "Clothing";
    }

    public Clothing() {
        this.productCategory = "Clothing";
    }


    @Override
    public String displayDetails() {
        return "Clothing: ID [" + productId + "] " + productName
                + ", in " + productColour
                + ", size: " + productSize
                + " by " + productBrand
                + " £ " + productPrice;
    }


    @Override
    protected void displayCategoryMenu(Scanner scanner) {
        displayCreateProductMenu(scanner);

        System.out.println("Enter product brand: ");
        this.productBrand = scanner.nextLine();
        System.out.println("The brand of this product is" + this.productBrand);

        System.out.println("Select size: S/M/L");
        String sizeInput = scanner.next();
        this.productSize = sizeInput.charAt(0);
        System.out.println("Selected size: " + this.productSize);
        
        System.out.println("Select product colour:");
        this.productColour = scanner.nextLine();
        System.out.println("The product colour is" + this.productColour);
        


    }

}



