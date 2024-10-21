package model;

import dao.BaseDAO;

public class SubKategori extends BaseDAO
{
    private String namaSubKategori;

    public SubKategori(String namaSubKategori)
    {
        this.setNamaSubKategori(namaSubKategori);
    }

    public String getNamaSubKategori()
    {
        return namaSubKategori;
    }

    public void setNamaSubKategori(String namaSubKategori)
    {
        this.namaSubKategori = namaSubKategori;
    }
}
