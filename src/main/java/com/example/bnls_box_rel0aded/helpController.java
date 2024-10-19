package com.example.bnls_box_rel0aded;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class helpController implements Initializable {
    @FXML
    private ImageView wallpaperView;

    @FXML
    private Label helpText1;

    @FXML
    private Label helpText2;

    @FXML
    private Label helpText3;

    @FXML
    private Label helpText4;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        wallpaperView.setImage(Main.wallpaper);

        helpText1.setTextFill(Main.colorText);
        helpText2.setTextFill(Main.colorText);
        helpText3.setTextFill(Main.colorText);
        helpText4.setTextFill(Main.colorText);
    }
}
