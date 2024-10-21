package model;

import java.util.UUID;

public class Bookmark {
    private UUID idBookmark;
    private String namaBookmark;
    private UUID idUser;
    private UUID idBatu;

    public Bookmark(UUID idUser, String namaBookmark, UUID idBatu) {
        this.setIdBookmark(UUID.randomUUID());
        this.setNamaBookmark(namaBookmark);
        this.setIdBatu(idBatu);
        this.setIdUser(idUser);
    }

    public Bookmark(String namaBookmark)
    {
        this.setNamaBookmark(namaBookmark);
    }

    public UUID getIdBookmark() {
        return idBookmark;
    }

    public void setIdBookmark(UUID idBookmark) {
        this.idBookmark = idBookmark;
    }

    public UUID getIdUser() {
        return idUser;
    }

    public void setIdUser(UUID idUser) {
        this.idUser = idUser;
    }

    public String getNamaBookmark() {
        return namaBookmark;
    }

    public void setNamaBookmark(String namaBookmark) {
        this.namaBookmark = namaBookmark;
    }

    public UUID getIdBatu() {
        return idBatu;
    }

    public void setIdBatu(UUID idBatu) {
        this.idBatu = idBatu;
    }

    @Override
    public String toString() {
        return "Bookmark{" +
                "idBookmark=" + idBookmark +
                ", idUser=" + idUser +
                ", nama='" + namaBookmark + '\'' +
                ", idBatu=" + idBatu +
                '}';
    }
}
