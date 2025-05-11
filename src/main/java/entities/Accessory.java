package entities;
import java.util.Scanner;

public class Accessory extends Product {
    private String productType;
    private String productBrand;




    public Accessory (String productName, String productType, String productBrand, String productDescription, double productPrice) {
        super(productName, productDescription, productPrice);
        this.productType = productType;
        this.productBrand = productBrand;
        this.productCategory = "Accessory";
    }

    public Accessory() {
        this.productCategory = "Accessory";
    }


    @Override
    public String displayDetails() {
        return "Accessory: ID [" + productId + "] " + productName
                + " by " + productBrand
                + " (" + productType
                + ") - £" + productPrice;
    }

    @Override
    protected void displayCategoryMenu(Scanner scanner) {
        this.displayCreateProductMenu(scanner);

        System.out.println("Enter accessory type: (bag, watch or headpiece");
        this.productType = scanner.nextLine();
        System.out.println("You set the accessory type: " + productType);

        System.out.println("Enter accessory brand: ");
        this.productBrand = scanner.nextLine();
        System.out.println("You set the accessory brand: " + productBrand);

    }
}