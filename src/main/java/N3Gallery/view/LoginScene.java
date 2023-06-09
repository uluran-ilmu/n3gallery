package N3Gallery.view;

import java.sql.SQLException;
import java.util.Optional;

import N3Gallery.LoggedInUser;
import N3Gallery.component.InputGroup;
import N3Gallery.dao.UserDao;
import N3Gallery.model.User;
import N3Gallery.utils.Password;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginScene {
  private Scene scene = null;
  private Stage primaryStage;
  private UserDao userDao;

  public LoginScene(Stage primaryStage) {
    this.userDao = new UserDao();
    this.primaryStage = primaryStage;
    VBox container = new VBox();

    Label emailLabel = new Label("Email");
    TextField emailTf = new TextField();
    emailTf.setPromptText("name@email.com");

    Label passwordLabel = new Label("Password");
    PasswordField passwordTf = new PasswordField();
    passwordTf.setPromptText("password");

    container.setSpacing(12.0);
    container.setAlignment(Pos.CENTER);

    Alert loginAlert = new Alert(AlertType.NONE);

    Button loginButton = new Button("Login");
    loginButton.setMaxWidth(240.0);

    Button navToRegisterSceneButton = new Button("Don't have account? Create one!");
    navToRegisterSceneButton.setMaxWidth(240.0);

    container.getChildren().addAll(
        new InputGroup(emailLabel, emailTf, 4.0),
        new InputGroup(passwordLabel, passwordTf, 4.0),
        loginButton,
        navToRegisterSceneButton);

    this.scene = new Scene(container, 600, 480);

    loginButton.setOnAction(action -> {
      try {
        User user = userDao.getUserByEmail(emailTf.getText());
        if (user == null) {
          loginAlert.setAlertType(AlertType.ERROR);
          loginAlert.setContentText("Email is not registered, please proceed to register if you want to!");
          loginAlert.show();
          return;
        }

        if (!Password.equals(passwordTf.getText(), user.getPassword())) {
          loginAlert.setAlertType(AlertType.ERROR);
          loginAlert.setContentText("Wrong credentials, please try again!");
          loginAlert.show();
          return;
        }

        loginAlert.setAlertType(AlertType.INFORMATION);
        loginAlert.setContentText("Login successful!");

        LoggedInUser.getInstance().set(user);

        Optional<ButtonType> result = loginAlert.showAndWait();

        if (result.get() == ButtonType.OK) {
          loginAlert.close();
          openHomeScene();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }

    });

    navToRegisterSceneButton.setOnAction(action -> {
      openRegisterScene();
    });
  }

  public void openRegisterScene() {
    this.primaryStage.setTitle("Register");
    this.primaryStage.setScene(new RegisterScene(this.primaryStage).getScene());
    this.primaryStage.setResizable(false);
  }

  public void openHomeScene() {
    this.primaryStage.setTitle(String.format("Home [ User: %s ]", LoggedInUser.getInstance().get().getName()));
    this.primaryStage.setScene(new HomeScene(this.primaryStage).getScene());
    this.primaryStage.setResizable(false);
  }

  public Scene getScene() {
    return this.scene;
  }
}
