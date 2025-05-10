package entities;
import java.util.Scanner;

public class Accessory extends Product {
    private String productColour;
    private String productStyle;
    private String productBrand;


    public Accessory(int id, String name, String brand, String style, String colour, String category, String description, double price) {

        //constructor method called  when a new object is created
        this.productId = id;
        this.productName  = name;
        this.productColour = colour;
        this.productStyle = style;
        this.productBrand = brand;
        this.productCategory = category;
        this.productDescription = description;
        this.productPrice = price;

    }

    @Override
    public String displayDetails() {
        return "Accessory: " + productName + " by " + productBrand + " (" + productStyle + ", Colour: " + productColour + ") - £" + productPrice;    }

    @Override
    protected void displayCategoryMenu(Scanner scanner) {
        this.displayCreateProductMenu(scanner);
        System.out.println("Enter accessory style type: ");
        this.productStyle = scanner.nextLine();

        System.out.println("Enter accessory colour: ");
        this.productColour = scanner.nextLine();

        System.out.println("Enter accessory brand: ");
        this.productBrand = scanner.nextLine();

        System.out.println("Enter accessory category: ");
        this.productCategory = scanner.nextLine();

    }



}