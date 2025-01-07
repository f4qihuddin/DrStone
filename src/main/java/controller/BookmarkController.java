package controller;

import dao.BookmarkDAO;
import dao.StoneDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.UUID;

public class BookmarkController implements Initializable
{
    @FXML
    private GridPane bookmarkList;

    @FXML
    private Button backButton;

    public User currentUser = Session.getInstance().getUser();

    private RootController rootController;

    @FXML
    public void goToLearningMenu() throws IOException
    {
        Stage stage = (Stage) backButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/view/root-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Main Menu");
        stage.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        ArrayList<Bookmark> bookmarks = new ArrayList<>();
        bookmarks.addAll(BookmarkDAO.showBookmark(currentUser.getUserID()));

        for (int i = 0; i < bookmarks.size(); i++)
        {
            HBox hBox = new HBox(20);

            UUID stoneID = bookmarks.get(i).getStoneID();
            Stone stone = StoneDAO.searchStoneByID(stoneID);
            ImageView stoneImageView = new ImageView();
            byte[] imageData = StoneDAO.getImageByID(stoneID);
            if (imageData != null)
            {
                Image image = new Image(new ByteArrayInputStream(imageData));
                stoneImageView.setImage(image);
            }
            /*
            else
            {
                System.err.println("Gambar untuk " + stone.getName() + " tidak ditemukan.");
                var inputStream = Card.class.getResourceAsStream("/images/default_image.png");
                if (inputStream == null)
                {
                    throw new IllegalArgumentException("Image file not found");
                }
                stoneImageView.setImage(new Image(inputStream));
            }

             */

            stoneImageView.setFitWidth(50);
            stoneImageView.setFitHeight(50);

            Button button = new Button();
            Button deleteButton = new Button("X");
            deleteButton.setStyle("-fx-background-color: #000000; -fx-text-fill: white; -fx-font-size: 16px;");
            deleteButton.setPrefWidth(25);
            deleteButton.setPrefHeight(25);
            button.setText(bookmarks.get(i).getBookmarkName());
            button.setPrefWidth(250);
            button.setPrefHeight(30);
            button.setOnMouseClicked(event ->
            {
                try
                {
                    rootController.showStone(StoneDAO.searchStoneByID(stoneID).getName());
                }
                catch (IOException e)
                {
                    throw new RuntimeException(e);
                }
            });

            int finalI = i;
            deleteButton.setOnMouseClicked(event ->{
                // Hapus bookmark dari database
                BookmarkDAO.deleteBookmark(bookmarks.get(finalI).getStoneID());

                // Hapus elemen dari GridPane
                bookmarkList.getChildren().remove(hBox);
            });

            hBox.getChildren().add(stoneImageView);
            hBox.getChildren().add(button);
            hBox.getChildren().add(deleteButton);
            hBox.setAlignment(Pos.CENTER);

            bookmarkList.add(hBox, 0, i);
        }
    }

    public void setRootController(RootController rootController)
    {
        this.rootController = rootController;
    }
}
