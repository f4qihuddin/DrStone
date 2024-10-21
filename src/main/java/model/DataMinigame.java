package model;
import java.util.UUID;


public class DataMinigame {
    private UUID idDataMinigame;
    private int totalPermainan;
    private int totalLevelSelesai;
    private int highestScore;
    private UUID idUser;

    public DataMinigame(int totalPermainan, int totalLevelSelesai, int highestScore, UUID idUser){
        UUID uuid = UUID.randomUUID();
        this.setIdDataMinigame(uuid);
        this.setTotalPermainan(totalPermainan);
        this.setTotalLevelSelesai(totalLevelSelesai);
        this.setHighestScore(highestScore);
        this.setIdUser(idUser);
    }

    public UUID getIdDataMinigame() {
        return idDataMinigame;
    }

    public void setIdDataMinigame(UUID idDataMinigame) {
        this.idDataMinigame = idDataMinigame;
    }

    public int getTotalLevelSelesai() {

        return totalLevelSelesai;
    }

    public void setTotalLevelSelesai(int totalLevelSelesai) {
        this.totalLevelSelesai = totalLevelSelesai;
    }

    public int getTotalPermainan() {
        return totalPermainan;
    }

    public void setTotalPermainan(int totalPermainan) {
        this.totalPermainan = totalPermainan;
    }

    public int getHighestScore() {
        return highestScore;
    }

    public void setHighestScore(int highestScore) {
        this.highestScore = highestScore;
    }

    public UUID getIdUser() {
        return idUser;
    }

    public void setIdUser(UUID idUser) {
        this.idUser = idUser;
    }
}
