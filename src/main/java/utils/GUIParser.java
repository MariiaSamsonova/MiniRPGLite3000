package utils;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//import rpg.*;

import java.io.IOException;

public class GUIParser extends Application {//TODO

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root  = FXMLLoader.load(getClass().getResource("GUI.fxml"));
        primaryStage.setTitle("MiniRPGLite300");
        primaryStage.setScene(new Scene(root, 300, 175));
        primaryStage.show();
    }
}
