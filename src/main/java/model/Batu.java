package model;

import java.util.*;

public class Batu {
    private String namaBatu;
    private String gambar;
    private String deskripsi;
    private String karakteristik;
    private String googleScholar;
    private String web;
    private String yt;


    public Batu(String namaBatu, String gambar, String deskripsi, String karakteristik, String googleScholar, String web, String yt){
        this.setNamaBatu(namaBatu);
        this.setGambar(gambar);
        this.setDeskripsi(deskripsi);
        this.setKarakteristik(karakteristik);
        this.setGoogleScholar(googleScholar);
        this.setWeb(web);
        this.setYt(yt);

    }

    public void setNamaBatu(String namaBatu){
        this.namaBatu = namaBatu;
    }

    public String getNamaBatu(){
        return namaBatu;
    }

    public void setGambar(String gambar){
        this.gambar = gambar;
    }

    public String getGambar(){
        return gambar;
    }

    public void setDeskripsi(String deskripsi){
        this.deskripsi = deskripsi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setKarakteristik(String karakteristik){
        this.karakteristik = karakteristik;
    }

    public String getKarakteristik(){
        return karakteristik;
    }

    public void setGoogleScholar(String googleScholar){
        this.googleScholar = googleScholar;
    }

    public String getGoogleScholar(){
        return googleScholar;
    }

    public void setWeb(String web){
        this.web = web;
    }

    public String getWeb(){
        return web;
    }

    public void setYt(String yt){
        this.yt = yt;
    }

    public String getYt(){
        return yt;
    }

}
