package entities;

import java.util.Scanner;

public abstract class Product {
    protected int productId;
    protected String productName;
    protected String productDescription;
    protected String productCategory;
    protected double productPrice;
    
    
    //abstract method to be implemented by subclasses 
    public abstract String displayDetails();
    
    //getters 
    public int getProductId() {return productId;}
    public String getProductName() {return productName;}
    public String getProductCategory() {return productCategory;}
    public String getProductDescription() {return productDescription;}
    public double getProductPrice() {return productPrice;} 


    //setters
    public void setProductDescription(String productDescription) {this.productDescription = productDescription; }
    public void setProductPrice(double ProductPrice) {this.productPrice = productPrice;} 
    
    //method for creating new Product
    protected void displayCreateProductMenu(Scanner scanner) {
         
       System.out.println("Enter product name: ");
       this.productName = scanner.nextLine();
       System.out.println("You chose: " + this.productName);
       
       System.out.println("Enter product description: ");
       this.productDescription = scanner.nextLine();
       System.out.println("You chose: " + this.productDescription);
       
       System.out.println("Enter product price: ");
       this.productPrice = scanner.nextDouble();
       System.out.println("You set the price at: " + this.productPrice);

       System.out.println("Enter product category: ");
       this.productCategory = scanner.nextLine();
       System.out.println("You set the category: " + this.productCategory);
        
     }

    //method for editing product information
    protected void displayEditProductMenu(Scanner scanner) {

        System.out.println("Edit product name: " + this.getProductName());
        String productName1 = scanner.nextLine();
        if (!productName1.isEmpty()) {
            this.productName = productName1;
            System.out.println("You chose: " + this.productName);

        }
//
        System.out.println("Edit product description: ");
        this.productDescription = scanner.nextLine();
        System.out.println("You chose: " + this.productName);

        System.out.println("Edit product price: ");
        this.productPrice = scanner.nextDouble();
        System.out.println("You set the price at: " + this.productPrice);

    }
       protected abstract void displayCategoryMenu(Scanner scanner);

    
    //menu for adding new products
    public static Product displayProductMenu(Scanner scanner) {
        
        Product product = null;
        
        boolean productMenuRunning  = true;
         while (productMenuRunning)  {
            System.out.println("\n--- Choose product category---");
            System.out.println("1. Electronics");
            System.out.println("2. Books" );
            System.out.println("3. Clothing");
            System.out.println("4. Self-care");
            System.out.println("5. Events");
            System.out.println("6. Back to Main Menu");
            System.out.println("Choose option");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {   
                case 1:
                System.out.println("Creating a new Product");
                product = new Product() {

                    }

                    @Override
                    protected void displayCategoryMenu(Scanner scanner) {

                    }
                };
                product.displayCategoryMenu(scanner);

                    break;
                    
                case 2: 
                    System.out.print("Choose product to edit by Id");
                    break;

                case 3: 
                    System.out.print("Choose product to remove by Id");
                    String removeProductId = scanner.nextLine();
                    //removeProduct(removeProductId);
                    break;

                case 4:
                    System.out.print("Choose category");
                    break;

                case 5:
                    System.out.print("Generate sales report");
                    break;

                case 6:
                    System.out.print("Back to main menu");
                    productMenuRunning = false;
                    break;
                default: 
                    System.out.println("Unrecognised input, choose again.");
                                  
            }
            
         }      
                return product;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
    
           
    
    

