package model;

import dao.BaseDAO;
import java.util.List;

public class SubCategory extends BaseDAO
{
    private String name;
    private List<Stone> listOfStones;

    public SubCategory(String name, List<Stone> listOfStones)
    {
        this.setName(name);
        this.setListOfStones(listOfStones);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Stone> getListOfStones()
    {
        return listOfStones;
    }

    public void setListOfStones(List<Stone> listOfStones)
    {
        this.listOfStones = listOfStones;
    }
}
