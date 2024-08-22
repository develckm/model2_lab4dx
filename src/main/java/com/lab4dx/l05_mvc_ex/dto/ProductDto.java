package com.lab4dx.l05_mvc_ex.dto;

public class ProductDto {
    /*PRODUCT
    PRODUCT_ID NUMBER
    PRODUCT_NAME VARCHAR2(100)
    PRODUCT_PRICE NUMBER*/
    private int productId;
    private String productName;
    private int productPrice;

    @Override
    public String toString() {
        return "{" +
                "\"productId\":" + productId +
                ",\"productName\":\"" + productName + "\"" +
                ",\"productPrice\":" + productPrice +
                '}';
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
}
