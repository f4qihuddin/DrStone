package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.DataMinigame;


public class DataMinigameDAO extends BaseDAO {

    private  static PreparedStatement st;
    private static Connection con;

    public static void insertDataMinigame(DataMinigame dataMinigame)
    {
        try
        {
            con = getCon();
            String query = "INSERT INTO data_mini_game (idDataMiniGame, highestScore, idUser, totalLevelSelesai, totalPermainan) VALUES (%s, %d, '%s', %d, %d)";
            query = String.format(query, dataMinigame.getIdDataMinigame(), dataMinigame.getHighestScore(), dataMinigame.getIdUser(), dataMinigame.getTotalLevelSelesai(), dataMinigame.getTotalPermainan());
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
    public static void deleteDataMinigame(DataMinigame dataMinigame)
    {
        try
        {
            con = getCon();
            String query = "DELETE FROM data_mini_game WHERE idDataMinigame = '%s'";
            query = String.format(query, dataMinigame.getIdDataMinigame());
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

    public static void updateDataMinigame(DataMinigame dataMinigameBaru, DataMinigame dataMinigameLama)
    {
        try
        {
            con = getCon();
            String query = "UPDATE data_mini_game SET totalPermainan = %d, totalLevelSelesai = %d, highestScore = %d WHERE idDataMinigame '%s'";
            query = String.format(query, dataMinigameBaru.getTotalPermainan(), dataMinigameBaru.getTotalLevelSelesai(), dataMinigameBaru.getHighestScore(), dataMinigameLama.getIdDataMinigame());
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
}
