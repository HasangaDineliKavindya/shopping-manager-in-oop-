
/** COPYRIGHT (C) A.M.H.D.Kavindya - 20222164 - W1985735- hasanga.20222164@iit.ac.lk. All Rights Reserved.
 Coursework on Object-Oriented Programming, L5 Semester 1

 A.M.H.D. Kavindya, the author */


import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * The `Gui` class represents the main frame for the shopping application.
 * This graphical user interface allows users to interact with the shopping center, view product details,
 * add products to the shopping cart, and manage the shopping cart.
 */
public class Gui extends JFrame implements ActionListener {


    // Declaration of GUI components

    private JButton myButton;
    // Button for adding products to the shopping cart

    private JComboBox<String> comboBox;
    // Dropdown for selecting product categories


    private JTable productTable;

    // Table displaying product information

    private DefaultTableModel tableModel;
    // Table model for productTable

    private Westminster_Shopping_Center shoppingManager;
    // Shopping manager instance

    private JLabel selectCategoryLabel;

    // Label indicating product category selection
    private JButton shoppingCartButton;

    // Button for opening the shopping cart

    private JTable shoppingCartTable;

    // Table displaying items in the shopping cart

    private JLabel selectProductsLabel;

    // Label indicating selected products
    private JLabel productIDLabel;

    // Label displaying product ID
    private JLabel categoryLabel;

    // Label displaying product category
    private JLabel nameLabel;

    // Label displaying product name
    private JLabel sizeLabel;

    // Label displaying product size
    private JLabel colorLabel;

    // Label displaying product color
    private JLabel ItemsAvailableLabel;

    // Label displaying available product items
    private JLabel brandLabel;

    // Label displaying product brand
    private JLabel WarrantyLabel;

    // Label displaying product warranty
    private JPanel shoppingCartPanel;

    // Panel displaying the shopping cart
    private JFrame shoppingCartFrame;
    // Frame for the shopping cart
    private JLabel totalLabel;
    // Label displaying total price in the shopping cart
    private JLabel discountTenLabel;
    // Label displaying 10% discount in the shopping cart
    private JLabel discountTwentyLabel;
    // Label displaying 20% discount in the shopping cart
    private JLabel finalTotalLabel;
    // Label displaying final total in the shopping cart



    /*
     Method to update the data in the table

     */
    private void updateTableData() {
        // Clear the existing rows in the table model
        tableModel.setRowCount(0);

        // Iterate through all products in the shopping manager
        for (Product product : shoppingManager.getAllProductsDetails()) {
            // Check if the selected item in the combo box is "All" or matches the type of the product
            if (comboBox.getSelectedItem().equals("All") ||
                    (comboBox.getSelectedItem().equals("Clothes") && product instanceof Clothing) ||
                    (comboBox.getSelectedItem().equals("Electronics") && product instanceof Electronics)) {

                // Create an array with the product details to be added to the table
                Object[] rowData = {
                        product.getProductId(),
                        product.getProductName(),
                        // Determine the product type and display it in the table
                        product instanceof Clothing ? "Clothing" : "Electronics",
                        product.getPrice(),
                        // Get additional information specific to the product
                        getProductInfo(product)
                };

                // Add the row data to the table model
                tableModel.addRow(rowData);
            }
        }
    }


    // Method to get additional information about a product
    private String getProductInfo(Product product) {
        // Check if the product is an instance of Electronics
        if (product instanceof Electronics) {
            // Construct and return information specific to Electronics products
            return "Brand: " + ((Electronics) product).getBrand() +
                    ", Warranty: " + ((Electronics) product).getWarrantyPeriod() + " years, " +
                    "Available Items: " + product.getAvailableItems();
        }
        // Check if the product is an instance of Clothing
        else if (product instanceof Clothing) {
            // Construct and return information specific to Clothing products
            return "Size: " + ((Clothing) product).getSize() +
                    ", Color: " + ((Clothing) product).getColor() + ", Available Items: " +
                    product.getAvailableItems();
        }
        // If the product is neither Electronics nor Clothing
        else {
            // Return a default message for other types of products
            return "N/A";
        }
    }

    // Method to create a Product object from a formatted string
    private Product getProductInfo(String info) {
        // Split the formatted string into tokens
        String[] tokens = info.split(", ");
        // Extract the type of product from the first token
        String type = tokens[0];

        // Check if the type contains information about Electronics
        if (type.contains("Brand")) {
            // Extract brand and warranty information from tokens
            String brand = tokens[0].substring(tokens[0].indexOf(":") + 1).trim();
            String warranty = tokens[1].substring(tokens[1].indexOf(":") + 1).trim();

            // Create and return an Electronics object with the extracted information
            return new Electronics("", "", 0, 0, brand, Double.parseDouble(warranty.split(" ")[0]));
        }
        // Check if the type contains information about Clothing
        else if (type.contains("Size")) {
            // Extract size and color information from tokens
            String size = tokens[0].substring(tokens[0].indexOf(":") + 1).trim();
            String color = tokens[1].substring(tokens[1].indexOf(":") + 1).trim();

            // Create and return a Clothing object with the extracted information
            return new Clothing("", "", 0, 0, size, color);
        }
        // If the type does not match Electronics or Clothing
        else {
            // Return null for unrecognized types
            return null;
        }
    }

    /**
     * Constructor for the `Gui` class, initializing the shopping manager and GUI components.
     * @param shoppingManager The Westminster_Shopping_Center instance managing the shopping center.
     */
    Gui(Westminster_Shopping_Center shoppingManager) {
        // Initialization of shopping manager and setting  dimensions

        this.shoppingManager = shoppingManager;
        this.setPreferredSize(new Dimension(500, 500));

        String[] items = {"All", "Clothes", "Electronics"};

        selectCategoryLabel = new JLabel("Select Product Category");

        shoppingCartPanel = new JPanel();
        shoppingCartPanel.setPreferredSize(new Dimension(500, 500));
        shoppingCartPanel.setVisible(false);

        productIDLabel = new JLabel("   Product ID :");

        // Label displaying product ID
        categoryLabel = new JLabel("   Category :");

        // Label displaying product category
        nameLabel = new JLabel("   Name :");
        // Label displaying product name
        sizeLabel = new JLabel("   Size :")
        ;  // Label displaying product size
        colorLabel = new JLabel("   Colour :");

        // Label displaying product color


        ItemsAvailableLabel = new JLabel();
        // Label displaying available product items

        brandLabel = new JLabel("   Brand :");
        // Label displaying product brand

        WarrantyLabel = new JLabel("   Warranty :");
        // Label displaying product warranty

        totalLabel = new JLabel("    Total -");
        // Label displaying total price

        discountTenLabel = new JLabel("    First Purchase Discount (10%) -");
        // Label displaying 10% discount

        discountTwentyLabel = new JLabel("    Three item in same Category (20%) -");
        // Label displaying 20% discount

        finalTotalLabel = new JLabel("   Final Total -");
        // Label displaying final total

        finalTotalLabel.setFont(new Font("Arial", Font.BOLD, 14));
        // Set font for finalTotalLabel

        comboBox = new JComboBox<>(items);
        // Dropdown for selecting product categories

        comboBox.addActionListener(this);

        myButton = new JButton("Add to Shopping Cart");
        // Button for adding products to the shopping cart

        myButton.setFocusable(false);
        myButton.addActionListener(this);

        selectProductsLabel = new JLabel("  Selected Products - Details");
        // Label indicating selected products
        // Set foreground (text) color
        selectProductsLabel.setForeground(Color.BLUE);

        // Set background color
        selectProductsLabel.setBackground(Color.YELLOW);

        // Enable the background to be visible
        selectProductsLabel.setOpaque(true);

        selectProductsLabel.setFont(new Font("Time New Romen ", Font.BOLD, 20));
        // Set font for selectProductsLabel

        shoppingCartButton = new JButton("Shopping Cart");
        // Button for opening the shopping cart

        shoppingCartButton.setFocusable(false);
        shoppingCartButton.addActionListener(this);

        tableModel = new DefaultTableModel();
        // Table model for productTable

        tableModel.addColumn("Product ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Category");
        tableModel.addColumn("Price \u00A3");
        tableModel.addColumn("Info");

        productTable = new JTable(tableModel);
        // Table displaying product information

        productTable.setRowHeight(30);

        updateTableData();
        highlightLowStockProducts();

        // ListSelectionListener to handle selection changes in the product table
        productTable.getSelectionModel().addListSelectionListener(e -> {

            int selectedRow = productTable.getSelectedRow();
            if (selectedRow != -1) {

                // Extracting information from the selected row
                Object category = tableModel.getValueAt(selectedRow, 2);
                Object productId = tableModel.getValueAt(selectedRow, 0);
                Object productName = tableModel.getValueAt(selectedRow, 1);
                Product product = getProductInfo(tableModel.getValueAt(selectedRow, 4).toString());

                // Updating labels the selected product
                productIDLabel.setText("   Product ID: " + productId.toString());
                nameLabel.setText("   Name: " + productName.toString());
                categoryLabel.setText("   Category: " + category.toString());

                // Adjusting visibility of labels based on the product category
                if (product instanceof Clothing) {

                    sizeLabel.setText("   Size :" + ((Clothing) product).getSize());
                    colorLabel.setText("   Color :" + ((Clothing) product).getColor());

                }
                else if (product instanceof Electronics) {

                    brandLabel.setText("   Brand :" + ((Electronics) product).getBrand());
                    WarrantyLabel.setText("   Warranty :" + ((Electronics) product).getWarrantyPeriod() + " years");
                }

                if (category.toString().equals("Clothing")) {

                    sizeLabel.setVisible(true);
                    colorLabel.setVisible(true);
                    ItemsAvailableLabel.setVisible(true);

                    brandLabel.setVisible(false);
                    WarrantyLabel.setVisible(false);
                }

                else if (category.toString().equals("Electronics")) {

                    brandLabel.setVisible(true);
                    WarrantyLabel.setVisible(true);

                    sizeLabel.setVisible(false);
                    colorLabel.setVisible(false);
                    ItemsAvailableLabel.setVisible(false);
                }
            }
        });

// MouseListener to handle mouse clicks on the product table
        productTable.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                // Check if it's a single click
                if (e.getClickCount() == 1) {

                    // Get the selected row
                    int selectedRow = productTable.getSelectedRow();

                    // Check if a row is selected
                    if (selectedRow != -1) {
                        // Extracting information from the selected row
                        Object productId = tableModel.getValueAt(selectedRow, 0);
                        Object productName = tableModel.getValueAt(selectedRow, 1);

                        // Updating labels with basic product information
                        productIDLabel.setText("   Product ID: " + productId.toString());
                        nameLabel.setText("   Name: " + productName.toString());
                    }
                }
            }
        });


       // Creating and configuring JScrollPane for the product table
        JScrollPane scrollPane = new JScrollPane(productTable);

       // Configuring frame properties
        this.setTitle("Westminster Shopping Center");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setResizable(true);

        this.getContentPane().setBackground(Color.blue);

        this.setLayout(new BorderLayout());

        // Creating and configuring north panel with category selection and shopping cart button
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        northPanel.add(selectCategoryLabel);

        northPanel.add(comboBox);

        northPanel.add(shoppingCartButton);

        this.add(northPanel, BorderLayout.NORTH);

        // Creating and configuring south panel with product information labels and action button
        JPanel southPanel = new JPanel(new BorderLayout());

        southPanel.add(selectProductsLabel, BorderLayout.NORTH);

       // Creating and configuring labels panel
        JPanel labelsPanel = new JPanel();

        labelsPanel.setLayout(new BoxLayout(labelsPanel, BoxLayout.Y_AXIS));

        labelsPanel.add(productIDLabel);
        labelsPanel.add(categoryLabel);
        labelsPanel.add(nameLabel);
        labelsPanel.add(sizeLabel);
        labelsPanel.add(colorLabel);
        labelsPanel.add(ItemsAvailableLabel);
        labelsPanel.add(brandLabel);
        labelsPanel.add(WarrantyLabel);

        southPanel.add(labelsPanel, BorderLayout.CENTER);

// Creating and configuring button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(myButton);
        southPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.add(southPanel, BorderLayout.SOUTH);
        this.add(scrollPane, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
    }

    private void highlightLowStockProducts() {

        productTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                int availableItemsColumnIndex = 4; // Assuming available items info is in the 5th column

                Object availableItemsInfo = table.getValueAt(row, availableItemsColumnIndex);
                String availableItemsString = availableItemsInfo.toString().replaceAll("\\D+", "");


                // Extracting only numbers
                int availableItems = 0;


                try {
                    availableItems = Integer.parseInt(availableItemsString);
                }
                catch (NumberFormatException e) {
                    // Handle the exception, you might want to set a default value or take appropriate action
                    System.err.println("Error parsing available items: " + e.getMessage());
                }

                if (availableItems < 3) {
                    cellComponent.setBackground(Color.RED);
                }
                else {
                    cellComponent.setBackground(table.getBackground());
                }
                return cellComponent;
            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        // Handling button clicks
        if (e.getSource() == myButton) {
            addToShoppingCart();
        }
        if (e.getSource() == shoppingCartButton) {
            openShoppingCartWindow();
        }

        if (e.getSource() == comboBox) {
            // Handle category selection from the dropdown
            String selectedCategory = (String) comboBox.getSelectedItem();
            if (!selectedCategory.equals("All") && !selectedCategory.equals("Clothes") &&
                    !selectedCategory.equals("Electronics")) {
                System.out.println(selectedCategory);
            }
            updateTableData();
        }
    }

    // Method to add selected product to the shopping cart
    private void addToShoppingCart() {
        // Initialize shopping cart if not already done
        if (shoppingCartTable == null) {
            initializeShoppingCart();
        }

        // Get selected row from the product table
        int selectedRow = productTable.getSelectedRow();

        // Check if a row is selected
        if (selectedRow != -1) {
            // Extract relevant information from the selected row
            Object productId = tableModel.getValueAt(selectedRow, 0);
            Object productName = tableModel.getValueAt(selectedRow, 1);
            Object price = tableModel.getValueAt(selectedRow, 3);

            // Get the shopping cart table model
            DefaultTableModel shoppingCartTableModel = (DefaultTableModel) shoppingCartTable.getModel();
            boolean itemAlreadyExists = false;

            // Check if the selected product is already in the shopping cart
            for (int i = 0; i < shoppingCartTableModel.getRowCount(); i++) {
                String cartProductId = shoppingCartTableModel.getValueAt(i, 0).toString().split(",")[0].replace("ID: ", "").trim();
                if (cartProductId.equals(productId.toString())) {

                    // If the product already exists in the cart, update the quantity and price
                    int currentQuantity = (int) shoppingCartTableModel.getValueAt(i, 1);
                    shoppingCartTableModel.setValueAt(currentQuantity + 1, i, 1);
                    double totalPrice = (currentQuantity + 1) * Double.parseDouble(price.toString());
                    shoppingCartTableModel.setValueAt(totalPrice, i, 2);
                    itemAlreadyExists = true;
                    break;
                }
            }

            // If the product is not in the cart, add it with quantity

            if (!itemAlreadyExists) {
                Object[] rowData = {"ID: " + productId.toString() + ", Name: " + productName.toString(), 1, price};
                shoppingCartTableModel.addRow(rowData);
            }

            // Update shopping cart details
            updateShoppingCartDetails();
        }
    }

    // Method to update shopping cart details (total, discounts)
    private void updateShoppingCartDetails() {

        DefaultTableModel shoppingCartTableModel = (DefaultTableModel) shoppingCartTable.getModel();

        double total = 0;
        int itemCount = shoppingCartTableModel.getRowCount();

        // Calculate total price

        for (int i = 0; i < itemCount; i++) {

            double price = (double) shoppingCartTableModel.getValueAt(i, 2);
            int quantity = (int) shoppingCartTableModel.getValueAt(i, 1);
            total += price * quantity;
        }

        // Calculate discounts and final total
        double discountTen = total * 0.1;

        double discountTwenty = total >= 3 ? total * 0.2 : 0;
        double finalTotal = total - discountTen - discountTwenty;
// Update labels displaying shopping cart details
        totalLabel.setText("    Total - " + String.format("%.2f", total) + " \u00A3");
// Set the totalLabel text with the formatted total amount

        discountTenLabel.setText("    First Purchase Discount (10%) - " + String.format("%.2f", discountTen) + " \u00A3");
// Set the discountTenLabel text with the formatted 10% discount amount

        discountTwentyLabel.setText("    Three items in the same Category Discount (20%) - " + String.format("%.2f", discountTwenty) + " \u00A3");
// Set the discountTwentyLabel text with the formatted 20% discount amount

        finalTotalLabel.setText("    Final Total - " + String.format("%.2f", finalTotal) + " \u00A3");
    }



    // Method to open the shopping cart
    private void openShoppingCartWindow() {
        // Initialize shopping cart  if not already done
        if (shoppingCartFrame == null) {
            initializeShoppingCart();
        }

        // Make the shopping cart window visible
        shoppingCartFrame.setVisible(true);
    }

    /**
     * Method to initialize the shopping cart window.
     * This method creates a separate window for displaying the contents of the shopping cart.
     */
    private void initializeShoppingCart() {
        // Create a new frame for the shopping cart
        shoppingCartFrame = new JFrame("Shopping Cart");
        shoppingCartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        shoppingCartFrame.setSize(500, 500);
        shoppingCartFrame.setLayout(new BorderLayout());

        // Create a panel for the shopping cart
        JPanel shoppingCartPanel = new JPanel();
        shoppingCartPanel.setLayout(new BorderLayout());

        // Create a table model for the shopping cart table
        DefaultTableModel shoppingCartTableModel = new DefaultTableModel();
        shoppingCartTableModel.addColumn("Product");
        shoppingCartTableModel.addColumn("Quantity");
        shoppingCartTableModel.addColumn("Price \u00A3");

        // Create a JTable with the shopping cart table model
        shoppingCartTable = new JTable(shoppingCartTableModel);
        JScrollPane shoppingCartScrollPane = new JScrollPane(shoppingCartTable);
        shoppingCartTable.setRowHeight(30);

        // Create a panel for labels displaying shopping cart details
        JPanel labelsPanel = new JPanel();
        labelsPanel.setLayout(new GridLayout(4, 1));

        labelsPanel.add(totalLabel);
        labelsPanel.add(discountTenLabel);
        labelsPanel.add(discountTwentyLabel);
        labelsPanel.add(finalTotalLabel);

        // Add components to the shopping cart panel
        shoppingCartPanel.add(shoppingCartScrollPane, BorderLayout.CENTER);
        shoppingCartPanel.add(labelsPanel, BorderLayout.SOUTH);

        // Add the shopping cart panel to the shopping cart frame
        shoppingCartFrame.add(shoppingCartPanel);


    }
}