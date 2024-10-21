package dao;

import model.Bookmark;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookmarkDAO extends BaseDAO{
    private static PreparedStatement st;
    private static Connection con;

    public static boolean addBookmark(Bookmark bookmark) {
        boolean success = false;
        try {
            con = getCon();
            String query = "INSERT INTO bookmarks (id_bookmark, nama, id_user, id_batu) VALUES ('%s', '%s', '%s', '%s')";
            query = String.format(query, bookmark.getIdBookmark(), bookmark.getNamaBookmark(), bookmark.getIdUser(), bookmark.getIdBatu());
            st = con.prepareStatement(query);
            success = st.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return success;
    }

    public static boolean deleteBookmark(Bookmark bookmark) {
        boolean success = false;
        try {
            con = getCon();
            String query = "DELETE FROM bookmarks WHERE id_bookmark = '%s'";
            query = String.format(query, bookmark.getIdBookmark());
            st = con.prepareStatement(query);
            success = st.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return success;
    }

    public static boolean updateBookmark(Bookmark bookmarkBaru, Bookmark bookmarkLama) {
        boolean success = false;
        try {
            con = getCon();
            String query = "UPDATE bookmarks SET nama = '%s' WHERE id_bookmark = '%s'";
            query = String.format(query, bookmarkBaru.getNamaBookmark(), bookmarkLama.getIdBookmark());
            st = con.prepareStatement(query);
            success = st.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return success;
    }
}
