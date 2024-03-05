
/** COPYRIGHT (C) A.M.H.D.Kavindya - 20222164 - W1985735- hasanga.20222164@iit.ac.lk. All Rights Reserved.
 Coursework on Object-Oriented Programming, L5 Semester 1.

 A.M.H.D. Kavindya, the author */



/**
 * The `Clothing` class represents a specific type of product related to apparel,
 * extending the functionality of the `Product` class.
 */
public class Clothing extends Product {
    // Instance variables representing specific attributes of clothing products.

    private String size;
    // The size of the clothing item.

    private String color;
    // The color of the clothing item.

    /**
     * Constructs a `Clothing` object with specified attributes.
     *
     * @param productId      The unique identifier for the clothing product.
     * @param productName    The name of the clothing product.
     * @param availableItems The quantity of available items for the clothing product.
     * @param price          The price of the clothing product.
     * @param size           The size attribute of the clothing item.
     * @param color          The color attribute of the clothing item.
     */
    public Clothing(String productId, String productName, int availableItems, double price, String size, String color) {

        super(productId, productName, availableItems, price);
        // Call superclass constructor.

        this.size = size;
        // Set the size attribute.

        this.color = color;
        // Set the color attribute.
    }

    /**
     * Gets the size of the clothing item.
     *
     * @return The size of the clothing item.
     */
    public String getSize() {

        return size;
    }

    /**
     * Sets the size of the clothing item.
     *
     * @param size The new size to be set.
     */
    public void setSize(String size) {

        this.size = size;
    }

    /**
     * Gets the color of the clothing item.
     *
     * @return The color of the clothing item.
     */
    public String getColor() {

        return color;
    }

    /**
     * Sets the color of the clothing item.
     *
     * @param color The new color to be set.
     */
    public void setColor(String color) {

        this.color = color;
    }
}
