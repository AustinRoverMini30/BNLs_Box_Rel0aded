package com.example.bnls_box_rel0aded;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.bnls_box_rel0aded.Main.status;

public class menuController implements Initializable {

    @FXML
    private Label gameLabel;
    @FXML
    private Label settingsLabel;
    @FXML
    private Label aboutLabel;
    @FXML
    private Label quitLabel;

    @FXML
    private ImageView wallpaperView;

    @FXML
    private MediaView animationScreen;

    @FXML
    void playClick(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("FXML/config.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage temp = (Stage) aboutLabel.getScene().getWindow();
        temp.setScene(scene);
    }

    @FXML
    void paramClick(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("FXML/settings.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage temp = (Stage) aboutLabel.getScene().getWindow();
        temp.setScene(scene);
    }

    @FXML
    void aboutClick(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("FXML/about.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage temp = (Stage) aboutLabel.getScene().getWindow();
        temp.setScene(scene);

    }

    @FXML
    void quitClick(MouseEvent event) {
        Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        gameLabel.setTextFill(Main.colorText);
        settingsLabel.setTextFill(Main.colorText);
        aboutLabel.setTextFill(Main.colorText);
        quitLabel.setTextFill(Main.colorText);

        wallpaperView.setImage(Main.wallpaper);

        Media miniPicAnimation = new Media((Main.class.getResource("Video/MINI Picture.mp4")).toString());
        MediaPlayer miniPicAnimationPlayer = new MediaPlayer(miniPicAnimation);

        Media bnlAnimation = new Media((Main.class.getResource("Video/BNL Opening.mp4")).toString());
        MediaPlayer bnlAnimationPlayer = new MediaPlayer(bnlAnimation);

        if (status == 0){
            animationScreen.setMediaPlayer(miniPicAnimationPlayer);
        }
        else {
            animationScreen.setVisible(false);
        }

        gameLabel.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                gameLabel.setFont(Font.font(30));
            }
        });

        gameLabel.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                gameLabel.setFont(Font.font(24));
            }
        });

        gameLabel.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                gameLabel.setFont(Font.font(30));
            }
        });

        gameLabel.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                gameLabel.setFont(Font.font(24));
            }
        });

        settingsLabel.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                settingsLabel.setFont(Font.font(30));
            }
        });

        settingsLabel.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                settingsLabel.setFont(Font.font(24));
            }
        });

        aboutLabel.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                aboutLabel.setFont(Font.font(30));
            }
        });

        aboutLabel.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                aboutLabel.setFont(Font.font(24));
            }
        });

        quitLabel.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                quitLabel.setFont(Font.font(30));
            }
        });

        quitLabel.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                quitLabel.setFont(Font.font(24));
            }
        });

        if (status == 0) {

            miniPicAnimationPlayer.play();

            miniPicAnimationPlayer.setOnEndOfMedia(new Runnable() {
                @Override
                public void run() {
                    animationScreen.setMediaPlayer(bnlAnimationPlayer);
                    bnlAnimationPlayer.play();
                }
            });

            bnlAnimationPlayer.setOnEndOfMedia(new Runnable() {
                @Override
                public void run() {
                    animationScreen.setVisible(false);
                }
            });

            animationScreen.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    animationScreen.getMediaPlayer().dispose();
                    animationScreen.setVisible(false);
                }
            });

        }
    }
}
