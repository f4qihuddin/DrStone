package controller;

import dao.MiniGameDataDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.MiniGameData;
import model.Session;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MiniGameMenuController implements Initializable
{
    public User currentUser = Session.getInstance().getUser();

    @FXML
    private Button easyModeButton;

    @FXML
    private Button hardModeButton;

    @FXML
    private Button mediumModeButton;

    @FXML
    private Button mainMenuButton;

    @FXML
    private Text totalPlayed;

    @FXML
    private Text highestScore;

    @FXML
    public void goToEasyMode() throws IOException
    {
        Stage stage = (Stage) easyModeButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/view/mini-game-diff-1-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Easy Mode");
        stage.setScene(scene);
    }

    @FXML
    public void goToMediumMode() throws IOException
    {
        Stage stage = (Stage) mediumModeButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/view/mini-game-diff-2-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Medium Mode");
        stage.setScene(scene);
    }

    @FXML
    public void goToHardMode() throws IOException
    {
        Stage stage = (Stage) hardModeButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/view/mini-game-diff-3-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hard Mode");
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        MiniGameData miniGameData = MiniGameDataDAO.getMiniGameData(currentUser.getUserID());

        if (miniGameData == null)
        {
            totalPlayed.setText("0");
            highestScore.setText("0");
        }
        else
        {
            totalPlayed.setText(Integer.toString(MiniGameDataDAO.getMiniGameData(currentUser.getUserID()).getTotalPlayed()));
            highestScore.setText(Integer.toString(MiniGameDataDAO.getMiniGameData(currentUser.getUserID()).getHighestScore()));
        }
    }
}

