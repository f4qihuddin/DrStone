package dao;

import model.Category;
import model.SubCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDAO extends BaseDAO {

    private static PreparedStatement st;
    private static Connection con;

    public static ArrayList<Category> getAllCategories()
    {
        Category category;
        ArrayList<Category> categories = new ArrayList<>();
        ArrayList<SubCategory> subCategories;
        try
        {
            con = getCon();
            String query = "SELECT namaKategori FROM kategori";
            st = con.prepareStatement(query);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next())
            {
                subCategories = SubCategoryDAO.getSubCategories(resultSet.getString("namaKategori"));
                category = new Category(resultSet.getString("namaKategori"), subCategories);
                categories.add(category);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeCon(con);
        }
        return categories;
    }

}
