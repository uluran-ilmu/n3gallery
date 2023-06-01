package N3Gallery.view;

import N3Gallery.model.Product;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PreorderScene {
  private Scene scene = null;
  private Stage primaryStage = null;

  public PreorderScene(Stage primaryStage, Product product) {
    this.primaryStage = primaryStage;
    
    HBox container = new HBox();
    container.setAlignment(Pos.CENTER);
    container.setSpacing(80.0);

    container.getChildren().addAll(new Label(product.getName()));

    this.scene = new Scene(container, 900.0, 640.0);
  }

  public Scene getScene() {
    return this.scene;
  }
}
