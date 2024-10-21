package model;

import java.util.UUID;

public class SesiMinigame {
    private UUID idSesiMinigame;
    private UUID idUser;
    private int score;
    private int levelSelesai;
    private String tanggalMain;

    public SesiMinigame(UUID idUser, int score, int levelSelesai, String tanggalMain) {
        UUID uuid = UUID.randomUUID();
        this.setIdSesiMinigame(uuid);
        this.setScore(score);
        this.setLevelSelesai(levelSelesai);
        this.setTanggalMain(tanggalMain);
        this.setIdUser(idUser);
    }

    public SesiMinigame(String tanggalMain, int score, int levelSelesai)
    {
        this.setTanggalMain(tanggalMain);
        this.setScore(score);
        this.setLevelSelesai(levelSelesai);
    }

    public void setIdUser(UUID idUser) {
        this.idUser = idUser;
    }

    public UUID getIdUser() {
        return idUser;
    }

    public UUID getIdSesiMinigame() {
        return idSesiMinigame;
    }

    public void setIdSesiMinigame(UUID idSesiMinigame) {
        this.idSesiMinigame = idSesiMinigame;
    }

    public int getLevelSelesai() {
        return levelSelesai;
    }

    public void setLevelSelesai(int levelSelesai) {
        this.levelSelesai = levelSelesai;
    }

    public String getTanggalMain() {
        return tanggalMain;
    }

    public void setTanggalMain(String tanggalMain) {
        this.tanggalMain = tanggalMain;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}



