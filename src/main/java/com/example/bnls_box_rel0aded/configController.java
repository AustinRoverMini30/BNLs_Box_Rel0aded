package com.example.bnls_box_rel0aded;

import com.example.bnls_box_rel0aded.model.Computer;
import com.example.bnls_box_rel0aded.model.Human;
import com.example.bnls_box_rel0aded.model.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.bnls_box_rel0aded.Main.*;

public class configController implements Initializable {

    Player player1;
    Player player2;

    @FXML
    private TextField fieldPlayer1;

    @FXML
    private TextField fieldPlayer2;

    @FXML
    private ImageView imagePlayer1;

    @FXML
    private ImageView imagePlayer2;

    @FXML
    private ImageView imagePicker1;

    @FXML
    private ImageView imagePicker2;

    @FXML
    private RadioButton computer1;

    @FXML
    private RadioButton computer2;

    @FXML
    private RadioButton human1;

    @FXML
    private RadioButton human2;

    @FXML
    private HBox computerOption1;

    @FXML
    private HBox computerOption2;

    @FXML
    private RadioButton optionClever1;

    @FXML
    private RadioButton optionClever2;

    @FXML
    private RadioButton optionCrazy1;

    @FXML
    private RadioButton optionCrazy2;

    @FXML
    private Button playButton;

    @FXML
    private RadioButton turnPlayer1;

    @FXML
    private RadioButton turnPlayer2;

    @FXML
    private RadioButton turnPlayerAlea;

    @FXML
    private Label numberSquare;

    @FXML
    private Slider sliderSquare;

    @FXML
    private ImageView wallpaperView;

    @FXML
    private Label numberTitle;

    @FXML
    private Label playerTitle1;

    @FXML
    private Label playerTitle2;

    @FXML
    private Label typePlayerHumanComput1;

    @FXML
    private Label typePlayerHumanComput2;

    @FXML
    private Label typeComput1;

    @FXML
    private Label typeComput2;

    String pathImagePlayer1;
    String pathImagePlayer2;

    final ToggleGroup toggleHumanComputer1 = new ToggleGroup();
    final ToggleGroup toggleHumanComputer2 = new ToggleGroup();

    final ToggleGroup toggleComputerIntell1 = new ToggleGroup();
    final ToggleGroup toggleComputerIntell2 = new ToggleGroup();

    @FXML
    private ToggleGroup toggleTurnPlayer;

    @FXML
    private ImageView darkBackground;

    public String filePick(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selectionner une image");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image", "*.jpg", "*.jpeg", "*.png", "*.bmp"));
        File fileSelected = fileChooser.showOpenDialog(new Stage());

        System.out.println(fileSelected.getAbsolutePath());

        return fileSelected.getAbsolutePath();
    }

    public void check(){
        playButton.setDisable(fieldPlayer1.getText().equals("") || fieldPlayer2.getText().equals("")
                || toggleHumanComputer1.getSelectedToggle() == null || toggleHumanComputer2.getSelectedToggle() == null ||
                fieldPlayer1.getText().equals(fieldPlayer2.getText()));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if (blur){
            wallpaperView.setEffect(new GaussianBlur(20));
        }

        if (dark){
            darkBackground.setImage(new Image(Main.class.getResourceAsStream("Image/Dark Back.png")));
        }

        playerTitle1.setTextFill(Main.colorText);
        playerTitle2.setTextFill(Main.colorText);
        typePlayerHumanComput1.setTextFill(Main.colorText);
        typePlayerHumanComput2.setTextFill(Main.colorText);
        typeComput1.setTextFill(Main.colorText);
        typeComput2.setTextFill(Main.colorText);
        human1.setTextFill(Main.colorText);
        computer1.setTextFill(Main.colorText);
        human2.setTextFill(Main.colorText);
        computer2.setTextFill(Main.colorText);
        optionClever1.setTextFill(Main.colorText);
        optionClever2.setTextFill(Main.colorText);
        optionCrazy1.setTextFill(Main.colorText);
        optionCrazy2.setTextFill(Main.colorText);
        turnPlayerAlea.setTextFill(Main.colorText);
        numberTitle.setTextFill(Main.colorText);
        numberSquare.setTextFill(Main.colorText);

        wallpaperView.setImage(Main.wallpaper);

        numberSquare.setText(String.valueOf((int) sliderSquare.getValue()));

        human1.setToggleGroup(toggleHumanComputer1);
        computer1.setToggleGroup(toggleHumanComputer1);

        human2.setToggleGroup(toggleHumanComputer2);
        computer2.setToggleGroup(toggleHumanComputer2);

        optionClever1.setToggleGroup(toggleComputerIntell1);
        optionCrazy1.setToggleGroup(toggleComputerIntell1);

        optionClever2.setToggleGroup(toggleComputerIntell2);
        optionCrazy2.setToggleGroup(toggleComputerIntell2);

        sliderSquare.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                numberSquare.setText(String.valueOf((int) sliderSquare.getValue()));
            }
        });

        imagePicker1.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                pathImagePlayer1 = filePick();
                if (pathImagePlayer1 != null){
                    Image img = null;
                    try {
                        img = new Image(new FileInputStream(pathImagePlayer1));
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    imagePlayer1.setImage(img);
                }
            }

        });

        imagePicker2.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                pathImagePlayer2 = filePick();
                if (pathImagePlayer2 != null){
                    Image img = null;
                    try {
                        img = new Image(new FileInputStream(pathImagePlayer2));
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    imagePlayer2.setImage(img);
                }
            }

        });

        computer1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                RadioButton temp = (RadioButton) toggleHumanComputer2.getSelectedToggle();

                if (temp == computer2){
                    toggleHumanComputer2.getSelectedToggle().setSelected(false);
                    human2.setSelected(true);
                    computerOption2.setDisable(true);
                }

                computerOption1.setDisable(false);

                check();
            }
        });

        computer2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                RadioButton temp = (RadioButton) toggleHumanComputer1.getSelectedToggle();

                if (temp == computer1){
                    toggleHumanComputer1.getSelectedToggle().setSelected(false);
                    human1.setSelected(true);
                    computerOption1.setDisable(true);
                }

                computerOption2.setDisable(false);
                check();
            }
        });

        human1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                computerOption1.setDisable(true);
                check();
            }
        });

        human2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                computerOption2.setDisable(true);
                check();
            }
        });
    }

    @FXML
    void lunch(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("FXML/game.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        if (pathImagePlayer1 == null){
            pathImagePlayer1 = "Image/Player1 Default.png";
        }

        if (pathImagePlayer2 == null){
            pathImagePlayer2 = "Image/Player2 Default.png";
        }

        RadioButton temp = (RadioButton) toggleHumanComputer1.getSelectedToggle();
        RadioButton temp1 = (RadioButton) toggleHumanComputer2.getSelectedToggle();
        RadioButton temp2= (RadioButton) toggleComputerIntell1.getSelectedToggle();
        RadioButton temp3 = (RadioButton) toggleComputerIntell2.getSelectedToggle();

        player1 = leaderboard.getPlayer(fieldPlayer1.getText());
        player2 = leaderboard.getPlayer(fieldPlayer2.getText());

        if (player1==null){
            if (temp == human1){
                player1 = new Human(fieldPlayer1.getText(), "X", "");
            }
            else{
                if (temp2 == optionClever1){
                    player1 = new Computer(fieldPlayer1.getText(), "X", "", true);
                }
                else {
                    player1 = new Computer(fieldPlayer1.getText(), "X", "", false);
                }
            }
        }

        player1.setImage(pathImagePlayer1);

        if (player2==null){
            if (temp1 == human2){
                player2 = new Human(fieldPlayer2.getText(), "Y", "");
            }
            else {
                if (temp3 == optionClever1){
                    player2 = new Computer(fieldPlayer2.getText(), "Y", "", true);
                }
                else{
                    player2 = new Computer(fieldPlayer2.getText(), "Y", "", false);
                }
            }
        }

        player2.setImage(pathImagePlayer2);

        gameController controller = fxmlLoader.getController();

        controller.player1 = player1;
        controller.player2 = player2;
        controller.size = (int) sliderSquare.getValue();

        if (toggleTurnPlayer.getSelectedToggle() == turnPlayer1){
            controller.choice = 0;
        }
        else if (toggleTurnPlayer.getSelectedToggle() == turnPlayer2){
            controller.choice = 1;
        }
        else{
            controller.choice = 2;
        }

        controller.restart();

        Stage tempStage = (Stage) imagePlayer1.getScene().getWindow();
        tempStage.setScene(scene);

    }

    @FXML
    void returnButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("FXML/menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage temp = (Stage) imagePlayer1.getScene().getWindow();
        temp.setScene(scene);
    }
}
