
/** COPYRIGHT (C) A.M.H.D.Kavindya - 20222164 - W1985735- hasanga.20222164@iit.ac.lk. All Rights Reserved.
 Coursework on Object-Oriented Programming, L5 Semester 1

 A.M.H.D. Kavindya, the author */


import java.util.List;

/**
 * Interface representing a shopping manager for handling product details.
 */
interface ShoppingManager {

    /**
     * Adds product details to the shopping manager's inventory.
     *
     * @param product The product to be added.
     */
    void addProductDetails(Product product);

    /**
     * Removes product details from the shopping manager's inventory.
     *
     * @param product The product to be removed.
     */
    void removeProductDetails(Product product);

    /**
     * Retrieves a list of all product details in the shopping manager's inventory.
     *
     * @return A list of all product details.
     */
    List<Product> getAllProductsDetails();

    /**
     * Displays the shopping menu, providing options for managing products.
     */
    void displayShoppingMenu();
}
