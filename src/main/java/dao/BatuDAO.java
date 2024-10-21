package dao;

import static dao.BaseDAO.closeCon;
import static dao.BaseDAO.getCon;
import model.Batu;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.SubKategori;

public class BatuDAO extends BaseDAO {

    private static PreparedStatement st;
    private static Connection con;

    public static void displayBatu(Scanner sc, int subKategori) {

        while (true) {  
            List<Batu> batuList = new ArrayList<>();
            Batu batu = null;

            try {
                con = getCon();
                String query = String.format("SELECT idBatu, "
                        + "namaBatu,"
                        + "deskripsi,"
                        + "karakteristik,"
                        + "gambar,"
                        + "sumberYoutube,"
                        + "sumberWebsite,"
                        + "sumberGoogleScholar FROM batu WHERE idSubKategoriBatu = %d", subKategori);

                st = con.prepareStatement(query);
                ResultSet resultSet = st.executeQuery();
                
                System.out.println("\n==== BATU ====");
                while (resultSet.next()) {
                    batu = new Batu(resultSet.getString("namaBatu"), resultSet.getString("deskripsi"),
                            resultSet.getString("karakteristik"), resultSet.getString("gambar"),
                            resultSet.getString("sumberYoutube"), resultSet.getString("sumberWebsite"),
                            resultSet.getString("sumberGoogleScholar"));
                    batuList.add(batu);
                    System.out.println(batuList.size() + ". " + resultSet.getString("namaBatu")); 
                }

                System.out.println("0. Kembali ke Sub-Kategori");
                System.out.print("Pilih item: ");
                int itemIndex = sc.nextInt() - 1; 
                sc.nextLine(); 

                if (itemIndex == -1) {  
                    break; 
                } else if (itemIndex >= 0 && itemIndex < batuList.size()) {
                    showBatu(batuList.get(itemIndex).getNamaBatu());
                } else {
                    System.out.println("Item yang dipilih tidak valid.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeCon(con);
            }
        }

    }

    public static void showBatu(String namaBatu) {
        try {
            con = getCon();
            String query = String.format("SELECT * FROM batu WHERE namaBatu = '%s'", namaBatu);
            st = con.prepareStatement(query);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                System.out.println("Nama Batu: " + resultSet.getString("namaBatu"));
                System.out.println("Deskripsi: " + resultSet.getString("deskripsi"));
                System.out.println("Karakteristik: " + resultSet.getString("karakteristik"));
                System.out.println("Gambar: " + resultSet.getString("gambar"));
                System.out.println("Sumber YouTube: " + resultSet.getString("sumberYoutube"));
                System.out.println("Sumber Website: " + resultSet.getString("sumberWebsite"));
                System.out.println("Sumber Google Scholar: " + resultSet.getString("sumberGoogleScholar"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }

    }
}
