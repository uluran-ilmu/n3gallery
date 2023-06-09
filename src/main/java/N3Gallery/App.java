/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package N3Gallery;

import N3Gallery.utils.Seeder;
import N3Gallery.view.LoginScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    public App() {
        DB.connect();
        new Seeder().run();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new LoginScene(primaryStage).getScene());
        primaryStage.setTitle("Login");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
