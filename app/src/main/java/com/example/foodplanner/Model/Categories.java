package com.example.foodplanner.Model;

public class Categories {
    private int idCategory;
    private String strCategory;
    private String strCategoryThumb;
    private String strCategoryDescription;

    public Categories(int idCategory, String strCategory, String strCategoryThumb, String strCategoryDescription) {
        this.idCategory = idCategory;
        this.strCategory = strCategory;
        this.strCategoryThumb = strCategoryThumb;
        this.strCategoryDescription = strCategoryDescription;
    }
    public Categories(){}

    /* Getters */
    public int getIdCategory() {
        return idCategory;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public String getStrCategoryThumb() {
        return strCategoryThumb;
    }

    public String getStrCategoryDescription() {
        return strCategoryDescription;
    }

    /* Setters */
    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public void setStrCategoryThumb(String strCategoryThumb) {
        this.strCategoryThumb = strCategoryThumb;
    }

    public void setStrCategoryDescription(String strCategoryDescription) {
        this.strCategoryDescription = strCategoryDescription;
    }
}
