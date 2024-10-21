package stone;

import java.util.*;
import model.Batu;
import model.User;

import dao.UserDAO;
import dao.BaseDAO;
import dao.BatuDAO;
import dao.BookmarkDAO;
import dao.KategoriDAO;

public class Stone {

    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        

        do {
            System.out.println("1.Sign up");
            System.out.println("2.Login");
            System.out.println("3.Exit");
            System.out.print("Tentukan pilihan: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("username: ");
                String username = sc.nextLine();

                System.out.print("password: ");
                String password = sc.nextLine();


                User user = new User(username, password);

                UserDAO.registerUser(user);

            } else if (choice == 2) {
                System.out.print("username: ");
                String username = sc.nextLine();

                System.out.print("password: ");
                String password = sc.nextLine();


                User validatedUser = UserDAO.validate(username, password);
                if (validatedUser != null) {
                    System.out.println("");
                    System.out.println("=====Login berhasil. Selamat datang, " + validatedUser.getUsername() + "!=====");

                    do {

                        System.out.println("1.Learning");
                        System.out.println("2.Mini Games");
                        System.out.println("3.Home");
                        System.out.print("Tentukan pilihan: ");
                        choice = sc.nextInt();
                        sc.nextLine();

                        if (choice == 1) {

                            do {

                                System.out.println("1.Kategori");
                                System.out.println("2.Bookmark");
                                System.out.println("3.Search");
                                System.out.println("4.Home");
                                System.out.print("Tentukan pilihan: ");
                                choice = sc.nextInt();
                                sc.nextLine();

                                switch (choice) {
                                    case 1:
                                        System.out.println("\n==KATEGORI==");
                                        KategoriDAO.displayCategories(sc);
                                        break;
                                    case 2:
                                        System.out.println("==LIST BOOKMARK==");
                                        break;
                                    case 3:
                                        String search;
                                        System.out.print("Search: ");
                                        search = sc.nextLine();
                                        BatuDAO.showBatu(search);
                                    case 4:
                                        break;
                                    default:
                                        System.out.println("Invalid");
                                        break;
                                }
                            } while (choice != 4);

                        } else if (choice == 2) {

                            System.out.println("\n====coming soon====");
                            
                        } else if (choice == 3) {

                            break;
                        } else {

                            System.out.println("tidak valid");
                        }

                    } while (true);

                } else {
                    System.out.println("Login gagal. Username atau password salah.");
                }

            } else if (choice == 3) {
                break;
            } else {

                System.out.println("Tidak valid");
            }

        } while (true);

    }

}
