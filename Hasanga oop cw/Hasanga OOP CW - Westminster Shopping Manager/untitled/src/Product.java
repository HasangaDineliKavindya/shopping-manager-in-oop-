import java.io.Serializable;

/**
 * COPYRIGHT (C) A.M.H.D.Kavindya - 20222164 - W1985735- hasanga.20222164@iit.ac.lk. All Rights Reserved.
 * Coursework on Object-Oriented Programming, L5 Semester 1
 * A.M.H.D. Kavindya, the author
 *
 * Base class for all products.
 * This abstract class defines common attributes and methods for products in the shopping application.
 */
public abstract class Product implements Serializable {
    // Product attributes

    private String productId;

    // Unique identifier for the product
    private String productName;

    // Name of the product
    private int availableItems;

    // Number of available items in stock
    private double price;

    // Price of the product

    /**
     * Constructor to initialize product attributes.
     *
     * @param productId       The unique identifier for the product.
     * @param productName     The name of the product.
     * @param availableItems  The number of available items in stock.
     * @param price           The price of the product.
     */
    protected Product(String productId, String productName, int availableItems, double price) {
        this.productId = productId;
        this.productName = productName;
        this.availableItems = availableItems;
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
     * Get the number of available items.
     *
     * @return The number of available items.
     */
    public int getAvailableItems() {
        return availableItems;
    }

    /**
     * Set the number of available items.
     *
     * @param availableItems The number of available items to set.
     */
    public void setAvailableItems(int availableItems) {
        this.availableItems = availableItems;
    }

    /**
     * Get the price of the product.
     *
     * @return The price of the product.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set the price of the product.
     *
     * @param price The price to set.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Override toString method to provide a string representation of the product.
     *
     * @return A string representation of the product.
     */
    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", availableItems=" + availableItems +
                ", price=" + price +
                '}';
    }
}
