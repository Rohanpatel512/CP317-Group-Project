public class Product {
    //private vars from Product Documentation
    private int SupplierID;
    private String ProductName;
    private int Quantity;
    private Double Price;
    private String Status;

    //constructor for connecting to ApplicationFrame Data
    public Product(int supplierID, String productName, int quantity, double price, string status) {
        this.SupplierID = supplierID;
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
        SupplierID = supplierID;
    }

    //ProductName getter & setter
    public int getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    //Quantity getter & setter
    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    //Price getter & setter
    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    //Status getter & setter
    public string getStatus() {
        return Status;
    }

    public void setStatus(string status) {
        Status = status;
    }
}
