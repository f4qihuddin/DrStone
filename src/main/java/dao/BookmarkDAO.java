package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import model.Bookmark;
import model.Stone;

public class BookmarkDAO extends BaseDAO{
    private static PreparedStatement st;
    private static Connection con;

    public static ArrayList<Bookmark> showBookmark(UUID userID)
    {
        ArrayList<Bookmark> bookmarks = new ArrayList<>();;
        try
        {
            con = getCon();
            String query = "SELECT * FROM bookmark WHERE idUser = '%s'";
            query = String.format(query, userID);
            st = con.prepareStatement(query);
            ResultSet resultSet= st.executeQuery();
            while (resultSet.next())
            {
                Bookmark bookmark = new Bookmark(resultSet.getString("namaBookmark"), UUID.fromString(resultSet.getString("idUser")), UUID.fromString(resultSet.getString("idBatu")));
                bookmarks.add(bookmark);
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
        return bookmarks;
    }

    public static boolean addBookmark(String namaBookmark, UUID idUser, UUID idBatu) {
        boolean success = false;
        try {
            con = getCon();
            String query = "INSERT INTO bookmark (idBookmark, namaBookmark, idUser, idBatu) VALUES (UUID(), '%s', '%s', '%s')";
            query = String.format(query, namaBookmark, idUser, idBatu);
            st = con.prepareStatement(query);
            success = st.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return success;
    }

    public static boolean deleteBookmark(UUID stoneID) {
        boolean success = false;
        try {
            con = getCon();
            String query = "DELETE FROM bookmark WHERE idBatu = '%s'";
            query = String.format(query, stoneID);
            st = con.prepareStatement(query);
            success = st.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        if (!success)
        {
            System.out.println("tidak berhasil terhapus");
        }
        else
        {
            System.out.println("berhasil terhapus");
        }
        return success;
    }

    public static boolean updateBookmark(String namaBookmark, String idBookmark) {
        boolean success = false;
        try {
            con = getCon();
            String query = "UPDATE bookmark SET nama = '%s' WHERE id_bookmark = '%s'";
            query = String.format(query, namaBookmark, idBookmark);
            st = con.prepareStatement(query);
            success = st.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return success;
    }

    public static boolean isBookmarked(UUID userID, UUID stoneID)
    {
        boolean isBookmarked = false;
        try {
            con = getCon();
            String query = "SELECT idBookmark FROM bookmark WHERE idUser = '%s' AND idBatu = '%s'";
            query = String.format(query, userID, stoneID);
            st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            if (rs.next())
            {
                isBookmarked = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return isBookmarked;
    }
}
