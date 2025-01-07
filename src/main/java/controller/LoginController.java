package controller;

import dao.UserDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Session;
import model.User;

public class LoginController implements Initializable {

    @FXML
    private Button logInButton;
    @FXML
    private Button signUpButton;
    @FXML
    private PasswordField inputPassword;
    @FXML
    private TextField inputUsername;
    @FXML
    private TextField inputPasswordVisible;
    @FXML
    private Text text;
    @FXML
    private Button VisiblePasswordButton;

    private boolean isPasswordVisible = false;

    @FXML
    public void togglePasswordVisibility() {
        if (isPasswordVisible) {
            // Sembunyikan password dan tampilkan field password
            inputPasswordVisible.setVisible(false);
            inputPassword.setVisible(true);
            inputPassword.setText(inputPasswordVisible.getText());  // Sinkronisasi teks
            VisiblePasswordButton.setText("\uD83D\uDD12");  // Ikon tombol
        } else {
            // Tampilkan password dan sembunyikan field password
            inputPassword.setVisible(false);
            inputPasswordVisible.setVisible(true);
            inputPasswordVisible.setText(inputPassword.getText());  // Sinkronisasi teks
            VisiblePasswordButton.setText("\uD83D\uDD13");  // Ikon tombol
        }
        isPasswordVisible = !isPasswordVisible;
    }

    @FXML
    public void goToSignUp() throws IOException {
        Stage stage = (Stage) signUpButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/view/sign-up-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Sign Up");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void validateUser() throws IOException {
        User user;
        String password = isPasswordVisible ? inputPasswordVisible.getText() : inputPassword.getText();

        if (password.isEmpty() || inputUsername.getText().isEmpty()) {
            showErrorMessage("Username atau Password tidak boleh kosong!");
            return;
        }

        user = UserDAO.validate(inputUsername.getText(), password);
        String role = user != null ? user.getRole() : "";

        if (user != null) {
            if ("admin".equalsIgnoreCase(role)) {
                // Navigate to admin view
                Stage stage = (Stage) logInButton.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("/view/admin-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                stage.setTitle("Admin Dashboard");
                stage.setScene(scene);
                stage.show();
            } else if ("user".equalsIgnoreCase(role)) {
                // Navigate to user view
                Stage stage = (Stage) logInButton.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("/view/main-menu-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                stage.setTitle("Main Menu");
                stage.setScene(scene);
                Session.getInstance().setUser(user);
                stage.show();
            } else {
                showErrorMessage("Role tidak valid!");
            }
        } else {
            showErrorMessage("Data tidak valid!");
        }
    }

    private void showErrorMessage(String message) {
        text.setText(message);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        text.setText("");
        inputPasswordVisible.setVisible(false);
    }
}
