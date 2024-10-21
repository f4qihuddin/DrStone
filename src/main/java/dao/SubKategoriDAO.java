package dao;

import static dao.BaseDAO.getCon;
import java.util.Scanner;
import model.SubKategori;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubKategoriDAO extends BaseDAO {

    private static PreparedStatement st;
    private static Connection con;

    public static void displaySubCategories(Scanner sc, int parentCategoryId) {

        List<SubKategori> kategoriList = new ArrayList<>();

        while (true) {
            System.out.println("\n==== SUB-KATEGORI ====");

            try {
                con = getCon();
                String query = String.format("SELECT idSubKategoriBatu, "
                        + "namaSubKategori FROM sub_kategori WHERE idKategoriBatu = %d", parentCategoryId);

                st = con.prepareStatement(query);
                ResultSet resultSet = st.executeQuery();

                System.out.println("\n====SUB-KATEGORI====");
                int count = 1;
                while (resultSet.next()) {
                    SubKategori kategori = new SubKategori(resultSet.getString("namaSubKategori"));
                    kategoriList.add(kategori);
                    System.out.println(count + ". " + resultSet.getString("namaSubKategori") + " (ID:" + resultSet.getInt("idSubKategoriBatu") + ")");
                    count++;
                }

                System.out.println("0. Kembali ke Kategori Utama");
                System.out.print("Pilih ID: ");
                int subCategoryId = sc.nextInt();
                sc.nextLine();

                if (subCategoryId == 0) {
                    break;
                } else {
                    BatuDAO.displayBatu(sc, subCategoryId);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
