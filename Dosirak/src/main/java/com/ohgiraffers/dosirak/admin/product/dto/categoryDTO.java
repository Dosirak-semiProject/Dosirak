package com.ohgiraffers.dosirak.admin.product.dto;

public class categoryDTO {
    private int categoryCode;
    private String categoryName;
    private int refCategoryCode;

    private int subCategoryCode;
    private String subCategoryName;

    public categoryDTO() {
    }

    public categoryDTO(int categoryCode, String categoryName, int refCategoryCode, int subCategoryCode, String subCategoryName) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
        this.subCategoryCode = subCategoryCode;
        this.subCategoryName = subCategoryName;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getRefCategoryCode() {
        return refCategoryCode;
    }

    public void setRefCategoryCode(int refCategoryCode) {
        this.refCategoryCode = refCategoryCode;
    }

    public int getSubCategoryCode() {
        return subCategoryCode;
    }

    public void setSubCategoryCode(int subCategoryCode) {
        this.subCategoryCode = subCategoryCode;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    @Override
    public String toString() {
        return "categoryDTO{" +
                "categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                ", subCategoryCode=" + subCategoryCode +
                ", subCategoryName='" + subCategoryName + '\'' +
                '}';
    }
}
