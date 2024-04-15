package com.ohgiraffers.dosirak.admin.suitBox.model.dto;

public class SuitBoxMenuDTO {
    private int menuCode;
    private String menuName;
    private String menuCategory;
    private int menuExtracash;
    private char menuStatus;
    private float menuCarbo;
    private float menuSugar;
    private float menuProtein;
    private float menuFat;
    private float menuSaturatedFat;
    private float menuTransFat;
    private float menuCholesterol;
    private float menuNatrium;
    private int menuCalory;

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuCategory() {
        return menuCategory;
    }

    public void setMenuCategory(String menuCategory) {
        this.menuCategory = menuCategory;
    }

    public int getMenuExtracash() {
        return menuExtracash;
    }

    public void setMenuExtracash(int menuExtracash) {
        this.menuExtracash = menuExtracash;
    }

    public char getMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(char menuStatus) {
        this.menuStatus = menuStatus;
    }

    public float getMenuCarbo() {
        return menuCarbo;
    }

    public void setMenuCarbo(float menuCarbo) {
        this.menuCarbo = menuCarbo;
    }

    public float getMenuSugar() {
        return menuSugar;
    }

    public void setMenuSugar(float menuSugar) {
        this.menuSugar = menuSugar;
    }

    public float getMenuProtein() {
        return menuProtein;
    }

    public void setMenuProtein(float menuProtein) {
        this.menuProtein = menuProtein;
    }

    public float getMenuFat() {
        return menuFat;
    }

    public void setMenuFat(float menuFat) {
        this.menuFat = menuFat;
    }

    public float getMenuSaturatedFat() {
        return menuSaturatedFat;
    }

    public void setMenuSaturatedFat(float menuSaturatedFat) {
        this.menuSaturatedFat = menuSaturatedFat;
    }

    public float getMenuTransFat() {
        return menuTransFat;
    }

    public void setMenuTransFat(float menuTransFat) {
        this.menuTransFat = menuTransFat;
    }

    public float getMenuCholesterol() {
        return menuCholesterol;
    }

    public void setMenuCholesterol(float menuCholesterol) {
        this.menuCholesterol = menuCholesterol;
    }

    public float getMenuNatrium() {
        return menuNatrium;
    }

    public void setMenuNatrium(float menuNatrium) {
        this.menuNatrium = menuNatrium;
    }

    public int getMenuCalory() {
        return menuCalory;
    }

    public void setMenuCalory(int menuCalory) {
        this.menuCalory = menuCalory;
    }

    @Override
    public String toString() {
        return "SuitBoxMenuDTO{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuCategory='" + menuCategory + '\'' +
                ", menuExtracash=" + menuExtracash +
                ", menuStatus=" + menuStatus +
                ", menuCarbo=" + menuCarbo +
                ", menuSugar=" + menuSugar +
                ", menuProtein=" + menuProtein +
                ", menuFat=" + menuFat +
                ", menuSaturatedFat=" + menuSaturatedFat +
                ", menuTransFat=" + menuTransFat +
                ", menuCholesterol=" + menuCholesterol +
                ", menuNatrium=" + menuNatrium +
                ", menuCalory=" + menuCalory +
                '}';
    }
}
