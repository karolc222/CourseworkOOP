package entities;

import Interfaces.Administrator;
import Interfaces.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainMenu {

    private static List<Product> products = new ArrayList<>();

    static {
        seedInventory();
    }

    public static void seedInventory() {
        products.clear();

        //Electronics inventory
        products.add(new Electronics("MacBook Pro", "Laptop", "Apple", 12, 1799.99));
        products.add(new Electronics("Dell Monitor", "4k Ultra HD Monitor", "Dell", 18, 299.00));
        products.add(new Electronics("LT Mouse", "Wireless and Ergonomic build", "Logitech ", 12, 39.99));
        products.add(new Electronics("LT Mechanical Keyboard", "RGB and wireless", "Logitech", 12, 49.00));
        products.add(new Electronics("JBL Bluetooth Speaker", "Wonderboom X portable waterproof speaker", "JBL", 24, 79.00));

        //Clothing inventory
        products.add(new Clothing("Jeans", "Levi's", "Classic blue denim jeans", 'M', "Blue", 49.99));
        products.add(new Clothing("Hoodie", "H&M", "Comfortable cotton hoodie", 'L', "Black", 39.00));
        products.add(new Clothing("Running Shorts", "Nike", "Lightweight athletic shorts", 'S', "Grey", 24.99));
        products.add(new Clothing("T-Shirt", "Uniqlo", "100% cotton tee", 'M', "White", 19.00));
        products.add(new Clothing("Jacket", "The North Face", "Water-resistant jacket", 'L', "Navy", 89.99));

        //Books inventory
        products.add(new Book("1984", "Dystopian novel set in a totalitarian society", "George Orwell", "Secker & Warburg", 9.99));
        products.add(new Book("To Kill a Mockingbird", "Classic novel addressing racial injustice", "Harper Lee", "J.B. Lippincott & Co.", 7.99));
        products.add(new Book("The Great Gatsby", "Story of wealth and the American Dream", "F. Scott Fitzgerald", "Charles Scribner's Sons", 10.00));
        products.add(new Book("Harry Potter and the Sorcerer's Stone", "Young wizard's first year at Hogwarts", "J.K. Rowling", "Bloomsbury", 8.99));
        products.add(new Book("The Hobbit", "Fantasy adventure of Bilbo Baggins", "J.R.R. Tolkien", "George Allen & Unwin", 12.00));

        //Self-care inventory
        products.add(new Selfcare("Face Mask", "Hydrating sheet mask", "Generic", "Mask", 5.99));
        products.add(new Selfcare("Hand Sanitizer", "Alcohol-based gel", "Dettol", "Gel", 3.49));
        products.add(new Selfcare("Moisturizer", "Daily hydrating cream", "Nivea", "Cream", 12.99));
        products.add(new Selfcare("Lip Balm", "Protective lip balm", "Burt's Bees", "Balm", 2.99));
        products.add(new Selfcare("Body Lotion", "Nourishing lotion", "Aveeno", "Lotion", 8.99));

        //Accessory inventory
        products.add(new Accessory("Leather Handbag", "Bag", "Prada", "Spacious genuine leather handbag", 79.99));
        products.add(new Accessory("Silk Scarf",      "Scarf",   "Hermès", "Elegant silk fashion scarf",        39.99));
        products.add(new Accessory("Sunglasses",      "Eyewear", "Oakley", "UV-protective designer sunglasses",  99.99));
        products.add(new Accessory("Leather Belt",    "Belt",    "Gucci", "Classic leather belt with buckle",   29.99));
        products.add(new Accessory("Wristwatch",      "Watch",   "Rolex", "Luxury wristwatch with stainless steel band", 149.99));
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);           //set up input(user) and data


        //interface references
        Administrator administratorInterface = new ECommerceSystem(products);
        Customer customerInterface = new ECommerceSystem(products);

        //show menu in a loop
        boolean running = true;
        while (running) {
            System.out.println("\n--- ECommerce website access point ---");
            System.out.println("\n--- Select User interface: ---");
            System.out.println("1. Administrator");
            System.out.println("2. Customer");
            System.out.println("0. Exit");


            //user input accepted 1, 2 and 0
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    administratorInterface.displayAdministratorInterface();
                    break;
                case 2:
                    customerInterface.displayCustomerInterface();
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting system.");
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
            }
        }
    }
}
