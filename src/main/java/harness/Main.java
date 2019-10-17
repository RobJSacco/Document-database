package harness;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.sql.Sql;

public class Main extends Application {
  private static Stage primaryStage;

  public static void main(String[] args) {
    Sql.init();
    launch(args);    
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    //ClassLoader classLoader = getClass().getClassLoader();
    //FXMLLoader fxmlLoader = new FXMLLoader(classLoader.getResource("fxml/main.fxml"));
    //Parent root = fxmlLoader.load();
    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/main.fxml"));
    Scene scene = new Scene(root, 600, 570);
    this.primaryStage = primaryStage;
    primaryStage.setTitle("BudgetCalculator");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  public static Stage getPrimaryStage() {
    return primaryStage;
  }
}
