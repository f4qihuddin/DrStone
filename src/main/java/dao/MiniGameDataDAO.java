package dao;

import model.MiniGameData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;


public class MiniGameDataDAO extends BaseDAO {

    private  static PreparedStatement st;
    private static Connection con;

    public static void insertMiniGameData(MiniGameData minigameData)
    {
        try
        {
            con = getCon();
            String query = "INSERT INTO data_mini_game (idDataMiniGame, totalPermainan, highestScore, idUser) VALUES ('%s', %d, %d, '%s')";
            query = String.format(query, minigameData.getMiniGameDataID(), minigameData.getTotalPlayed(), minigameData.getHighestScore(), minigameData.getUserID());
            PreparedStatement st = con.prepareStatement(query);
            st.executeUpdate();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeCon(con);
        }
    }
    public static void deleteMiniGameData(MiniGameData dataMinigame)
    {
        try
        {
            con = getCon();
            String query = "DELETE FROM data_mini_game WHERE idDataMinigame = '%s'";
            query = String.format(query, dataMinigame.getMiniGameDataID());
            st = con.prepareStatement(query);
            st.executeUpdate();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeCon(con);
        }
    }

    public static void updateMiniGameData(MiniGameData newMiniGameData, UUID userID)
    {
        try
        {
            con = getCon();
            String query = "UPDATE data_mini_game SET totalPermainan = %d, highestScore = %d WHERE idUser = '%s'";
            query = String.format(query, newMiniGameData.getTotalPlayed(), newMiniGameData.getHighestScore(), userID);
            st = con.prepareStatement(query);
            st.executeUpdate();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeCon(con);
        }
    }

    public static MiniGameData getMiniGameData(UUID userID)
    {
        MiniGameData miniGameData = null;
        try
        {
            con = getCon();
            String query = "SELECT * FROM data_mini_game WHERE idUser = '%s'";
            query = String.format(query, userID);
            st = con.prepareStatement(query);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next())
            {
                miniGameData = new MiniGameData(resultSet.getInt("totalPermainan"), resultSet.getInt("highestScore"), UUID.fromString(resultSet.getString("idUser")));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeCon(con);
        }
        return miniGameData;
    }
}
