package model;

import javafx.scene.image.Image;

public class TextCard extends Card
{

    public TextCard(String name, String fileName) {
        super(name, fileName);
        this.setImage(fileName);
    }
    @Override
    public Image getImage()
    {
        return image;
    }

    public void setImage(String fileName)
    {
        var inputStream = Card.class.getResourceAsStream("/images/" + fileName + "_Text_Card.jpg");
        if (inputStream == null) {
            throw new IllegalArgumentException("Image file not found: " + fileName);
        }
        this.image = new Image(inputStream);
    }
}
