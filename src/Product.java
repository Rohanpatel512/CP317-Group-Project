public class Product {
    //private vars from Product Documentation
    private int supplierID;
    private int productID;
    private String productName;
    private int quantity;
    private Double price;
    private String status;

    //constructor for connecting to ApplicationFrame Data
    public Product(int supplierID, int productID, String productName, int quantity, double price, String status) {
        this.supplierID = supplierID;
        this.productID = productID;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
    }

    //SupplierID getter & setter
    public int getSupplierID() {
        return this.supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    //ProductID getter & setter
    public int getProductID() {
        return this.productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    //ProductName getter & setter
    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    //Quantity getter & setter
    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //Price getter & setter
    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //Status getter & setter
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
