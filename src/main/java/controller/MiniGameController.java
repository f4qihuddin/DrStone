package controller;

import dao.MiniGameDataDAO;
import dao.StoneDAO;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class MiniGameController implements Initializable
{

    @FXML
    private FlowPane board;

    private ArrayList<Card> cardsOnBoard;

    private int numOfGuesses;

    private int numOfMatches;

    private Card card1, card2;

    @FXML
    private ImageView card;

    @FXML
    private Label correctGuesses;

    @FXML
    private Label guesses;

    @FXML
    private Label timerLabel;

    @FXML
    private Button backButton;

    @FXML
    private AnchorPane parentStage;

    private boolean isGameCompleted = false;

    private Timeline timer;

    private int roundedScore;

    public User currentUser = Session.getInstance().getUser();

    @FXML
    public void goToMainMenu() throws IOException
    {
        timer.stop();
        Stage stage = (Stage) backButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/view/mini-game-menu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Main Menu");
        stage.setScene(scene);
    }

    @FXML
    void playAgain(ActionEvent actionevent)
    {
        card1 = null;
        card2 = null;
        numOfMatches = 0;
        numOfGuesses = 0;
        isGameCompleted = false;

        updateLabels();

        int duration = 60;

        timerLabel.setText("Waktu : " + duration);

        CardDeck deck = new CardDeck();
        ArrayList<String> stoneNames = new ArrayList<>();

        stoneNames.addAll(StoneDAO.getListOfNames());

        for (int i = 0; i < stoneNames.size(); i++)
        {
            deck.addCardToDeck(new Card(stoneNames.get(i), stoneNames.get(i).replace(" ", "_")));
        }

        deck.shuffle();

        cardsOnBoard = new ArrayList<>();

        for (int i = 0; i < board.getChildren().size()/2; i++)
        {
            Card cardTaken = deck.takeTopCard();
            cardsOnBoard.add(new ImageCard(cardTaken.getName(), cardTaken.getFileName()));
            cardsOnBoard.add(new TextCard(cardTaken.getName(), cardTaken.getFileName()));
        }
        Collections.shuffle(cardsOnBoard);

        initializeCardView();

        timer = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            int currentTime = Integer.parseInt(timerLabel.getText().replace("Waktu : ", ""));
            if (currentTime > 0)
            {
                timerLabel.setText("Waktu : " + (currentTime - 1));

                if (numOfMatches == cardsOnBoard.size()/2)
                {
                    isGameCompleted = true;
                }

                if (isGameCompleted)
                {
                    float score = ((float)numOfMatches/(float)numOfGuesses) * 100;
                    roundedScore = Math.round(score);
                    timer.stop();
                    showWinDialog();
                    saveGameData(currentUser.getUserID(), roundedScore);
                }
            }
            else
            {
                timer.stop();
                showLoseDialog();
                saveGameData(currentUser.getUserID(), 0);
            }
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        int duration = 60;

        timerLabel.setText("Waktu : " + duration);

        CardDeck deck = new CardDeck();
        ArrayList<String> stoneNames = new ArrayList<>();

        stoneNames.addAll(StoneDAO.getListOfNames());

        for (int i = 0; i < stoneNames.size(); i++)
        {
            deck.addCardToDeck(new Card(stoneNames.get(i), stoneNames.get(i).replace(" ", "_")));
        }

        deck.shuffle();

        cardsOnBoard = new ArrayList<>();

        for (int i = 0; i < board.getChildren().size()/2; i++)
        {
            Card cardTaken = deck.takeTopCard();
            cardsOnBoard.add(new ImageCard(cardTaken.getName(), cardTaken.getFileName()));
            cardsOnBoard.add(new TextCard(cardTaken.getName(), cardTaken.getFileName()));
        }
        Collections.shuffle(cardsOnBoard);

        initializeCardView();

        timer = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            int currentTime = Integer.parseInt(timerLabel.getText().replace("Waktu : ", ""));
            if (currentTime > 0)
            {
                timerLabel.setText("Waktu : " + (currentTime - 1));

                if (numOfMatches == cardsOnBoard.size()/2)
                {
                    isGameCompleted = true;
                }

                if (isGameCompleted)
                {
                    float score = 0;

                    if (numOfMatches == 5)
                    {
                        score = ((float)numOfMatches/(float)numOfGuesses) * 100;
                    }
                    else if (numOfMatches == 7)
                    {
                        score = ((float)numOfMatches/(float)numOfGuesses) * 1000;
                    }
                    else
                    {
                        score = ((float)numOfMatches/(float)numOfGuesses) * 10000;
                    }
                    roundedScore = Math.round(score);
                    timer.stop();
                    showWinDialog();
                    saveGameData(currentUser.getUserID(), roundedScore);
                }
            }
            else
            {
                timer.stop();
                showLoseDialog();
                saveGameData(currentUser.getUserID(), 0);
            }
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    private void initializeCardView()
    {
        for (int i = 0; i < board.getChildren().size(); i++)
        {
            ImageView card = (ImageView) board.getChildren().get(i);
            card.setImage(new Image(Card.class.getResourceAsStream("/images/Card_Back.jpg")));
            card.setUserData(i);

            card.setOnMouseClicked(event ->
            {
                flipCard((int) card.getUserData());
            });
        }
    }

    private void flipCard(int indexOfCard)
    {
        if (card1 == null && card2 == null)
        {
            flipAllCards();
        }
        ImageView imageView = (ImageView) board.getChildren().get(indexOfCard);

        if (card1 == null)
        {
            card1 = cardsOnBoard.get(indexOfCard);
            imageView.setImage(card1.getImage());
        }
        else if (card2 == null)
        {
            numOfGuesses++;
            card2 = cardsOnBoard.get(indexOfCard);
            imageView.setImage(card2.getImage());
            checkForMatch();
            updateLabels();
        }
    }

    private void updateLabels()
    {
        correctGuesses.setText(Integer.toString(numOfMatches));
        guesses.setText(Integer.toString(numOfGuesses));
    }

    private void flipAllCards()
    {
        for (int i = 0; i < cardsOnBoard.size(); i++)
        {
            ImageView imageView = (ImageView) board.getChildren().get(i);

            if (cardsOnBoard.get(i).isMatched())
            {
                imageView.setImage(cardsOnBoard.get(i).getMatchedImage());
            }
            else
            {
                imageView.setImage(cardsOnBoard.get(i).getCardBack());
            }
        }
    }

    private void checkForMatch()
    {
        if (card1.isSameCard(card2))
        {
            card1.setMatched(true);
            card2.setMatched(true);

            flipAllCards();

            numOfMatches++;
        }
        card1 = null;
        card2 = null;
    }

    private void showWinDialog()
    {
        Platform.runLater(() ->
        {
            Stage dialog = new Stage();
            dialog.initStyle(StageStyle.UNDECORATED);
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initStyle(StageStyle.TRANSPARENT);
            dialog.centerOnScreen();

            Button playAgain = new Button("Main Lagi");
            Button exit = new Button("Keluar");
            playAgain.getStylesheets().add(getClass().getResource("/view/style.css").toExternalForm());
            exit.getStylesheets().add(getClass().getResource("/view/style.css").toExternalForm());

            HBox buttonBox = new HBox(20, playAgain, exit);
            buttonBox.setAlignment(Pos.CENTER);

            playAgain.setOnAction(event ->
            {
                dialog.close();
                playAgain(event);
            });

            exit.setOnAction(event ->
            {
                dialog.close();
                Stage stage = (Stage) exit.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(MiniGameMenuController.class.getResource("/view/mini-game-menu-view.fxml"));
                Scene scene;
                try
                {
                    scene = new Scene(fxmlLoader.load());
                    stage.setTitle("Mini Game Menu");
                    stage.setScene(scene);
                    stage.show();
                }
                catch (IOException e)
                {
                    throw new RuntimeException(e);
                }
            });

            VBox content = new VBox(20);

            Label statusLabel = new Label("Kamu Menang!");
            statusLabel.setStyle("-fx-font-family: 'System';" +
                    "-fx-font-size: 16px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-text-fill: #000000;");

            Label scoreLabel = new Label("Skor : " + roundedScore);
            scoreLabel.setStyle("-fx-font-family: 'System';" +
                    "-fx-font-size: 16px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-text-fill: #000000;");

            content.setAlignment(Pos.CENTER);
            content.getChildren().add(statusLabel);
            content.getChildren().add(scoreLabel);
            content.getChildren().add(buttonBox);
            content.setPrefHeight(200);
            content.setPrefWidth(300);
            content.setStyle("-fx-background-color: #eeef20; -fx-border-radius: 40px; -fx-background-radius: 40px;");

            Scene dialogScene = new Scene(content);
            dialogScene.setFill(Color.TRANSPARENT);
            dialog.setScene(dialogScene);
            dialog.showAndWait();
        });
    }

    private void showLoseDialog()
    {
        Platform.runLater(() ->
        {
            Stage dialog = new Stage();
            dialog.initStyle(StageStyle.UNDECORATED);
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initStyle(StageStyle.TRANSPARENT);
            dialog.centerOnScreen();

            Button playAgain = new Button("Main Lagi");
            Button exit = new Button("Keluar");
            playAgain.getStylesheets().add(getClass().getResource("/view/style.css").toExternalForm());
            exit.getStylesheets().add(getClass().getResource("/view/style.css").toExternalForm());
            HBox buttonBox = new HBox(20, playAgain, exit);
            buttonBox.setAlignment(Pos.CENTER);

            playAgain.setOnAction(event ->
            {
                dialog.close();
                playAgain(event);
            });

            exit.setOnAction(event ->
            {
                dialog.close();
                Stage stage = (Stage) exit.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(MiniGameMenuController.class.getResource("/view/mini-game-menu-view.fxml"));
                Scene scene;
                try
                {
                    scene = new Scene(fxmlLoader.load());
                    stage.setTitle("Mini Game Menu");
                    stage.setScene(scene);
                    stage.show();
                }
                catch (IOException e)
                {
                    throw new RuntimeException(e);
                }
            });

            VBox content = new VBox(20);

            Label statusLabel = new Label("Kamu Kalah!");
            statusLabel.setStyle("-fx-font-family: 'System';" +
                    "-fx-font-size: 16px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-text-fill: #000000;");

            content.setAlignment(Pos.CENTER);
            content.getChildren().add(statusLabel);
            content.getChildren().add(buttonBox);
            content.setPrefHeight(200);
            content.setPrefWidth(300);
            content.setStyle("-fx-background-color: #d90429; -fx-border-radius: 20px; -fx-background-radius: 20px;");

            Scene dialogScene = new Scene(content);
            dialogScene.setFill(Color.TRANSPARENT);
            dialog.setScene(dialogScene);
            dialog.showAndWait();
        });
    }

    public static void saveGameData(UUID userID, int newHighestScore)
    {
        MiniGameData currentData;

        int totalPlayed;
        int highestScore;

        MiniGameData oldMiniGameData = MiniGameDataDAO.getMiniGameData(userID);

        if(oldMiniGameData == null)
        {
            currentData = new MiniGameData(1, newHighestScore, userID);
            MiniGameDataDAO.insertMiniGameData(currentData);
        }
        else
        {
            totalPlayed = oldMiniGameData.getTotalPlayed();
            highestScore = oldMiniGameData.getHighestScore();

            if (newHighestScore > highestScore)
            {
                currentData = new MiniGameData(totalPlayed + 1, newHighestScore, userID);
            }
            else
            {
                currentData = new MiniGameData(totalPlayed + 1, highestScore, userID);
            }
            MiniGameDataDAO.updateMiniGameData(currentData, userID);
        }
    }
}
