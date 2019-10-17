package controller;

import harness.Main;
import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;


public class Controller {
  
  private static File file;
  @FXML public Label fileName;
  @FXML public TextField newTag;
  
  @FXML public void fileFinder() {
    FileChooser fileChooser = new FileChooser();
    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
    fileChooser.getExtensionFilters().add(extFilter);
    file = fileChooser.showOpenDialog(Main.getPrimaryStage());
    System.out.println(file);
    fileName.setText(file.getName());    
  }
  
  @FXML public void checkTag() {

  }
}
