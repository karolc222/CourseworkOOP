package entities;
import java.util.Scanner;

public class Selfcare extends Product {
    private String productBrand;
    private String productType;



    public Selfcare (String productName, String productDescription, String productBrand, String productType, double productPrice) {
        super(productName, productDescription, productPrice);
        this.productBrand = productBrand;
        this.productType = productType;
        this.productCategory = "Selfcare";
    }

    public Selfcare() {
        this.productCategory = "Selfcare";
    }

    @Override
    public String displayDetails() {
        return "Selfcare: ID [" + productId + "] " + productName
                + " by " + productBrand
                + " (" + productType + ") - £"
                + productPrice;
    }

    @Override
    protected void displayCategoryMenu(Scanner scanner) {
        this.displayCreateProductMenu(scanner);

        System.out.println("Enter product type: ");
        this.productType = scanner.nextLine();
        System.out.println("You entered: " + productType);

        System.out.println("Enter product brand: ");
        this.productBrand = scanner.nextLine();
        System.out.println("You entered: " + productBrand);

    }


}


