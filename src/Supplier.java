public class Supplier {
    // Private vars from Supplier Documentation
    private int supplierID;
    private String supplierName;
    private String address;
    private String phoneNumber;
    private String emailAddress;

    // Constructor to connect to ApplicationFrame Data
    public Supplier(int supplierID, String supplierName, String address, String phoneNumber, String emailAddress) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    // Getters
    public int getSupplierID() {
        return this.supplierID;
    }

    public String getSupplierName() {
        return this.supplierName;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    // Setters
    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}
