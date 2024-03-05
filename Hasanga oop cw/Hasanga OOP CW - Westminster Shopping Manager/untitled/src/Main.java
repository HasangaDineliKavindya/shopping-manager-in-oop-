
/** COPYRIGHT (C) A.M.H.D.Kavindya - 20222164 - W1985735- hasanga.20222164@iit.ac.lk. All Rights Reserved.
 Coursework on Object-Oriented Programming, L5 Semester 1

 A.M.H.D. Kavindya, the author */


/**
 * Main class to initiate and run the Westminster Shopping Manager program.
 * This program demonstrates the functionality of the Westminster_Shopping_Center class
 * implementing the ShoppingManager interface.
 */
public class Main {

    /**
     * Main method, the entry point of the program.
     * It creates an instance of Westminster_Shopping_Center and invokes the method to
     * display the shopping menu and manage the shopping process.
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Creating an instance of Westminster_Shopping_Center, which implements the ShoppingManager interface
        ShoppingManager shoppingManager = new Westminster_Shopping_Center();

        // Invoking the method to display the shopping menu and manage the shopping process
        shoppingManager.displayShoppingMenu();
    }
}
