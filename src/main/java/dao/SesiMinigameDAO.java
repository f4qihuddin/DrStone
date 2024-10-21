package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.SesiMinigame;

public class SesiMinigameDAO extends BaseDAO{
    private static PreparedStatement st;
    private static Connection con;

    public static void insertSesiDataMinigame(SesiMinigame sesiMinigame){
        try
        {
            con = getCon();
            String query = "INSERT INTO sesi_mini_game (idSesiMiniGame, idUser, score, levelSelesai, tanggalMain) VALUES (%s, %s, %d, %d, %s)";
            query = String.format (query, sesiMinigame.getIdSesiMinigame(), sesiMinigame.getIdUser(), sesiMinigame.getScore(), sesiMinigame.getLevelSelesai(), sesiMinigame.getTanggalMain());
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

    public List<SesiMinigame> getAllSesiMinigame() {
        List<SesiMinigame> sesiMinigameList = new ArrayList<>();
        try {
            String query = "SELECT tanggalMain, score, levelSelesai FROM sesi_mini_game";
            con = getCon();
            st = con.prepareStatement(query);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                SesiMinigame sesiMinigame = new SesiMinigame(resultSet.getString("tanggalMain"), resultSet.getInt("score"), resultSet.getInt("levelSelesai"));
                sesiMinigameList.add(sesiMinigame);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return sesiMinigameList;
    }
}
