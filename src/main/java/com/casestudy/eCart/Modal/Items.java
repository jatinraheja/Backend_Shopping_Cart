
package com.casestudy.eCart.Modal;

import com.casestudy.eCart.Modal.itemDetails;

import javax.naming.Name;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Items implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productid;

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public com.casestudy.eCart.Modal.itemDetails getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(com.casestudy.eCart.Modal.itemDetails itemDetails) {
        this.itemDetails = itemDetails;
    }

    private String name;
    private double price;
    private String details;
    private String image;
    private String category;
    private String subcategory;
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Column(nullable = false, columnDefinition = "int default '1'")
    private int active;
    @Embedded
    private com.casestudy.eCart.Modal.itemDetails itemDetails;

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    Items() {

    }
}
