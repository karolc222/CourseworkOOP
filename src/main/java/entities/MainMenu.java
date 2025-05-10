package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Interfaces.Administrator;
import Interfaces.Customer;


public class MainMenu {

    private static List<Product> products = new ArrayList<>();

    static {
        seedInventory();
    }

    public static void seedInventory() {
        products.clear();
        products.add(new Electronics(1, "MacBook Pro", "Laptop", "Apple", 12, 1799));
        products.add(new Electronics(2, "Dell Monitor", "4k Ultra HD Monitor", "Dell", 18, 299));
        products.add(new Electronics(3, "LT Mouse", "Wireless and Ergonomic build", "Logitech ", 12, 39));
        products.add(new Electronics(4, "LT Mechanical Keyboard", "RGB and wireless", "Logitech", 12, 49));
        products.add(new Electronics(5, "JBL Bluetooth Speaker", "Wonderboom X portable waterproof speaker", "JBL", 24, 79));
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);           //set up input(user) and data


        //interface-based references/methods1

        Administrator administratorInterface =  new ECommerceSystem(products);
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