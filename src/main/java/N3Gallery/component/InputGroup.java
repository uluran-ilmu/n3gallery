package N3Gallery.component;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class InputGroup extends VBox {
  public InputGroup(Label label, TextField textField, double spacing) {
    this.getChildren().addAll(label, textField);
    this.setSpacing(spacing);
    this.setMaxWidth(240.0);
  }

  public InputGroup(Label label, TextArea textArea, double spacing) {
    this.getChildren().addAll(label, textArea);
    this.setSpacing(spacing);
    this.setMaxWidth(240.0);
  }
}