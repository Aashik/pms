package com.niftylife.stockapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productCode;
    private String productName;
    private String Category;
    private String description;
    private String image;
    private int colors;
    private BigDecimal costPrice;
    private BigDecimal extraExpenses;

    public Product() {
    }

    public Product(String productCode, String productName, String category, String description, String image, int colors, BigDecimal costPrice, BigDecimal extraExpenses) {
        this.productCode = productCode;
        this.productName = productName;
        Category = category;
        this.description = description;
        this.image = image;
        this.colors = colors;
        this.costPrice = costPrice;
        this.extraExpenses = extraExpenses;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getColors() {
        return colors;
    }

    public void setColors(int colors) {
        this.colors = colors;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getExtraExpenses() {
        return extraExpenses;
    }

    public void setExtraExpenses(BigDecimal extraExpenses) {
        this.extraExpenses = extraExpenses;
    }
}