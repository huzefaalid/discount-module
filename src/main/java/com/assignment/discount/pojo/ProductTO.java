package com.assignment.discount.pojo;

import java.math.BigDecimal;

public class ProductTO {
    private String productName;
    private ProductType productType;
    private BigDecimal sellingPrice;

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public ProductType getProductType() {
        return productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
}
