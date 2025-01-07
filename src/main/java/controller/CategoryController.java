package controller;

import dao.CategoryDAO;
import dao.SubCategoryDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import model.Category;
import model.SubCategory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CategoryController implements Initializable
{
    @FXML
    private GridPane grid;
    
    @FXML
    private Button learningPageButton;
    private ArrayList<Category> categories = new ArrayList<>();
    private ArrayList<SubCategory> subCategories = new ArrayList<>();
    private RootController rootController;
    
    @FXML
    public void goToLearningPage() throws IOException
    {
        rootController.showLearningView();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        categories.addAll(CategoryDAO.getAllCategories());
        int categoryRow = 0;
        int subCategoryRow = 1;

        for (int i = 0; i < categories.size(); i++)
        {
            Button button1 = new Button();
            button1.setText(categories.get(i).getCategoryName());
            button1.setPrefHeight(50);
            button1.setPrefWidth(300);
            button1.setFont(new Font("Arial", 18));
            button1.setId(categories.get(i).getCategoryName());
            button1.getStyleClass().add("button-custom");  // Add style class
            button1.setOnMouseClicked(event -> toggleSubCategories(button1));
            grid.add(button1, 0, categoryRow);
            categoryRow = categoryRow + 2;

            subCategories.addAll(SubCategoryDAO.getSubCategories(categories.get(i).getCategoryName()));
            VBox vBox = new VBox();

            for (int j = 0; j < subCategories.size(); j++)
            {
                Button button2 = new Button();
                button2.setText(subCategories.get(j).getName());
                button2.setPrefHeight(35);
                button2.setPrefWidth(250);
                button2.setFont(new Font("Arial", 15));
                button2.setId(subCategories.get(j).getName());
                button2.getStyleClass().add("button-custom");  // Add style class for subcategory buttons
                button2.setOnMouseClicked(event -> {
                    try {
                        rootController.showStoneList(button2.getId());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

                vBox.getChildren().add(button2);
            }
            vBox.setVisible(false);
            vBox.setManaged(false);
            vBox.setId("subCategoriesID");
            vBox.setAlignment(Pos.CENTER);
            vBox.setSpacing(15);
            grid.add(vBox, 0, subCategoryRow);
            subCategoryRow = subCategoryRow + 2;
            subCategories.removeAll(subCategories);
        }
    }


    public void toggleSubCategories(Button clickedButton)
    {
        Integer rowIndex = GridPane.getRowIndex(clickedButton) + 1;

        if (!grid.getChildren().get(rowIndex).isManaged() && !grid.getChildren().get(rowIndex).isVisible())
        {
            grid.getChildren().get(rowIndex).setVisible(true);
            grid.getChildren().get(rowIndex).setManaged(true);
        }
        else
        {
            grid.getChildren().get(rowIndex).setVisible(false);
            grid.getChildren().get(rowIndex).setManaged(false);
        }
    }

    public void setRootController(RootController rootController)
    {
        this.rootController = rootController;
    }
}