package dao;

import model.Stone;
import model.SubCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import static java.util.UUID.fromString;

public class SubCategoryDAO extends BaseDAO {

    private static PreparedStatement st;
    private static Connection con;

    public static ArrayList<SubCategory> getSubCategories(String categoryName)
    {
        SubCategory subCategory;
        ArrayList<SubCategory> subCategories = new ArrayList<>();
        ArrayList<Stone> stones;

        try
        {
            con = getCon();
            String query = "SELECT namaSubKategori\n" +
                           "FROM sub_kategori\n" +
                           "INNER JOIN kategori ON sub_kategori.idKategoriBatu = kategori.idKategoriBatu\n" +
                           "WHERE kategori.namaKategori = '%s'";
            query = String.format(query, categoryName);
            st = con.prepareStatement(query);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next())
            {
                stones = StoneDAO.getListOfStones(resultSet.getString("namaSubKategori"));
                subCategory = new SubCategory(resultSet.getString("namaSubKategori"), stones);
                subCategories.add(subCategory);
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
        return subCategories;
    }

    public static UUID getSubCategoryId(String subCategoryName)
    {
        UUID subCategoryID = null;
        try
        {
            con = getCon();
            String query = "SELECT idSubKategoriBatu FROM sub_kategori WHERE namaSubKategori = '%s'";
            query = String.format(query, subCategoryName);
            st = con.prepareStatement(query);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next())
            {
                subCategoryID = fromString(resultSet.getString("idSubKategoriBatu"));
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
        return subCategoryID;
    }

    public static String getSubCategoryByID(UUID subCategoryID)
    {
        String subCategory = null;
        try
        {
            con = getCon();
            String query = "SELECT namaSubKategori FROM sub_kategori WHERE idSubKategoriBatu = '%s'";
            query = String.format(query, subCategoryID);
            st = con.prepareStatement(query);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next())
            {
                subCategory = resultSet.getString("namaSubKategori");
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
        return subCategory;
    }
}
