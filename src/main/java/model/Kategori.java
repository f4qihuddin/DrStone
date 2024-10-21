package model;

import dao.BaseDAO;

public class Kategori extends BaseDAO
{
    private String namaKategori;

    public Kategori(String namaKategori)
    {
        this.setNamaKategori(namaKategori);
    }

    public String getNamaKategori()
    {
        return namaKategori;
    }

    public void setNamaKategori(String namaKategori)
    {
        this.namaKategori = namaKategori;
    }
}
