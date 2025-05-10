package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Interfaces.Administrator;
import Interfaces.Customer;


public class MainMenu {
    
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);           //set up input(user) and data
        List<Product> products = new ArrayList<>();         //initialise empty list of products

        //interface-based references/methods
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