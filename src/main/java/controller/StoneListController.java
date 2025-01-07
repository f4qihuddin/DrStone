package controller;

import dao.StoneDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import model.Stone;

import java.io.IOException;
import java.util.ArrayList;

public class StoneListController
{
    @FXML
    private GridPane stoneList;

    @FXML
    private Button  categoryButton;

    private RootController rootController;

    private ArrayList<Stone> stones = new ArrayList<>();

     @FXML
    public void goToCategory() throws IOException
    {
        rootController.showCategories();
    }

    public void showStoneList(String categoryName)
    {
        stones.addAll(StoneDAO.getListOfStones(categoryName));

        int column = 0;
        int row = 0;

        for (int i = 0; i < stones.size(); i++) {
            AnchorPane pane = new AnchorPane();
            ImageView image = new ImageView();
            Button button = new Button();

            String stoneName = stones.get(i).getName().replace(" ", "_");
            var inputStream = CategoryController.class.getResourceAsStream("/images/" + stoneName + ".jpg");
            if (inputStream == null)
            {
                throw new IllegalArgumentException("Image file not found: " + stoneName);
            }
            image.setImage(new Image(inputStream));
            image.setFitWidth(75);
            image.setFitHeight(75);

            button.setText(stones.get(i).getName());
            button.setPrefWidth(130);
            button.setPrefHeight(25);
            button.getStyleClass().add("button-custom-list");
            button.getStyleClass().add("button-custom");
            button.setOnMouseClicked(event ->
            {
                try
                {
                    rootController.showStone(button.getText());
                }
                catch (IOException e)
                {
                    throw new RuntimeException(e);
                }
            });

            pane.setPrefHeight(150);
            pane.setPrefWidth(150);
            pane.getStyleClass().add("anchorPanes");

            pane.getChildren().add(button);
            pane.getChildren().add(image);

            AnchorPane.setTopAnchor(image, 20.0);
            AnchorPane.setLeftAnchor(image, 37.5);
            AnchorPane.setRightAnchor(image, 37.5);

            AnchorPane.setBottomAnchor(button, 15.0);
            AnchorPane.setRightAnchor(button, 10.0);
            AnchorPane.setLeftAnchor(button, 10.0);

            if (column <= 4)
            {
                stoneList.add(pane, column, row);
                column++;
            }
            else
            {
                row++;
                column = 0;
                stoneList.add(pane, column, row);
            }
        }
    }

    public void setRootController(RootController rootController)
    {
        this.rootController = rootController;
    }
}