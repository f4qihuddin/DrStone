package controller;

import dao.StoneDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class LearningController implements Initializable
{
    @FXML
    private Button bookmarkButton;

    @FXML
    private Button mainMenuButton;

    @FXML
    private Button categoryButton;

    @FXML
    private TextField searchBar;

    @FXML
    private Button searchButton;

    @FXML
    private Text randomQuotesText;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox recomendation;

    private ArrayList<String> recomendationList = new ArrayList<>();

    private RootController rootController;

    @FXML
    public void searchStone() throws IOException
    {
        rootController.showStone(searchBar.getText());

        Stage stage = (Stage) searchButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/view/root-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Stone View");
        stage.setScene(scene);
    }

    @FXML
    public void goToMainMenu() throws IOException
    {
        Stage stage = (Stage) mainMenuButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/view/main-menu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Main Menu");
        stage.setScene(scene);
    }

    @FXML
    public void goToBookmark()
    {
        try
        {
            rootController.showBookmark();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void goToCategory()
    {
        try
        {
            rootController.showCategories();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] quotes =
                {
                        "\"Setiap batu di bumi adalah saksi bisu dari miliaran tahun perjalanan sejarah alam, menyimpan jejak yang lebih tua dari peradaban kita.\"",
                        "\"Batu-batuan di kerak bumi merupakan sisa-sisa bintang yang meledak jutaan tahun lalu, menunjukkan bahwa kita semua terbuat dari materi bintang.\"",
                        "\"Batuan metamorf seperti marmer dan batu tulis terbentuk melalui tekanan dan panas luar biasa di dalam bumi, membuktikan bahwa keindahan dapat lahir dari tekanan.\"",
                        "\"Batu apung adalah satu-satunya batu yang bisa mengapung di atas air karena pori-porinya yang dipenuhi udara, membuktikan bahwa bebatuan pun bisa ringan.\"",
                        "\"Mineral di dalam batuan seperti granit dan basal adalah komponen utama dalam pembuatan perangkat teknologi kita, dari ponsel hingga komputer.\"",
                        "\"Batuan sedimen terbentuk dari lapisan demi lapisan sisa organisme dan materi yang mengendap selama jutaan tahun, menjadikannya arsip alam paling setia.\"",
                        "\"Hampir 70% permukaan bumi ditutupi oleh batuan sedimen, seperti pasir dan kerikil, yang terbentuk dari pengikisan dan perpindahan partikel selama jutaan tahun.\"",
                        "\"Batu permata seperti safir, zamrud, dan rubi terbentuk melalui proses geologis ekstrem dan merupakan salah satu keindahan alam yang memerlukan waktu jutaan tahun untuk terbentuk.\"",
                        "\"Beberapa batu tertua di bumi berusia lebih dari 4 miliar tahun, lebih tua dari kehidupan itu sendiri, mengingatkan kita betapa kecilnya waktu manusia di jagat raya.\""
                };

        Random randomQuotes = new Random();
        int index = randomQuotes.nextInt(quotes.length);
        randomQuotesText.setText(quotes[index]);
    }

    public void showRecomendation()
    {
        recomendationList.clear();
        recomendation.getChildren().clear();

        scrollPane.setVisible(true);
        recomendationList.addAll(StoneDAO.searchStonesNames(searchBar.getText()));



        for (int i = 0; i < recomendationList.size(); i++)
        {
            Button b = new Button();
            b.setPrefWidth(400);
            b.setPrefHeight(30);
            b.setText(recomendationList.get(i));

            b.setOnMouseClicked(event -> {
                try
                {
                    rootController.showStone(b.getText());
                }
                catch (IOException e)
                {
                    throw new RuntimeException(e);
                }
            });

            recomendation.getChildren().add(b);
        }
    }

    public void setRootController(RootController rootController)
    {
        this.rootController = rootController;
    }
}
