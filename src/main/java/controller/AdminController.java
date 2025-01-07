package controller;

import javafx.embed.swing.SwingFXUtils;
import dao.StoneDAO;
import dao.SubCategoryDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Stone;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.UUID;

public class AdminController {

    @FXML
    private TableView<Stone> stoneTableView;

    @FXML
    private TableColumn<Stone, String> stoneIDColumn;
    @FXML
    private TableColumn<Stone, String> stoneNameColumn;
    @FXML
    private TableColumn<Stone, String> descriptionColumn;
    @FXML
    private TableColumn<Stone, String> characteristicsColumn;
    @FXML
    private TableColumn<Stone, String> googleScholarColumn;
    @FXML
    private TableColumn<Stone, String> webColumn;
    @FXML
    private TableColumn<Stone, String> youtubeColumn;
    @FXML
    private TableColumn<Stone, String> subCategoryIDColumn;

    @FXML
    private TextField nameField;
    @FXML
    private TextField descriptionField;
    @FXML
    private TextField characteristicsField;
    @FXML
    private TextField googleScholarField;
    @FXML
    private TextField webField;
    @FXML
    private TextField youtubeField;
    @FXML
    private TextField subCategoryField;

    @FXML
    private Button createStoneButton;
    @FXML
    private Button updateStoneButton;
    @FXML
    private Button deleteStoneButton;

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchField;

    @FXML
    private Button chooseStoneImageButton;
    @FXML
    private ImageView stoneImagePreview;

    @FXML
    private Button loginButton;


    File selectedStoneImageFile;

    UUID stoneID;

    private ObservableList<Stone> stoneList;

    public void initialize() {
        // Initialize stone table view
        stoneIDColumn.setCellValueFactory(new PropertyValueFactory<>("stoneID"));
        stoneNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        characteristicsColumn.setCellValueFactory(new PropertyValueFactory<>("characteristics"));
        googleScholarColumn.setCellValueFactory(new PropertyValueFactory<>("googleScholar"));
        webColumn.setCellValueFactory(new PropertyValueFactory<>("web"));
        youtubeColumn.setCellValueFactory(new PropertyValueFactory<>("youtube"));
        subCategoryIDColumn.setCellValueFactory(new PropertyValueFactory<>("subCategoryID"));

        loadStones();

        // Handle row selection
        stoneTableView.setOnMouseClicked(this::handleRowSelection);
    }

    private void handleRowSelection(javafx.scene.input.MouseEvent mouseEvent) {
        Stone selectedStone = stoneTableView.getSelectionModel().getSelectedItem();
        if (selectedStone != null) {
            stoneID = selectedStone.getStoneID();
            nameField.setText(selectedStone.getName());
            descriptionField.setText(selectedStone.getDescription());
            characteristicsField.setText(selectedStone.getCharacteristics());
            googleScholarField.setText(selectedStone.getGoogleScholar());
            webField.setText(selectedStone.getWeb());
            youtubeField.setText(selectedStone.getYoutube());
            subCategoryField.setText(SubCategoryDAO.getSubCategoryByID(selectedStone.getSubCategoryID()));
            stoneImagePreview.setImage(convertByteArrayToImage(selectedStone.getImage()));
        }
    }

    public static Image convertByteArrayToImage(byte[] imageBytes) {
        if (imageBytes == null || imageBytes.length == 0) {
            // Jika array byte kosong, Anda bisa mengembalikan null atau gambar default
            return null;
        }
        // Buat InputStream dari array byte
        ByteArrayInputStream inputStream = new ByteArrayInputStream(imageBytes);

        // Buat objek Image dari InputStream
        return new Image(inputStream);
    }

    // Load all stones into the TableView
    private void loadStones() {
        stoneList = FXCollections.observableArrayList(StoneDAO.getAllStones());
        if (stoneList.isEmpty()) {
            System.out.println("No data found in database.");
        } else {
            System.out.println("Data loaded successfully: " + stoneList.size() + " entries.");
        }
        stoneTableView.setItems(stoneList);
    }

    // stone CRUD
    // CREATE: Add a New Stone
    public void createStone() throws IOException {
        String name = nameField.getText();
        String description = descriptionField.getText();
        String characteristics = characteristicsField.getText();
        String googleScholar = googleScholarField.getText();
        String web = webField.getText();
        String youtube = youtubeField.getText();
        String subCategoryName = subCategoryField.getText();
        UUID subCategoryID = SubCategoryDAO.getSubCategoryId(subCategoryName);

        Stone stone = new Stone(name, description, this.readFileToByteArray(selectedStoneImageFile), characteristics, googleScholar, web, youtube, subCategoryID);

        boolean isSuccess = StoneDAO.createStone(stone);

        if (isSuccess) {
            loadStones();  // Reload the table data
            showAlert("Success", "Data Berhasil dimasukkan!");
        } else {
            showAlert("Error", "Gagal Memasukkan Data!");
        }
        loadStones();
    }

    // UPDATE: Modify an Existing Stone
    public void updateStone() throws IOException {
        Stone selectedStone = stoneTableView.getSelectionModel().getSelectedItem();
        if (selectedStone != null) {
            String name = nameField.getText();
            String description = descriptionField.getText();
            byte[] image = imageToByteArray(stoneImagePreview.getImage());
            String characteristics = characteristicsField.getText();
            String googleScholar = googleScholarField.getText();
            String web = webField.getText();
            String youtube = youtubeField.getText();
            String subCategoryName = subCategoryField.getText();
            UUID subCategoryID = SubCategoryDAO.getSubCategoryId(subCategoryName);

            System.out.println(nameField.getText());
            System.out.println(descriptionField.getText());
            System.out.println(characteristicsField.getText());
            System.out.println(googleScholarField.getText());
            System.out.println(webField.getText());
            System.out.println(youtubeField.getText());
            System.out.println(subCategoryField.getText());
            System.out.println(subCategoryID);

            Stone updatedStone = new Stone(stoneID, name, image, description, characteristics, googleScholar, web, youtube, subCategoryID);

            boolean isSuccess = StoneDAO.updateStone(updatedStone);

            if (isSuccess) {
                loadStones();  // Reload the table data
                showAlert("Success", "Data Berhasil diupdate!");
            } else {
                showAlert("Error", "Gagal Mengupdate Data!");
            }
        }
    }

    // DELETE: Remove a Stone
    public void deleteStone() {
        Stone selectedStone = stoneTableView.getSelectionModel().getSelectedItem();
        if (selectedStone != null) {
            boolean isSuccess = StoneDAO.deleteStone(selectedStone.getName());

            if (isSuccess) {
                loadStones();  // Reload the table data
                showAlert("Success", "Data Berhasil dihapus!");
            } else {
                showAlert("Error", "Gagal Menghapus Data!");
            }
        }
    }


    // Helper method to show alert dialogs
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void openFileChoose(javafx.scene.input.MouseEvent event) throws IOException{
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        selectedStoneImageFile = fileChooser.showOpenDialog(chooseStoneImageButton.getScene().getWindow());
        if (selectedStoneImageFile != null) {
            // Optional: Display the selected image in the ImageView
            Image image = new Image(selectedStoneImageFile.toURI().toString());
            stoneImagePreview.setImage(image);
        }
    }

    private byte[] readFileToByteArray(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            return data;
        }
    }

    public static byte[] imageToByteArray(Image image) {
        byte[] imageData = null;

        try {
            // Konversi JavaFX Image menjadi BufferedImage
            BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);

            // Simpan BufferedImage ke ByteArrayOutputStream
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpg", outputStream); // Gunakan format PNG atau JPG

            // Ambil data sebagai array byte
            imageData = outputStream.toByteArray();

            // Tutup stream
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageData;
    }

    @FXML
    private void searchStone() {
        String searchQuery = searchField.getText().trim().toLowerCase();
        if (!searchQuery.isEmpty()) {
            ObservableList<Stone> filteredList = FXCollections.observableArrayList();
            for (Stone stone : stoneList) {
                if (stone.getName().toLowerCase().contains(searchQuery)) {
                    filteredList.add(stone);
                }
            }
            stoneTableView.setItems(filteredList);
        } else {
            // Jika input kosong, tampilkan semua data
            stoneTableView.setItems(stoneList);
        }
    }

    @FXML
    public void loginButton() throws IOException
    {
        Stage stage = (Stage) loginButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/view/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Main Menu");
        stage.setScene(scene);
    }
}

