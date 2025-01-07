package dao;

import model.Stone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class StoneDAO extends BaseDAO {

    private static PreparedStatement st;
    private static Connection con;

    public static ArrayList<String> getListOfNames()
    {
        ArrayList<String> listOfNames = new ArrayList<>();

        try
        {
            con = getCon();
            String query = "SELECT namaBatu FROM batu";
            st = con.prepareStatement(query);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next())
            {
                listOfNames.add(resultSet.getString("namaBatu"));
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
        return listOfNames;
    }

    public static ArrayList<Stone> getListOfStones(String subCategoryName)
    {
        ArrayList<Stone> listOfStones = new ArrayList<>();
        Stone stone;

        try
        {
            con = getCon();
            String query = "SELECT *\n" +
                           "FROM batu\n" +
                           "INNER JOIN sub_kategori ON batu.idSubKategoriBatu = sub_kategori.idSubKategoriBatu\n" +
                           "WHERE sub_kategori.namaSubKategori = '%s'";
            query = String.format(query, subCategoryName);
            st = con.prepareStatement(query);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next())
            {
                stone = new Stone(resultSet.getString("namaBatu"), resultSet.getBytes("gambar"), resultSet.getString("deskripsi"), resultSet.getString("karakteristik"), resultSet.getString("sumberGoogleScholar"), resultSet.getString("sumberWebsite"), resultSet.getString("sumberYoutube"));
                listOfStones.add(stone);
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
        return listOfStones;
    }

    public static Stone searchStone(String name)
    {
        Stone stone = null;
        try
        {
            con = getCon();
            String query = String.format("SELECT batu.*, sub_kategori.namaSubKategori FROM batu JOIN sub_kategori ON batu.idSubKategoriBatu = sub_kategori.idSubKategoriBatu WHERE namaBatu = '%s'", name);
            st = con.prepareStatement(query);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next())
            {
                stone = new Stone(UUID.fromString(resultSet.getString("idBatu")), resultSet.getString("namaBatu"), resultSet.getBytes("gambar"), resultSet.getString("deskripsi"), resultSet.getString("karakteristik"), resultSet.getString("sumberGoogleScholar"), resultSet.getString("sumberWebsite"), resultSet.getString("sumberYoutube"), resultSet.getString("namaSubKategori"));
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
        return stone;
    }

    public static ArrayList<String> searchStonesNames(String name)
    {
        ArrayList<String> listOfNames = new ArrayList<>();
        try
        {
            con = getCon();
            String query = "SELECT namaBatu FROM batu WHERE namaBatu LIKE '%" + name + "%'";
            st = con.prepareStatement(query);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next())
            {
                listOfNames.add(resultSet.getString("namaBatu"));
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
        return listOfNames;
    }

    public static Stone searchStoneByID(UUID stoneID)
    {
        Stone stone = null;
        try
        {
            con = getCon();
            String query = String.format("SELECT * FROM batu WHERE idBatu = '%s'", stoneID);
            st = con.prepareStatement(query);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next())
            {
                stone = new Stone(resultSet.getString("namaBatu"), resultSet.getBytes("gambar"), resultSet.getString("deskripsi"), resultSet.getString("karakteristik"), resultSet.getString("sumberGoogleScholar"), resultSet.getString("sumberWebsite"), resultSet.getString("sumberYoutube"));
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
        return stone;
    }

    // CREATE: Add a new Stone
    public static boolean createStone(Stone stone) {
        boolean isSuccess = false;
        try {
            con = getCon();
            String query = "INSERT INTO batu (idBatu, namaBatu, deskripsi, karakteristik, gambar, sumberYoutube, sumberWebsite, sumberGoogleScholar, idSubKategoriBatu) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            st = con.prepareStatement(query);
            st.setString(1, stone.getStoneID().toString());
            st.setString(2, stone.getName());
            st.setString(3, stone.getDescription());
            st.setString(4, stone.getCharacteristics());
            st.setBytes(5, stone.getImage());
            st.setString(6, stone.getYoutube());
            st.setString(7, stone.getWeb());
            st.setString(8, stone.getGoogleScholar());
            st.setString(9, stone.getSubCategoryID().toString());


            int rowsAffected = st.executeUpdate();
            isSuccess = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return isSuccess;
    }

    // READ: Retrieve list of all Stones
    public static ArrayList<Stone> getAllStones() {
        ArrayList<Stone> listOfStones = new ArrayList<>();
        try {
            con = getCon();
            String query = "SELECT * FROM batu";
            st = con.prepareStatement(query);
            ResultSet resultSet = st.executeQuery();

            while (resultSet.next()) {
                Stone stone = new Stone(UUID.fromString(resultSet.getString("idBatu")), resultSet.getString("namaBatu"), resultSet.getBytes("gambar"), resultSet.getString("deskripsi"), resultSet.getString("karakteristik"), resultSet.getString("sumberGoogleScholar"), resultSet.getString("sumberWebsite"), resultSet.getString("sumberYoutube"), UUID.fromString(resultSet.getString("idSubKategoriBatu")));
                listOfStones.add(stone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return listOfStones;
    }

    // UPDATE: Modify an Existing Stone
    public static boolean updateStone(Stone stone) {
        boolean isSuccess = false;
        try {
            con = getCon();
            String query = "UPDATE batu SET namaBatu = ?, gambar = ?, deskripsi = ?, karakteristik = ?, sumberGoogleScholar = ?, sumberWebsite = ?, sumberYoutube = ?, idSubKategoriBatu = ? WHERE idBatu = ?";
            st = con.prepareStatement(query);
            st.setString(1, stone.getName());
            st.setBytes(2, stone.getImage());
            st.setString(3, stone.getDescription());
            st.setString(4, stone.getCharacteristics());
            st.setString(5, stone.getGoogleScholar());
            st.setString(6, stone.getWeb());
            st.setString(7, stone.getYoutube());
            st.setString(8, stone.getSubCategoryID().toString());
            st.setString(9, stone.getStoneID().toString());

            int rowsAffected = st.executeUpdate();
            isSuccess = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return isSuccess;
    }

    // DELETE: Remove a Stone from the Database
    public static boolean deleteStone(String name) {
        boolean isSuccess = false;
        try {
            con = getCon();
            String query = "DELETE FROM batu WHERE namaBatu = ?";
            st = con.prepareStatement(query);
            st.setString(1, name);
            int rowsAffected = st.executeUpdate();
            isSuccess = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return isSuccess;
    }

    public static byte[] getImage(String stoneName)
    {
        byte[] imageData = null;
        try {
            con = getCon();
            String sql = "SELECT gambar FROM batu WHERE namaBatu = '%s'";
            sql = String.format(sql, stoneName);
            st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            if (rs.next())
            {
                imageData = rs.getBytes("gambar");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return imageData;
    }

    public static byte[] getImageByID(UUID ID)
    {
        byte[] imageData = null;
        try {
            con = getCon();
            String sql = "SELECT gambar FROM batu WHERE idBatu = '%s'";
            sql = String.format(sql, ID);
            st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            if (rs.next())
            {
                imageData = rs.getBytes("gambar");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return imageData;
    }
}
