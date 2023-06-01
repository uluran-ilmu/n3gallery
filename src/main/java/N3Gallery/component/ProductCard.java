package N3Gallery.component;

import N3Gallery.model.Product;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class ProductCard extends Pane {
  public ProductCard(Product product) {
    setMaxWidth(200.0);
    setPrefWidth(200.0);
    setMaxHeight(280.0);
    setPrefHeight(280.0);
    setStyle("-fx-background-color: #FFF; -fx-border-radius: 8px; -fx-background-radius: 8px;");

    DropShadow dropShadow = new DropShadow();
    dropShadow.setHeight(8.0);
    dropShadow.setWidth(8.0);
    dropShadow.setColor(Color.GREY);
    dropShadow.setBlurType(BlurType.GAUSSIAN);

    setEffect(dropShadow);

    ImageView image = new ImageView(product.getImageLink());
    image.setFitWidth(180.0);
    image.setFitHeight(180.0);
    image.setLayoutX(10.0);
    image.setLayoutY(10.0);
    image.setStyle("-fx-border-radius: 8px; -fx-background-radius: 8px;");

    Label name = new Label("[" + product.getBrand().getName() + "] " + product.getName());
    name.setFont(Font.font(12.0));
    name.setTextAlignment(TextAlignment.CENTER);
    name.setWrapText(true);
    name.setMaxWidth(180.0);
    name.setLayoutX(10.0);
    name.setLayoutY(204.0);

    getChildren().addAll(image, name);
  }
}
