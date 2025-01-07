package model;

import dao.BaseDAO;

import java.util.ArrayList;

public class Category extends BaseDAO
{
    private String categoryName;
    private ArrayList<SubCategory> subCategories;

    public Category(String categoryName, ArrayList<SubCategory> subCategories)
    {
        this.setCategoryName(categoryName);
        this.setSubCategories(subCategories);
    }

    public String getCategoryName()
    {
        return categoryName;
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }

    public ArrayList<SubCategory> getSubCategories()
    {
        return subCategories;
    }

    public void setSubCategories(ArrayList<SubCategory> subCategories)
    {
        this.subCategories = subCategories;
    }
}
