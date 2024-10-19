package com.example.bnls_box_rel0aded;

import com.example.bnls_box_rel0aded.model.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.fxml.Initializable;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static com.example.bnls_box_rel0aded.Main.leaderboard;

public class gameController implements Initializable{

    int choice;

    @FXML
    private GridPane grid;

    @FXML
    private Pane panel;

    @FXML
    private Label playerTurn;

    @FXML
    private Label playerTitle1;

    @FXML
    private ImageView player1Image;

    @FXML
    private Label playerTitle2;

    @FXML
    private ImageView helpButton;

    @FXML
    private ImageView mainButton;

    @FXML
    private ImageView resetButton;

    @FXML
    private Label helpLabel;

    @FXML
    private Label mainLabel;

    @FXML
    private Label resetLabel;

    @FXML
    private ImageView player2Image;

    @FXML
    private ImageView wallpaperView;

    @FXML
    private ImageView leaderboardButton;

    @FXML
    private Label leaderboardLabel;

    private GameGrid gameGrid;

    private Game game;

    public Player player1;
    public Player player2;

    Map<Node, Square> dicNodeSquare;

    List<ImageView> listImage;

    int size;

    @FXML
    private ImageView reconfigButton;

    @FXML
    private Label reconfigLabel;

    public gameController() {
    }

    public void update(Square square){

        game.run(square.getCoord());

        for (ImageView image : listImage){
            image.setImage(dicNodeSquare.get(image).getImage());
            if (!dicNodeSquare.get(image).getValue().equals("F")){
                image.setCursor(Cursor.DEFAULT);
            }

            if (!game.running && !dicNodeSquare.get(image).getValue().equals("G")){
                image.setOpacity(0.4);
                image.setCursor(Cursor.DEFAULT);
            }
        }
        playerTurn.setText(game.getStatus());

        if (!game.running){
            resetLabel.setText("Nouvelle partie");
            leaderboardLabel.setVisible(true);
            leaderboardButton.setVisible(true);

            leaderboard.addGame(game);
            leaderboard.addPlayer(player1);
            leaderboard.addPlayer(player2);

        }
        else{
            resetLabel.setText("Recommencer");
            leaderboardLabel.setVisible(false);
            leaderboardButton.setVisible(false);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        wallpaperView.setImage(Main.wallpaper);

        leaderboardButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                leaderboardButton.setOpacity(1);
            }
        });

        leaderboardButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                leaderboardButton.setOpacity(0.5);
            }
        });

        leaderboardButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                openLeader();
            }
        });

        mainButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mainButton.setOpacity(1);
            }
        });

        mainButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mainButton.setOpacity(0.5);
            }
        });

        mainButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                openMain();
            }
        });

        resetButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                resetButton.setOpacity(1);
            }
        });

        resetButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                resetButton.setOpacity(0.5);
            }
        });

        resetButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                restart();
            }
        });

        helpButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                helpButton.setOpacity(1);
            }
        });

        helpButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                helpButton.setOpacity(0.5);
            }
        });

        helpButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                openHelp();
            }
        });

        reconfigButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                reconfigButton.setOpacity(1);
            }
        });

        reconfigButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                reconfigButton.setOpacity(0.5);
            }
        });

        reconfigButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                openConfig();
            }
        });

        leaderboardLabel.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                leaderboardButton.setOpacity(1);
            }
        });

        leaderboardLabel.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                leaderboardButton.setOpacity(0.5);
            }
        });

        leaderboardLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                openLeader();
            }
        });


        mainLabel.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mainButton.setOpacity(1);
            }
        });

        mainLabel.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mainButton.setOpacity(0.5);
            }
        });

        mainLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                openMain();

            }
        });

        resetLabel.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                resetButton.setOpacity(1);
            }
        });

        resetLabel.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                resetButton.setOpacity(0.5);
            }
        });

        resetLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                restart();
            }
        });

        helpLabel.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                helpButton.setOpacity(1);
            }
        });

        helpLabel.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                helpButton.setOpacity(0.5);
            }
        });

        helpLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                openHelp();
            }
        });

        reconfigLabel.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                reconfigButton.setOpacity(1);
            }
        });

        reconfigLabel.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                reconfigButton.setOpacity(0.5);
            }
        });

        reconfigLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                openConfig();
            }
        });

    }

    private void openMain() {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("FXML/menu.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Stage temp = (Stage) mainButton.getScene().getWindow();
        temp.setScene(scene);
    }

    private void openConfig() {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("FXML/config.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Stage temp = (Stage) reconfigButton.getScene().getWindow();
        temp.setScene(scene);
    }

    private void openLeader() {
        Stage leaderboardStage = new Stage(StageStyle.DECORATED);
        leaderboardStage.initModality(Modality.WINDOW_MODAL);
        leaderboardStage.initOwner(leaderboardLabel.getScene().getWindow());

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("FXML/leaderboard.fxml"));
        Scene leaderboardScene = null;
        try {
            leaderboardScene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        leaderboardStage.setTitle("BNL's Box Rel0aded : JAVA Edition    Classement des joueurs");
        leaderboardStage.setScene(leaderboardScene);

        leaderboardStage.setResizable(false);

        leaderboardStage.getIcons().add(new Image(Main.class.getResourceAsStream("Image/Rel0aded_icon.png")));

        leaderboardStage.show();
    }

    private void openHelp() {
        Stage helpStage = new Stage(StageStyle.DECORATED);
        helpStage.initOwner(helpButton.getScene().getWindow());

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("FXML/help.fxml"));
        Scene helpScene = null;
        try {
            helpScene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        helpStage.setTitle("BNL's Box Rel0aded : JAVA Edition    Assistance aux joueurs");
        helpStage.setScene(helpScene);

        helpStage.getIcons().add(new Image(Main.class.getResourceAsStream("Image/Rel0aded_icon.png")));

        helpStage.setResizable(false);

        helpStage.show();
    }

    public void restart(){

        dicNodeSquare = new HashMap<Node, Square>();
        listImage = new LinkedList<ImageView>();

        grid = new GridPane();
        panel.getChildren().clear();
        panel.getChildren().add(grid);

        game = new Game(player1, player2, size, panel.getPrefWidth(), panel.getPrefHeight(), choice);

        gameGrid = game.getGrid();

        playerTitle1.setText(player1 + " : " + player1.getScore());
        playerTitle2.setText(player2 + " : " + player2.getScore());

        for (int i = 0; i < gameGrid.getSize(); i++) {
            for (int j = 0; j < gameGrid.getSize(); j++) {

                ImageView image = new ImageView();

                image.setImage(gameGrid.getCase(j, i).getImage());
                image.setCursor(Cursor.HAND);

                dicNodeSquare.put(image, gameGrid.getCase(i, j));
                listImage.add(image);

                playerTurn.setText(game.getStatus());

                if (game.getPlayer().equals(player1)){
                    player1Image.setOpacity(1);
                    playerTitle1.setOpacity(1);
                    player2Image.setOpacity(0.3);
                    playerTitle2.setOpacity(0.9);
                }
                else{
                    player2Image.setOpacity(1);
                    playerTitle2.setOpacity(1);
                    player1Image.setOpacity(0.3);
                    playerTitle1.setOpacity(0.9);
                }

                image.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        play(mouseEvent);
                    }
                });

                grid.add(image, i, j);

            }

        }

        if (game.getPlayer() instanceof Computer){
            play(null);
        }
    }

    public void play(MouseEvent mouseEvent){

        Square temp = game.getPlayer().play(gameGrid, mouseEvent, dicNodeSquare);

        update(temp);

        if (game.getPlayer().equals(player1)){
            player1Image.setOpacity(1);
            playerTitle1.setOpacity(1);
            player2Image.setOpacity(0.3);
            playerTitle2.setOpacity(0.9);
        }
        else{
            player2Image.setOpacity(1);
            playerTitle2.setOpacity(1);
            player1Image.setOpacity(0.3);
            playerTitle1.setOpacity(0.9);
        }

        if (game.getPlayer() instanceof Computer && game.running){
            play(null);
        }
    }

}
