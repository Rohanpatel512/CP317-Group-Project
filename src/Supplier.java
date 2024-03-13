public class Supplier {
  //Attributes
  private int supplierID;
  private String supplierName;

  //Constructor
  public Supplier(int supplierID, String supplierName) {
    this.supplierID = supplierID;
    this.supplierName = supplierName;
  }

  //Getters and setters 

  public int getSupplierID() {
    return this.supplierID;
  }

  public void setSupplierID(int supplierID) {
    this.supplierID = supplierID;
  }

  public String getSupplierName() {
    return this.supplierName;
  }

  public void setSupplierName(String supplierName) {
    this.supplierName = supplierName;
  }
}
