package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController
{
    @FXML
    private Button exitButton;

    @FXML
    private Button logInButton;

    @FXML
    private Button signUpButton;

    @FXML
    public void goToSignUp() throws IOException
    {
        Stage stage = (Stage) signUpButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/view/sign-up-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Sign Up");
        stage.setScene(scene);
    }


    public void exit()
    {
        Platform.exit();
    }
}

