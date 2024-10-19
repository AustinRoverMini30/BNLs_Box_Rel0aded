package com.example.bnls_box_rel0aded;

import com.example.bnls_box_rel0aded.model.Leaderboard;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    static int status = 0;
    static boolean blur = false;
    static boolean dark = true;

    static Image wallpaper = new Image(Main.class.getResourceAsStream("Image/wall4.png"), 1280,720,true, true);
    static Color colorText = Color.WHITE;

    static Leaderboard leaderboard = new Leaderboard();

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("FXML/menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("BNL's Box Rel0aded : JAVA Edition");
        stage.setScene(scene);

        stage.getIcons().add(new Image(Main.class.getResourceAsStream("Image/Rel0aded_icon.png")));
        stage.setResizable(false);

        stage.show();
        status = 1;
    }

    public static void main(String[] args) {
        launch();
    }
}