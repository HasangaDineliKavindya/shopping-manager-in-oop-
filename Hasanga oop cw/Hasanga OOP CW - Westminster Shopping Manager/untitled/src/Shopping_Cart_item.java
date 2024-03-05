/**
 * COPYRIGHT (C) A.M.H.D.Kavindya - 20222164 - W1985735- hasanga.20222164@iit.ac.lk. All Rights Reserved.
 * Coursework on Object-Oriented Programming, L5 Semester 1
 * A.M.H.D. Kavindya, the author
 *
 * Represents an item in the shopping cart.
 * This class encapsulates the details of a product within the shopping cart, including its unique identifier,
 * name, category, and price.
 */
public class Shopping_Cart_item {
    // Unique identifier for the product
    private String productId;

    // Name of the product
    private String productName;

    // Category of the product
    private String category;

    // Price of the product
    private double price;

    /**
     * Constructor to initialize a cart item with provided details.
     *
     * @param productId   The unique identifier for the product.
     * @param productName The name of the product.
     * @param category    The category of the product.
     * @param price       The price of the product.
     */
    public Shopping_Cart_item(String productId, String productName, String category, double price) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
    }

    // Getter and setter methods for product attributes

    /**
     * Get the product ID.
     *
     * @return The product ID.
     */
    public String getProductId() {
        return productId;
    }

    /**
     * Set the product ID.
     *
     * @param productId The product ID to set.
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * Get the product name.
     *
     * @return The product name.
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Set the product name.
     *
     * @param productName The product name to set.
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Get the product category.
     *
     * @return The product category.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Set the product category.
     *
     * @param category The product category to set.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Set the product price.
     *
     * @param price The product price to set.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Get the quantity of the product (always 1 for simplicity).
     *
     * @return The quantity of the product.
     */
    public int getQuantity() {
        return 1;
    }

    /**
     * Get the price of the product.
     *
     * @return The price of the product.
     */
    public double getPrice() {
        return price;
    }
}
