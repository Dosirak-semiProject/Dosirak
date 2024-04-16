package com.ohgiraffers.dosirak.admin.product.dto;

public class productDTO {
    private String productName;
    private String productCode;
    private int productPrice;
    private String productStatus;
    private String productSummary;
    private int productCategoryCode;
    private int subcategory;

    public productDTO() {
    }

    public productDTO(String productName, String productCode, int productPrice, String productStatus, String productSummary, int productCategoryCode, int subcategory, String description) {
        this.productName = productName;
        this.productCode = productCode;
        this.productPrice = productPrice;
        this.productStatus = productStatus;
        this.productSummary = productSummary;
        this.productCategoryCode = productCategoryCode;
        this.subcategory = subcategory;

    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductSummary() {
        return productSummary;
    }

    public void setProductSummary(String productSummary) {
        this.productSummary = productSummary;
    }

    public int getProductCategoryCode() {
        return productCategoryCode;
    }

    public void setProductCategoryCode(int productCategoryCode) {
        this.productCategoryCode = productCategoryCode;
    }

    public int getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(int subcategory) {
        this.subcategory = subcategory;
    }


    @Override
    public String toString() {
        return "productDTO{" +
                "productName='" + productName + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productPrice=" + productPrice +
                ", productStatus='" + productStatus + '\'' +
                ", productSummary='" + productSummary + '\'' +
                ", productCategoryCode=" + productCategoryCode +
                ", subcategory=" + subcategory + '\'' +
                '}';
    }
}
