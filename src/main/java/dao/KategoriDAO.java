package dao;

import java.util.Scanner;
import model.Kategori;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KategoriDAO extends BaseDAO {

    private static PreparedStatement st;
    private static Connection con;

    public static void displayCategories(Scanner sc) {

        List<Kategori> kategoriList = new ArrayList<>();

        while (true) {

            try {
                con = getCon();
                String query = "SELECT idKategoriBatu, namaKategori FROM kategori";

                st = con.prepareStatement(query);
                ResultSet resultSet = st.executeQuery();

                System.out.println("Kategori Utama:");
                while (resultSet.next()) {

                    Kategori kategori = new Kategori(resultSet.getString("namaKategori"));
                    kategoriList.add(kategori);
                    System.out.println(resultSet.getInt("idKategoriBatu") + ". " + resultSet.getString("namaKategori"));
                }

                System.out.println("0. Kembali ke Kategori Utama");
                System.out.print("Pilih: ");
                int subCategoryId = sc.nextInt();
                sc.nextLine();

                if (subCategoryId == 0) {
                    break;
                } else {
                    SubKategoriDAO.displaySubCategories(sc, subCategoryId);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

}
