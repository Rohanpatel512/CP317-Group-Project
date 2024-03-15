import javax.swing.*;
import java.awt.*;

public class ApplicationFrame extends JFrame {

    // Fields
    private JTextField productInput = new JTextField();
    private JTextField supplierInput = new JTextField();
    private JButton createButton = new JButton("Create");

    /**
     * Constructs the application GUI interface
     * @params none
     * @return none
     */
    public ApplicationFrame() {
        this.setTitle("Data Format Application");
        this.setSize(500, 200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());
        this.addComponents();
        this.setVisible(true);
    }

    /**
     * Adds all UI widgets onto JFrame.
     * @params none
     * @return none
     */
    private void addComponents() {

        // Local variables
        JPanel centerPanel = new JPanel();

        // Set the size of textfields
        this.productInput.setColumns(50);
        this.supplierInput.setColumns(50);
        
        // Sets the size and layout of center component panel
        centerPanel.setPreferredSize(new Dimension(100, 500));
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Set the size of JTextFields
        productInput.setMaximumSize(productInput.getPreferredSize());
        supplierInput.setMaximumSize(productInput.getPreferredSize());

        // Helper method to place JLabels on top of text fields
        addProductLabel(centerPanel);

        // Add the textfields and button to center panel
        centerPanel.add(productInput);
        addSupplierLabel(centerPanel);
        centerPanel.add(supplierInput);
        centerPanel.add(createButton);

        this.add(centerPanel);

    }

    /**
     * Displays error if either supplier path or product path are invalid
     * @param filePath - The path of file that wasn't found
     */
    public void displayErrorMessage(String filename) {
        JOptionPane.showMessageDialog(this, "Cannot find file " + filename, "Invalid path error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Helper method that adds product label on top of corresponding text field
     * @params center panel (JPanel)
     */
    private void addProductLabel(JPanel centerPanel) {

        JLabel productLabel = new JLabel("Enter path to product data file");
        centerPanel.add(productLabel);

    }

    /**
     * Helper method that adds supplier label on top of corresponding text field
     * @params center panel (JPanel)
     */
    private void addSupplierLabel(JPanel centerPanel) {
        
        JLabel supplierLabel = new JLabel("Enter path to supplier data file");
        centerPanel.add(supplierLabel);
    }

    /**
     * Gets the input from product textfield
     * @returns productPath - The path to the product data file 
     */
    public String getProductPath() {
        String productPath = productInput.getText();
        return productPath;
    }

    /**
     * Gets the input from supplier textfield
     * @returns supplierPath - The path to the supplier data file
     */
    public String getSupplierPath() {
        String supplierPath = supplierInput.getText();
        return supplierPath;
    }

    /**
     * Gets the button from GUI 
     * @return createButton - The GUI button user clicks on
     */
    public JButton getCreateButton() {
        return this.createButton;
    }

    
}
