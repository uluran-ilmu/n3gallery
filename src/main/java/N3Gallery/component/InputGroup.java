package N3Gallery.component;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class InputGroup {
  public static VBox group(Label label, TextField textField, double spacing) {
      VBox container = new VBox();
      container.getChildren().addAll(label, textField);
      container.setSpacing(spacing);
      container.setMaxWidth(240.0);

      return container;
  }
}