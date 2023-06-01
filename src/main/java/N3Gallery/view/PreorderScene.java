package N3Gallery.view;

import N3Gallery.LoggedInUser;
import N3Gallery.component.InputGroup;
import N3Gallery.model.Product;
import N3Gallery.utils.Formatter;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class PreorderScene {
  private Scene scene = null;
  private Stage primaryStage = null;
  private Product product = null;

  public PreorderScene(Stage primaryStage, Product product) {
    this.primaryStage = primaryStage;
    this.product = product;

    VBox bodyContainer = new VBox();
    bodyContainer.setSpacing(60.0);
    bodyContainer.setAlignment(Pos.TOP_CENTER);
    bodyContainer.setPadding(new Insets(24));

    Button backButton = new Button("Back to Home");
    backButton.setOnAction(action -> {
      openHomeScene();
    });

    HBox mainContainer = new HBox();
    mainContainer.setAlignment(Pos.CENTER);
    mainContainer.setSpacing(160.0);

    mainContainer.getChildren().addAll(this.getProductDetailsSection(), this.getPreorderFormSection());

    bodyContainer.getChildren().addAll(backButton, mainContainer);

    this.scene = new Scene(bodyContainer, 900.0, 640.0);
  }

  private VBox getProductDetailsSection() {
    VBox container = new VBox();
    container.setSpacing(32.0);
    container.setAlignment(Pos.CENTER_LEFT);

    ImageView image = new ImageView(product.getImageLink());
    image.setFitWidth(270.0);
    image.setFitHeight(270.0);

    DropShadow dropShadow = new DropShadow();
    dropShadow.setHeight(8.0);
    dropShadow.setWidth(8.0);
    dropShadow.setColor(Color.GREY);
    dropShadow.setBlurType(BlurType.GAUSSIAN);
    image.setEffect(dropShadow);

    VBox detailsContainer = new VBox();
    detailsContainer.setSpacing(10.0);

    Label nameLabel = new Label(String.format("[%s] %s", product.getBrand().getName(), product.getName()));
    nameLabel.setFont(Font.font(null, FontWeight.BOLD, 14.0));
    nameLabel.setMaxWidth(300.0);
    nameLabel.setWrapText(true);

    Label brandLabel = new Label(String.format("Brand: %s", product.getBrand().getName()));
    brandLabel.setFont(Font.font(14.0));

    Label availLabel = new Label(
        String.format("Availability: %s", product.isAvailable() ? "Available" : "Not Available"));
    availLabel.setFont(Font.font(14.0));

    Label priceLabel = new Label(String.format("Price: %s", Formatter.formatRupiah(product.getPrice())));
    priceLabel.setFont(Font.font(14.0));

    detailsContainer.getChildren().addAll(
        nameLabel,
        brandLabel,
        availLabel,
        priceLabel);

    container.getChildren().addAll(image, detailsContainer);

    return container;
  }

  private VBox getPreorderFormSection() {
    VBox container = new VBox();

    Label phoneNumberLabel = new Label("Phone number");
    TextField phoneNumberTf = new TextField();
    phoneNumberTf.setPromptText("Phone number");

    Label provinceLabel = new Label("Province");
    TextField provinceTf = new TextField();
    provinceTf.setPromptText("Province");

    Label cityLabel = new Label("City");
    TextField cityTf = new TextField();
    cityTf.setPromptText("City");

    Label addressLabel = new Label("Address");
    TextArea addressTa = new TextArea();
    addressTa.setPromptText("Street address");

    container.setSpacing(12.0);
    container.setAlignment(Pos.CENTER);

    Button preorderButton = new Button("Preorder");
    preorderButton.setMaxWidth(240.0);

    container.getChildren().addAll(
        new InputGroup(phoneNumberLabel, phoneNumberTf, 4.0),
        new InputGroup(provinceLabel, provinceTf, 4.0),
        new InputGroup(cityLabel, cityTf, 4.0),
        new InputGroup(addressLabel, addressTa, 4.0),
        preorderButton);

    container.setPrefWidth(270.0);
    
    return container;
  }

  private void openHomeScene() {
    this.primaryStage.setTitle(String.format("Home [ User: %s ]", LoggedInUser.getInstance().get().getName()));
    this.primaryStage.setScene(new HomeScene(this.primaryStage).getScene());
    this.primaryStage.setResizable(false);
  }

  public Scene getScene() {
    return this.scene;
  }
}
