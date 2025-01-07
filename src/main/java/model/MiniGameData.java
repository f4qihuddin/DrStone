package model;
import java.util.UUID;


public class MiniGameData {
    private UUID miniGameDataID;
    private int totalPlayed;
    private int highestScore;
    private UUID userID;

    public MiniGameData(int totalPlayed, int highestScore, UUID userID){
        UUID uuid = UUID.randomUUID();
        this.setMiniGameDataID(uuid);
        this.setTotalPlayed(totalPlayed);
        this.setHighestScore(highestScore);
        this.setUserID(userID);
    }

    public UUID getMiniGameDataID() {
        return miniGameDataID;
    }

    public void setMiniGameDataID(UUID miniGameDataID) {
        this.miniGameDataID = miniGameDataID;
    }

    public int getTotalPlayed() {
        return totalPlayed;
    }

    public void setTotalPlayed(int totalPlayed) {
        this.totalPlayed = totalPlayed;
    }

    public int getHighestScore() {
        return highestScore;
    }

    public void setHighestScore(int highestScore) {
        this.highestScore = highestScore;
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }
}
