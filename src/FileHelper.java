import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class FileHelper {
  private Scanner scanner;

  public FileHelper() {
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
        productName = line[1];
        price = convertPrice(line[3]);
        quantity = Integer.parseInt(line[4].strip());
        status = line[5];
        supplierID = Integer.parseInt(line[6].strip());
        
        //Store info in a product variable and add it to products
        product = new Product(supplierID, productID, productName, quantity, price, status);

        products.add(product);
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  
    return products;
  }
}