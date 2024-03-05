
/** COPYRIGHT (C) A.M.H.D.Kavindya - 20222164 - W1985735- hasanga.20222164@iit.ac.lk. All Rights Reserved.
 Coursework on Object-Oriented Programming, L5 Semester 1

 A.M.H.D. Kavindya, the author */


/**
 * The `Electronics` class represents a specific type of product related to electronic devices,
 * extending the functionality of the `Product` class.
 */
public class Electronics extends Product {
    // Instance variables representing specific attributes of electronics products.

    private String brand;
    // The brand of the electronics product.

    private double warrantyPeriod;
    // The warranty period (in years) for the electronics product.

    /**
     * Constructs an `Electronics` object with specified attributes.
     *
     * @param productId       The unique identifier for the electronics product.
     * @param productName     The name of the electronics product.
     * @param availableItems  The quantity of available items for the electronics product.
     * @param price           The price of the electronics product.
     * @param brand           The brand of the electronics product.
     * @param warrantyPeriod  The warranty period (in years) for the electronics product.
     */
    public Electronics(String productId, String productName, int availableItems, double price, String brand, Double warrantyPeriod) {

        super(productId, productName, availableItems, price);

        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }

    /**
     * Gets the brand of the electronics product.
     *
     * @return The brand of the electronics product.
     */
    public String getBrand() {

        return brand;
    }

    /**
     * Sets the brand of the electronics product.
     *
     * @param brand The new brand to be set.
     */
    public void setBrand(String brand) {

        this.brand = brand;
    }

    /**
     * Gets the warranty period of the electronics product.
     *
     * @return The warranty period (in years) of the electronics product.
     */
    public double getWarrantyPeriod() {

        return warrantyPeriod;
    }

    /**
     * Sets the warranty period of the electronics product.
     *
     * @param warrantyPeriod The new warranty period (in years) to be set.
     */
    public void setWarrantyPeriod(double warrantyPeriod) {

        this.warrantyPeriod = warrantyPeriod;
    }
}
