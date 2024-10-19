package com.example.bnls_box_rel0aded;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.bnls_box_rel0aded.Main.blur;
import static com.example.bnls_box_rel0aded.Main.dark;

public class aboutController implements Initializable {

    @FXML
    private ImageView returnButton;
    @FXML
    private ImageView wallpaperView;

    @FXML
    private Label titlePart1;
    @FXML
    private Label titlePart2;
    @FXML
    private Label aboutText;
    @FXML
    private Label moreText;

    @FXML
    private ImageView darkBackground;

    @FXML
    void BNLCliked(MouseEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://youtu.be/mxEVjy8BXr0"));
    }

    @FXML
    void returnClick(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("FXML/menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage temp = (Stage) returnButton.getScene().getWindow();
        temp.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        wallpaperView.setImage(Main.wallpaper);
        titlePart1.setTextFill(Main.colorText);
        titlePart2.setTextFill(Main.colorText);
        aboutText.setTextFill(Main.colorText);
        moreText.setTextFill(Main.colorText);

        if (dark){
            darkBackground.setImage(new Image(Main.class.getResourceAsStream("Image/Dark Back.png")));
        }

        if (blur){
            wallpaperView.setEffect(new GaussianBlur(20));
        }
    }
}
