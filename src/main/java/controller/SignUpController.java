package controller;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.util.Duration;
import model.User;
import dao.UserDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SignUpController implements Initializable {

    @FXML
    private PasswordField inputPassword;
    @FXML
    private TextField inputUsername;
    @FXML
    private Button signUpButton;
    @FXML
    private Button logInButton;
    @FXML
    private Text text;
    @FXML
    private TextField inputPasswordVisible;
    @FXML
    private Button VisiblePasswordButton;

    private boolean isPasswordVisible = false;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        text.setText("");
        inputPasswordVisible.setVisible(false);

        // Listener untuk sinkronisasi
        inputPassword.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!isPasswordVisible) {
                inputPasswordVisible.setText(newValue);
            }
        });

        inputPasswordVisible.textProperty().addListener((observable, oldValue, newValue) -> {
            if (isPasswordVisible) {
                inputPassword.setText(newValue);
            }
        });
    }

    @FXML
    public void registerUser() {
        // Sinkronisasi sebelum validasi
        synchronizePasswords();

        String username = inputUsername.getText();
        String password = inputPassword.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showStatusMessage("Username atau Password tidak boleh kosong!");
            return;
        }

        if (username.length() < 5) {
            showStatusMessage("Username harus memiliki minimal 5 karakter!");
            return;
        }

        if (password.length() < 8) {
            showStatusMessage("Password harus memiliki minimal 8 karakter!");
            return;
        }

        if (!isValidPassword(password)) {
            showStatusMessage("Password harus terdiri dari minimal 1 huruf besar, 1 huruf kecil, 1 angka, dan 1 karakter khusus (!@#$%^=_&*).");
            return;
        }

        boolean isUserExists = UserDAO.isUserExists(username);

        if (isUserExists) {
            showStatusMessage("Username sudah terdaftar!");
        } else {
            User user = new User(username, password);
            UserDAO.registerUser(user);
            showStatusMessage(user.getUsername() + " berhasil terdaftar!");

            PauseTransition pause = new PauseTransition(Duration.seconds(2));
            pause.setOnFinished(event -> navigateToLogin());
            pause.play();
        }
    }

    @FXML
    public void togglePasswordVisibility() {
        synchronizePasswords();

        if (isPasswordVisible) {
            inputPasswordVisible.setVisible(false);
            inputPassword.setVisible(true);
            VisiblePasswordButton.setText("\uD83D\uDD12");
        } else {
            inputPassword.setVisible(false);
            inputPasswordVisible.setVisible(true);
            VisiblePasswordButton.setText("\uD83D\uDD13");
        }

        isPasswordVisible = !isPasswordVisible;
    }

    // Sinkronisasi password
    private void synchronizePasswords() {
        if (isPasswordVisible) {
            inputPassword.setText(inputPasswordVisible.getText());
        } else {
            inputPasswordVisible.setText(inputPassword.getText());
        }
    }

    private boolean isValidPassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^=&_*(),.?\":{}|<>]).{8,}$";
        return password.matches(regex);
    }

    private void showStatusMessage(String message) {
        text.setText(message);
    }

    private void navigateToLogin() {
        try {
            Stage stage = (Stage) signUpButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Main Menu");
            stage.setScene(scene);
        } catch (IOException e) {
            System.err.println("Error loading login view: " + e.getMessage());
            showStatusMessage("Gagal memuat menu utama. Silakan coba lagi.");
        }
    }

    @FXML
    public void goToLogin() throws IOException {
        Stage stage = (Stage) logInButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/view/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("login");
        stage.setScene(scene);
        stage.show();
    }
}
