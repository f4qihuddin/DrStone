package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable
{
    @FXML
    private BorderPane root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        try
        {
            showLearningView();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void showCategories() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/stone-category-view.fxml"));
        ScrollPane categoryView = fxmlLoader.load();

        CategoryController categoryController = fxmlLoader.getController();
        categoryController.setRootController(this);

        root.setCenter(categoryView);
    }

    public void showStoneList(String categoryName) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/stone-list-view.fxml"));
        ScrollPane stoneListView = fxmlLoader.load();

        StoneListController stoneListController = fxmlLoader.getController();
        stoneListController.showStoneList(categoryName);
        stoneListController.setRootController(this);

        root.setCenter(stoneListView);
    }

    public void showLearningView() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/learning-view.fxml"));
        AnchorPane learningView = fxmlLoader.load();

        LearningController learningController = fxmlLoader.getController();
        learningController.setRootController(this);

        root.setCenter(learningView);
    }

    public void showStone(String stoneName) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/stone-view.fxml"));
        ScrollPane stoneView = fxmlLoader.load();

        StoneController stoneController = fxmlLoader.getController();
        stoneController.showStone(stoneName);
        stoneController.setRootController(this);

        root.setCenter(stoneView);
    }

    public void showBookmark() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/bookmark-view.fxml"));
        ScrollPane bookmarkView = fxmlLoader.load();

        BookmarkController bookmarkController = fxmlLoader.getController();
        bookmarkController.setRootController(this);

        root.setCenter(bookmarkView);
    }
}
