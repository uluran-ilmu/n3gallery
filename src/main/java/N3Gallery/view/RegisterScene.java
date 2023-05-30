package N3Gallery.view;

import java.sql.SQLException;

import N3Gallery.component.InputGroup;
import N3Gallery.dao.UserDao;
import N3Gallery.model.User;
import N3Gallery.utils.Password;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class RegisterScene {
  private Scene scene = null;
  private Stage primaryStage = null;
  private UserDao userDao;

  public RegisterScene(Stage primaryStage) {
      this.primaryStage = primaryStage;
      this.userDao = new UserDao();
      VBox container = new VBox();

      Label nameLabel = new Label("Full name");
      TextField nameTf = new TextField();
      nameTf.setPromptText("Full name");

      Label emailLabel = new Label("Email");
      TextField emailTf = new TextField();
      emailTf.setPromptText("name@email.com");

      Label passwordLabel = new Label("Password");
      PasswordField passwordTf = new PasswordField();
      passwordTf.setPromptText("password");

      container.setSpacing(12.0);
      container.setAlignment(Pos.CENTER);

      Alert registrationAlert = new Alert(AlertType.NONE);

      Button registerButton = new Button("Register");
      registerButton.setMaxWidth(240.0);

      Button navToLoginSceneButton = new Button("Already have account? Login!");
      navToLoginSceneButton.setMaxWidth(240.0);

      container.getChildren().addAll(
              InputGroup.group(nameLabel, nameTf, 4.0),
              InputGroup.group(emailLabel, emailTf, 4.0),
              InputGroup.group(passwordLabel, passwordTf, 4.0),
              registerButton,
              navToLoginSceneButton);

      this.scene = new Scene(container, 600, 480);

      registerButton.setOnAction(action -> {
          try {
              User user = new User(nameTf.getText(), emailTf.getText(), Password.hash(passwordTf.getText()));

              if (userDao.getUserByEmail(emailTf.getText()) != null) {
                  registrationAlert.setAlertType(AlertType.ERROR);
                  registrationAlert
                          .setContentText("Email is registered before. Please proceed to login using that email!");
                  registrationAlert.show();
                  return;
              }

              userDao.create(user);

              registrationAlert.setAlertType(AlertType.INFORMATION);
              registrationAlert
                      .setContentText("Your account has been register successfully. Please proceed to login");
              registrationAlert.show();

              openLoginScene();
          } catch (SQLException e) {
              e.printStackTrace();
              registrationAlert.setContentText("Something wrong when register, please try again!");
              registrationAlert.show();
          }
      });

      navToLoginSceneButton.setOnAction(action -> {
          openLoginScene();
      });
  }

  private void openLoginScene() {
      this.primaryStage.setTitle("Login");
      this.primaryStage.setScene(new LoginScene(primaryStage).getScene());
  }

  public Scene getScene() {
      return this.scene;
  }
}
