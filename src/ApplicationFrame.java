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
        this.setSize(500, 500);
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
        this.productInput.setColumns(10);
        this.supplierInput.setColumns(10);
        
        // Sets the size and layout of center component panel
        centerPanel.setPreferredSize(new Dimension(250, 500));
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));

        // Helper method to place JLabels on top of text fields
        addLabels(centerPanel);

        // Add the textfields and button to center panel
        centerPanel.add(productInput);
        centerPanel.add(supplierInput);
        centerPanel.add(createButton);

        this.add(centerPanel, BorderLayout.PAGE_START);

    }

    /**
     * Helper method that adds labels on top of text fields
     * @params center panel (JPanel)
     */
    private void addLabels(JPanel centerPanel) {

        JLabel productLabel = new JLabel("Enter path to product data file");
        JLabel supplierLabel = new JLabel("Enter path to supplier data file");

        centerPanel.add(productLabel);
        centerPanel.add(supplierLabel);


    }


}
