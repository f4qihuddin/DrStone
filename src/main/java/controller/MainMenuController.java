package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    @FXML
    private Button homeButton;
    @FXML
    private Button learningButton;
    @FXML
    private Button miniGameButton;

    @FXML
    public void goToHome() throws IOException
    {
        Stage stage = (Stage) homeButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenuController.class.getResource("/view/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Home");
        stage.setScene(scene);
    }

    @FXML
    public void goToLearning() throws IOException
    {
        Stage stage = (Stage) learningButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/view/root-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Learning");
        stage.setScene(scene);
    }

    @FXML
    public void goToMiniGameMenu() throws IOException
    {
        Stage stage = (Stage) miniGameButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/view/mini-game-menu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Mini Game");
        stage.setScene(scene);
    }
}

