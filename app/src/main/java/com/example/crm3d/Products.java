package com.example.crm3d;

public class Products {

    String Productname ;
    String ProductID;
    String Price ;
    String Quantity;

    public Products(String productname, String productID, String price, String quantity) {
        Productname = productname;
        ProductID = productID;
        Price = price;
        Quantity = quantity;
    }

    public String getProductname() {
        return Productname;
    }

    public String getProductID() {
        return ProductID;
    }

    public String getPrice() {
        return Price;
    }

    public String getQuantity() {
        return Quantity;
    }
}
