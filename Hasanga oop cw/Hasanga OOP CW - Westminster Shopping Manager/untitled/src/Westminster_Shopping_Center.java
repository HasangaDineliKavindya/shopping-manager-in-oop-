
/**
 * COPYRIGHT (C) A.M.H.D.Kavindya - 20222164 - W1985735- hasanga.20222164@iit.ac.lk. All Rights Reserved.
 * Coursework on Object-Oriented Programming, L5 Semester 1
 *
 * A.M.H.D. Kavindya, the author
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Westminster_Shopping_Center class implementing ShoppingManager interface
public class Westminster_Shopping_Center implements ShoppingManager {

    // Constants for maximum products and file name
    private static final int MAX_PRODUCTS = 50;
    private static final String FILE_NAME = "products.txt";

    // List to store products, scanner for user input, and shopping cart instance
    protected List<Product> productList;
    private final Scanner scanner;

    private ShoppingCart shoppingCart;

    // Constructor for WestminsterShoppingManager
    public Westminster_Shopping_Center() {
        // Initialize lists and objects, and load products from file
        this.productList = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.shoppingCart = new ShoppingCart();
        loadProductsFromFile();
    }

    // Getter method for shopping cart
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    // Implementation of ShoppingManager interface method to add product details
    @Override
    public void addProductDetails(Product product) {
        // Check if the maximum number of products has been reached
        if (productList.size() < MAX_PRODUCTS) {
            // Add the product and display success message
            productList.add(product);
            System.out.println("This item was successfully added...!!! " + product.getProductName());
        } else {
            // Display message if the maximum limit is reached
            System.out.println("You cannot add more products. The maximum limit reached...");
        }
    }

    // Implementation of ShoppingManager interface method to remove product details
    @Override
    public void removeProductDetails(Product product) {
        // Attempt to remove the product from the list
        if (productList.remove(product)) {
            // Display success message and the remaining number of products
            System.out.println("Removed was this product: " + product.getProductName());
            System.out.println("The total amount of items still available: " + productList.size());
        } else {
            // Display message if the product is not found
            System.out.println("This item is not available: " + product.getProductName());
        }
    }

    // Implementation of ShoppingManager interface method to get all products' details
    @Override
    public List<Product> getAllProductsDetails() {
        return new ArrayList<>(productList);
    }

    // Private method to display the GUI for shopping
    private void displayGUI() {
        new Gui(this);
    }

    // Implementation of ShoppingManager interface method to display the shopping menu
    @Override
    public void displayShoppingMenu() {
        // Variable to store user's menu choice
        int choice;

        // Main menu loop
        do {
            // Display menu options
            System.out.println("-----Westminster Shopping Center-----");
            System.out.println("1. Add a new product to the system");
            System.out.println("2. Delete a product from the system");
            System.out.println("3. Print the list of the products in the system ");
            System.out.println("4. Save the file");
            System.out.println("5. Open the GUI ");
            System.out.println("0. Exit");

            // Prompt user for choice
            System.out.print("Please choose your option.: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            // Switch statement to handle user's choice
            switch (choice) {
                case 1:
                    addProductDetails();
                    break;
                case 2:
                    removeProductDetails();
                    break;
                case 3:
                    showProductList();
                    break;
                case 4:
                    saveProductsToFile();
                    break;
                case 5:
                    displayGUI();
                    break;
                case 0:
                    saveProductsToFile();
                    System.out.println("You are Exit !!!");
                    break;
                default:
                    System.out.println("You entered an invalid input. Could you please try again???");
                    break;
            }
        } while (choice != 0);

        // Close the scanner
        scanner.close();
    }

    // Private method to add product details
    private void addProductDetails() {
        // Variable to check if the entered product type is valid
        boolean validProductType = false;

        // Loop to prompt for product details until a valid product type is entered
        do {
            try {
                // Prompt user for product type
                System.out.println(" Enter the product type [Clothing/Electronics] : ");
                String productType = scanner.next();

                // Check if the entered product type is valid
                if (productType.equalsIgnoreCase("clothing") || productType.equalsIgnoreCase("electronics")) {
                    validProductType = true;
                    // Prompt for common product details
                    System.out.println(" Enter the product id: ");
                    String productID = scanner.next();
                    System.out.println("Enter the product name: ");
                    String name = scanner.next();

                    // Prompt for available items (handling input mismatch)
                    int availableItem;
                    while (true) {
                        try {
                            System.out.println("Enter the available items: ");
                            availableItem = scanner.nextInt();
                            break;
                        } catch (java.util.InputMismatchException e) {
                            System.err.println("You entered an invalid input. Enter a valid integer for available items.");
                            scanner.nextLine(); // Clear the buffer
                        }
                    }

                    // Prompt for price (handling input mismatch)
                    double price;
                    while (true) {
                        try {
                            System.out.println(" Enter price: ");
                            price = scanner.nextDouble();
                            break;
                        } catch (java.util.InputMismatchException e) {
                            System.err.println("You entered an invalid input.Enter a valid price.");
                            scanner.nextLine(); // Clear the buffer
                        }
                    }

                    // Handle product type-specific details
                    if (productType.equalsIgnoreCase("clothing")) {
                        String[] validSizes = {"xs", "s", "m", "l", "xl", "xxl"};
                        String size;
                        // Prompt for size until a valid size is entered
                        while (true) {
                            System.out.println("Enter your size (xs,s,m,l,xl,xxl): ");
                            size = scanner.next().toLowerCase();
                            if (java.util.Arrays.asList(validSizes).contains(size)) {
                                break;
                            } else {
                                System.err.println("Enter a valid size.");
                            }
                        }

                        String color = "";
                        boolean validColor = false;
                        // Prompt for color until a valid color is entered
                        while (!validColor) {
                            try {
                                System.out.println("Enter the color: ");
                                String input = scanner.next();
                                if (input.matches("^[a-zA-Z]*$")) {
                                    color = input;
                                    validColor = true;
                                } else {
                                    System.err.println("You entered an invalid input. Enter a valid color you needed.");
                                }
                            } catch (java.util.InputMismatchException e) {
                                System.err.println("You entered an invalid input.Enter a valid color you needed.");
                                scanner.nextLine(); // Clear the buffer
                            }
                        }

                        // Create and add Clothing product to the list
                        Product product = new Clothing(productID, name, availableItem, price, size, color);
                        addProductDetails(product);
                    } else if (productType.equalsIgnoreCase("electronics")) {
                        System.out.println("Please enter the brand here : ");
                        String brand = scanner.next();

                        Double time;
                        // Prompt for warranty period (handling input mismatch)
                        while (true) {
                            try {
                                System.out.println("Please enter the warranty period [Years]: ");
                                time = scanner.nextDouble();
                                break;
                            } catch (java.util.InputMismatchException e) {
                                System.err.println("You entered an invalid input for the warranty period.");
                                scanner.nextLine(); // Clear the buffer
                            }
                        }

                        // Create and add Electronics product to the list
                        Product product = new Electronics(productID, name, availableItem, price, brand, time);
                        addProductDetails(product);
                    }
                } else {
                    // Display error message for invalid product type
                    System.err.println("You entered an invalid input for product type!");
                }
            } catch (java.util.InputMismatchException e) {
                // Display error message for invalid data type input
                System.err.println("You entered an invalid input. Enter the correct data type.");
                scanner.nextLine(); // Clear the buffer
            }
        } while (!validProductType);
    }

    // Private method to remove product details
    private void removeProductDetails() {
        try {
            // Prompt user for the product ID to delete
            System.out.println("Please Enter the product ID to delete product: ");
            String productIdToDelete = scanner.next();
            Product productToDelete = findProductById(productIdToDelete);

            // Check if the product is found and remove it
            if (productToDelete != null) {
                removeProductDetails(productToDelete);
            } else {
                // Display message if the product is not found
                System.out.println("No product found with ID: " + productIdToDelete);
            }
        } catch (java.util.InputMismatchException e) {
            // Display error message for invalid data type input
            System.err.println("You entered an invalid input. Please enter the correct data type.");
            scanner.nextLine(); // Clear the buffer
        }
    }

    // Private method to display the product list
    private void showProductList() {
        System.out.println("List of Products:");

        try {
            // Display details for each product in the list
            for (Product product : getAllProductsDetails()) {
                System.out.println("ID: " + product.getProductId() +
                        ", Name: " + product.getProductName() +
                        ", Available Items: " + product.getAvailableItems() +
                        ", Price: " + product.getPrice());
            }
        } catch (Exception e) {
            // Display error message for any exceptions during processing
            System.err.println("An error occurred when the product list was being processed.\n" + e.getMessage());
        }
    }

    // Private method to save products to a file
    private void saveProductsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            // Write the list of products to the file
            oos.writeObject(productList);
            System.out.println("successfully saved to file!!!!.");
        } catch (IOException e) {
            // Display error message for any exceptions during saving
            System.out.println("An error occurred when the product list was being processed.\n: " + e.getMessage());
        }
    }

    // Private method to load products from a file
    private void loadProductsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            // Read the list of products from the file
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                productList = (List<Product>) obj;
                System.out.println(" successfully loaded from file.");
            }
        } catch (IOException | ClassNotFoundException e) {
            // Display error message for any exceptions during loading
            System.out.println("An error occurred when the product list was being processed.\n" + e.getMessage());
        }
    }

    // Private method to find a product by its ID in the list
    private Product findProductById(String productId) {
        for (Product product : getAllProductsDetails()) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }
}
