package controller;

import dao.BookmarkDAO;
import dao.StoneDAO;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import model.Card;
import model.Session;
import model.Stone;
import model.User;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;

public class StoneController {
    @FXML
    private Text characteristics;

    @FXML
    private Text description;

    @FXML
    private ImageView stoneImage;

    @FXML
    private Text stoneName;

    @FXML
    private Text subCategory;

    @FXML
    private Hyperlink youtubeLink;

    @FXML
    private Hyperlink googleLink;

    @FXML
    private Hyperlink webLink;

    @FXML
    private Button bookmark;

    @FXML
    private AnchorPane dialogBox;

    @FXML
    private TextField bookmarkName;

    @FXML
    private Button saveButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button backButton;

    @FXML
    private Text popUpText;

    private RootController rootController;

    String googleScholarURI;

    String youtubeURI;

    String webURI;

    public User currentUser = Session.getInstance().getUser();

    Stone stone;

    public void showStone(String name)
    {
        stone = new Stone(StoneDAO.searchStone(name).getStoneID(), StoneDAO.searchStone(name).getName(), StoneDAO.searchStone(name).getImage(), StoneDAO.searchStone(name).getDescription(), StoneDAO.searchStone(name).getCharacteristics(), StoneDAO.searchStone(name).getGoogleScholar(), StoneDAO.searchStone(name).getWeb(), StoneDAO.searchStone(name).getYoutube(), StoneDAO.searchStone(name).getSubCategory());

        stoneName.setText(stone.getName());
        characteristics.setText(stone.getCharacteristics());
        description.setText(stone.getDescription());
        subCategory.setText(stone.getSubCategory());

        byte[] imageData = StoneDAO.getImage(stone.getName());
        if (imageData != null)
        {
            Image image = new Image(new ByteArrayInputStream(imageData));
            stoneImage.setImage(image);
        }
        else
        {
            System.err.println("Gambar untuk " + stoneName.getText() + " tidak ditemukan.");
            var inputStream = Card.class.getResourceAsStream("/images/default_image.png");
            if (inputStream == null)
            {
                throw new IllegalArgumentException("Image file not found");
            }
            stoneImage.setImage(new Image(inputStream));
        }

        webLink.setText("Referensi Website");
        youtubeLink.setText("Referensi Youtube");
        googleLink.setText("Referensi Google");

        webURI = stone.getWeb();
        youtubeURI = stone.getYoutube();
        googleScholarURI = stone.getGoogleScholar();
    }

    public void setRootController(RootController rootController)
    {
        this.rootController = rootController;
    }

    public void goToGoogleScholar(ActionEvent event)
    {
        try
        {
            if (googleScholarURI != null)
            {
                googleScholarURI = googleScholarURI.trim();
                Desktop.getDesktop().browse(new URI(googleScholarURI));
            }
            else
            {
                popUpText.setText("Link tidak tersedia");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void goToWebsite(ActionEvent event)
    {
        try
        {
            if (webURI != null)
            {
                webURI = webURI.trim();
                Desktop.getDesktop().browse(new URI(webURI));
            }
            else
            {
                popUpText.setText("Link tidak tersedia");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void goToYoutube(ActionEvent event) {
        try
        {
            if (youtubeURI != null)
            {
                youtubeURI = youtubeURI.trim();
                Desktop.getDesktop().browse(new URI(youtubeURI));
            }
            else
            {
                popUpText.setText("Link tidak tersedia");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void saveBookmark() throws IOException
    {
        boolean isBookmarked = BookmarkDAO.isBookmarked(currentUser.getUserID(), stone.getStoneID());
        if (!isBookmarked)
        {
            BookmarkDAO.addBookmark(bookmarkName.getText(), currentUser.getUserID(), stone.getStoneID());
            popUpText.setText("Bookmark berhasil tersimpan!");
            PauseTransition pause = new PauseTransition(Duration.seconds(2));
            pause.setOnFinished(event -> {
                popUpText.setText("");
            });
            pause.play();
        }
        else
        {
            popUpText.setText("Halaman sudah dibookmark!");
            PauseTransition pause = new PauseTransition(Duration.seconds(2));
            pause.setOnFinished(event -> {
                popUpText.setText("");
            });
            pause.play();
        }
    }

    public void bookmarkPage()
    {
        bookmarkName.setText(stoneName.getText());

        if (!dialogBox.isVisible())
        {
            dialogBox.setVisible(true);
        }
        else
        {
            dialogBox.setVisible(false);
        }
    }

    public void closeDialogBox()
    {
        dialogBox.setVisible(false);
    }

    public void backToLearningMenu()
    {
        try
        {
            rootController.showLearningView();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
