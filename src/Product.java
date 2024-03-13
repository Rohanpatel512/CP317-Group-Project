public class Product {
    //private vars from Product Documentation
    private int SupplierID;
    private int ProductID;
    private String ProductName;
    private int Quantity;
    private Double Price;
    private String Status;

    //constructor for connecting to ApplicationFrame Data
    public Product(int supplierID, int ProductID, String productName, int quantity, double price, string status) {
        this.SupplierID = supplierID;
        this.ProductID = productID;
        this.ProductName = productName;
        this.Quantity = quantity;
        this.Price = price;
        this.Status = status;
    }

    //SupplierID getter & setter
    public int getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(int supplierID) {
        this.SupplierID = supplierID;
    }

    //ProductID getter & setter
    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        this.ProductID = productID;
    }

    //ProductName getter & setter
    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        this.ProductName = productName;
    }

    //Quantity getter & setter
    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        this.Quantity = quantity;
    }

    //Price getter & setter
    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        this.Price = price;
    }

    //Status getter & setter
    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }
}
