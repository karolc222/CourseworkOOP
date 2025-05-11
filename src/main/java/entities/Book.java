package entities;

import java.util.Scanner;

public class Book extends Product {
    private String productAuthor;
    private String productPublisher;



    public Book(String productName, String productDescription, String productAuthor, String productPublisher, double productPrice) {
        super(productName, productDescription, productPrice);
        this.productAuthor = productAuthor;
        this.productPublisher = productPublisher;
        this.productCategory = "Book";
    }

    public Book() {
        this.productCategory = "Book";
    }

    @Override
    public String displayDetails() {
        return "Book: ID [" + productId + "] "
                + productName
                + " by " + productAuthor
                + " (" + productPublisher + ") - £" + productPrice;
    }

    @Override
    protected void displayCategoryMenu(Scanner scanner) {
        this.displayCreateProductMenu(scanner);

        System.out.println("Enter book author: ");
        this.productAuthor = scanner.nextLine();
        System.out.println("You set the product author: " + productAuthor);

        System.out.println("Enter book publisher: ");
        this.productPublisher = scanner.nextLine();
        System.out.println("You set the book publisher as: " + productPublisher);

    }
}
