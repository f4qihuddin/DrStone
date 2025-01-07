package model;

import java.util.UUID;

public class MiniGameSession {
    private UUID miniGameSessionID;
    private UUID userID;
    private int score;
    private int levelDone;
    private String date;

    public MiniGameSession(UUID idUser, int score, int levelDone, String date) {
        UUID uuid = UUID.randomUUID();
        this.setMiniGameSessionID(uuid);
        this.setScore(score);
        this.setLevelDone(levelDone);
        this.setDate(date);
        this.setUserID(idUser);
    }

    public MiniGameSession(String date, int score, int levelDone)
    {
        this.setDate(date);
        this.setScore(score);
        this.setLevelDone(levelDone);
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public UUID getUserID() {
        return userID;
    }

    public UUID getMiniGameSessionID() {
        return miniGameSessionID;
    }

    public void setMiniGameSessionID(UUID miniGameSessionID) {
        this.miniGameSessionID = miniGameSessionID;
    }

    public int getLevelDone() {
        return levelDone;
    }

    public void setLevelDone(int levelDone) {
        this.levelDone = levelDone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}



