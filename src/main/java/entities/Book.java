package entities;

import java.util.Scanner;

public class Book extends Product {
    private String author;
    private String publisher;



    public Book(int id, String name, String author, String publisher, String category, String description, double price) {

        //constructor method called  when a new object is created
        this.productId = id;
        this.productName  = name;
        this.author = author;
        this.publisher = publisher;
        this.productCategory = category;
        this.productDescription = description;
        this.productPrice = price;
    }

    @Override
    public String displayDetails() {
        return "Book: " + productName + " by " + author + " (" + publisher + ") - £" + productPrice;
    }

    @Override
    protected void displayCategoryMenu(Scanner scanner) {
        this.displayCreateProductMenu(scanner);
        System.out.println("Enter book author: ");
        this.author = scanner.nextLine();
        System.out.println("Enter book publisher: ");
        this.publisher = scanner.nextLine();

    }


}
