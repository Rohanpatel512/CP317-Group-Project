import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class FileHelper implements ActionListener {
  private Scanner scanner;
  private ApplicationFrame frame;
  private JButton button;

  public FileHelper() {
    this.frame = new ApplicationFrame();
    this.button = this.frame.getCreateButton();
    this.button.addActionListener(this);
  }

  //private helper function to convert a formatted  
  //price string in the format $x.y to a double
  private double convertPrice(String price) {
    return Double.parseDouble(price.substring(2));
  }

  /*
   * Pre:
   *  - file : a string representing the file path to products.txt
   * Post:
   *  - Products : an array list of products storing all the products from 
   *    products.txt
   * Desc:
   *  Parses products.txt file given its file path and returns all of its
   *  products in an arraylist  
   */
  public ArrayList<Product> ReadProducts(String file) {
    //Initialize list of products
    ArrayList<Product> products = new ArrayList<Product>();
    
    try {
      //Set up the scanner object to parse the file
      File filename = new File(file);
      scanner = new Scanner(filename);
      
      //Initialize a product's attributes
      int productID;
      String productName;
      int quantity;
      Double price;
      String status;
      int supplierID;

      //Initalize product object to store temporary product's info
      Product product;
      //String to store each attribute from a line of information in products file
      String[] line;

      while (scanner.hasNextLine()) {
        //Split up the line by its commas
        line = scanner.nextLine().split(",");

        //Store all information in its respective variable
        productID = Integer.parseInt(line[0].strip());
        productName = line[1].strip();
        price = convertPrice(line[3]);
        quantity = Integer.parseInt(line[4].strip());
        status = line[5].strip();
        supplierID = Integer.parseInt(line[6].strip());
        
        //Store info in a product variable and add it to products
        product = new Product(supplierID, productID, productName, quantity, price, status);

        products.add(product);
      }

    } catch (FileNotFoundException e) {
      this.frame.displayErrorMessage(file);
    }
  
    return products;
  }

    /*
   * Pre:
   *  - file : a string representing the file path to suppliers.txt
   * Post:
   *  - Supplier : an array list of suppliers storing all the suppliers from products.txt
   * Desc:
   *  Parses suppliers.txt file given its file path and returns all of its
   *  suppliers in an arraylist  
   */
  public ArrayList<Supplier> ReadSuppliers(String file) {
        //Initialize list of products
        ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
    
        try {
          //Set up the scanner object to parse the file
          File filename = new File(file);
          scanner = new Scanner(filename);
          
          //Initialize a supplier's attributes
          int supplierID;
          String supplierName;
    
          //Initalize supplier object to store temporary supplier info
          Supplier supplier;
          //String to store each attribute from a line of information in suppliers file
          String[] line;
    
          while (scanner.hasNextLine()) {
            //Split up the line by its commas
            line = scanner.nextLine().split(",");
    
            //Store all information in its respective variable
            supplierID = Integer.parseInt(line[0].strip());
            supplierName = line[1].strip();
            
            //Store info in a Supplier variable and add it to suppliers
            supplier = new Supplier(supplierID, supplierName);
    
            suppliers.add(supplier);
          }
    
        } catch (FileNotFoundException e) {
          this.frame.displayErrorMessage(file);
        }

        return suppliers;
  }

  /*
   * pre:
   *  - prodcuts: array list of product objects
   *  - suppliers: array list of supplier object
   * post:
   *  N/A
   * desc:
   *  -  takes a list of products and suppliers and uses them to 
   *  write to a new inventory.txt file of inventory items
   */
  public void WriteInventory(ArrayList<Product> products, ArrayList<Supplier> suppliers) {
    //Initialize array list of inventory items by merging the product and supplier lists
    ArrayList<Inventory> inventory = merge(products, suppliers);

    try {
      //set up file writer to write to file
      File file = new File("src\\inventory.txt");
      FileWriter writer = new FileWriter(file);

      for (Inventory item : inventory) {
        //write all the information delimited by commas
        writer.write(item.getProductID() + ", " + item.getProductName()
         + ", " + item.getQuantity() + ", " +  "$" + item.getPrice()
          + ", " + item.getStatus() + ", " + item.getSupplierName() + "\n");
      }

      //close the fileWriter
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /*
   * pre:
   *  - products: array list of product items
   *  - suppliers: array list of supplier items
   * post:
   *  - inventory: array list of inventory items given the
   *  product and suppliier lists
   */
  private ArrayList<Inventory> merge(ArrayList<Product> products, ArrayList<Supplier> suppliers) {
    //Initialize inventory list
    ArrayList<Inventory> inventory = new ArrayList<Inventory>();

    //Create temporary inventoryItem
    Inventory inventoryItem;

    //Create temporary supplier and product items
    Supplier supplier;
    Product product;

    //Create inventory attributes
    int productID;
    String productName;
    int quantity;
    double price;
    String status;
    String supplierName;

    //loops through the list of products
    for (int i = 0; i < products.size(); i++) {
      //grab the product information
      product = products.get(i);
      productID = product.getProductID();
      productName = product.getProductName();
      quantity = product.getQuantity();
      price = product.getPrice();
      status = product.getStatus();

      //get the supplier name by the product's supplier ID
      supplier = getSupplierById(suppliers, product.getSupplierID());
      supplierName = supplier.getSupplierName();

      //Create the inventory item and add it to the list by product ID
      inventoryItem = new Inventory(productID, productName, quantity, price, status, supplierName);
      insertSorted(inventory, inventoryItem);
    }

    return inventory;
  }

  //Function to insert an inventory item into the inventory list sorted by its
  //product ID
  private void insertSorted(ArrayList<Inventory> inventory, Inventory item) {
    //If the list is empty, simply add the item
    if (inventory.size() == 0) {
      inventory.add(item);
    } else {
      //Loop through the list and insert the item once the current
      //item's product ID is less than or equal to the current one
      int i;
      for (i = 0; i < inventory.size(); i++) {
        if (item.getProductID() <= inventory.get(i).getProductID()) {
          inventory.add(i, item);
          break;
        }
      }

      //If the item's product ID is greater than all IDs 
      //currently in the list then it would parse through
      //the list and not add it. This check makes sure that
      //does not happen
      if (i == inventory.size()) {
        inventory.add(item);
      }
    }
  }


  //Function to return a supplier from a list of supplier given its ID
  private Supplier getSupplierById(ArrayList<Supplier> suppliers, int supplierID) {
    Supplier supplier = new Supplier(0, "");

    for (int i = 0; i < suppliers.size(); i++) {
      if (suppliers.get(i).getSupplierID() == supplierID) {
        supplier = new Supplier(suppliers.get(i).getSupplierID(), suppliers.get(i).getSupplierName());
        break;
      }
    }

    return supplier;
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    String supplierPath = this.frame.getSupplierPath();
    String productPath = this.frame.getProductPath();

    ArrayList<Product> products = this.ReadProducts(productPath);
    ArrayList<Supplier> suppliers = this.ReadSuppliers(supplierPath);

    if (products.size() > 0 && suppliers.size() > 0) {
      this.WriteInventory(products, suppliers);
    }
  }
}