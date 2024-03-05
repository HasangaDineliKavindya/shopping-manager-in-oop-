import java.util.ArrayList;
import java.util.List;

/**
 * Represents a shopping cart.
 * This class encapsulates a list of shopping cart items and provides methods to add items to the cart,
 * retrieve the list of items, and calculate the total price of all items in the cart.
 */

public class ShoppingCart {
    // List to store items

    private List<Shopping_Cart_item> items;

    /**
     * Constructor for an empty shopping cart.
     * Initializes the items list.
     */

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    /**
     * Add an item to the cart.
     *
     * @param item The shopping cart item to add.
     */

    public void addItem(Shopping_Cart_item item) {
        // Append item to the list

        this.items.add(item);
    }

    /**
     * Get the list of items in the shopping cart.
     *
     * @return The list of shopping cart items.
     */
    public List<Shopping_Cart_item> getItems() {
        // Return the list
        return items;
    }


    /**
     * Calculate and return the total price of all items in the shopping cart.
     *
     * @return The total price of all items.
     */

    public double getTotal() {
        // Initialize total price

        double total = 0.0;

        // Iterate through each item and sum prices
        for (Shopping_Cart_item item : items) {
            total += item.getPrice();
        }

        // Return the total price
        return total;
    }
}
