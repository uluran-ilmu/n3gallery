package N3Gallery.view;

import java.sql.SQLException;
import java.util.ArrayList;

import N3Gallery.component.ProductCard;
import N3Gallery.dao.ProductDao;
import N3Gallery.model.Product;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HomeScene {
  private Scene scene = null;
  private Stage primaryStage = null;

  public HomeScene(Stage primaryStage) {
    this.primaryStage = primaryStage;
    ProductDao productDao = new ProductDao();

    ScrollPane scrollable = new ScrollPane();

    GridPane container = new GridPane();
    container.setAlignment(Pos.TOP_CENTER);
    container.setHgap(12.0);
    container.setVgap(24.0);
    container.setPadding(new Insets(24));

    scrollable.setContent(container);
    scrollable.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);

    this.scene = new Scene(scrollable, 900.0, 640.0);

    try {
      ArrayList<Product> products = productDao.getProducts();
      for (int i = 0; i < products.size(); i++) {
        Product product = products.get(i);
        ProductCard productCard = new ProductCard(product);
        productCard.setOnMouseClicked(action -> {
          openPreorderScene(product);
        });

        container.add(productCard, i % 4, i / 4);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private void openPreorderScene(Product product) {
    this.primaryStage.setScene(new PreorderScene(this.primaryStage, product).getScene());
    this.primaryStage.setTitle(String.format("Product Preorder [ %s - %s ]", product.getBrand().getName(), product.getName()));
    this.primaryStage.setResizable(false);
  }

  public Scene getScene() {
    return scene;
  }
}
