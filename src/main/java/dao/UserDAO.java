package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

import static java.util.UUID.fromString;

public class UserDAO extends BaseDAO
{
    private static PreparedStatement st;
    private static Connection con;

    public static User validate(String username, String password)
    {
        User user = null;
        try
        {
            con = getCon();
            String query = "SELECT * FROM users WHERE BINARY username = '%s' AND BINARY pass = '%s'";
            query = String.format(query, username, password);
            st = con.prepareStatement(query);
            ResultSet resultSet = st.executeQuery();

            if (resultSet.next())
            {
                String role = resultSet.getString("role");
                user = new User(fromString(resultSet.getString("idUser")), username, password, role);

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
        return user;
    }

    public static void registerUser(User user) {
        String query = String.format("INSERT INTO users (idUser, username, pass, role) VALUES ('%s', '%s', '%s', '%s')",  user.getUserID(), user.getUsername(), user.getPassword(), "user");

        try {
            Connection con = getCon();
            PreparedStatement st = con.prepareStatement(query);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean isUserExists(String username) {
        boolean exists = false;
        String query = String.format("SELECT 1 FROM users WHERE BINARY username = '%s'", username);

        try (Connection con = getCon();
             PreparedStatement st = con.prepareStatement(query)) {
            ResultSet resultSet = st.executeQuery();

            exists = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }
}

