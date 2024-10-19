package com.example.bnls_box_rel0aded;

import com.example.bnls_box_rel0aded.model.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import static com.example.bnls_box_rel0aded.Main.colorText;
import static com.example.bnls_box_rel0aded.Main.leaderboard;

public class leaderboardController implements Initializable {
    @FXML
    private ImageView wall;

    @FXML
    private Pane paneGrid;

    @FXML
    private GridPane gridScore;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        wall.setImage(Main.wallpaper);

        gridScore.setAlignment(Pos.CENTER);

        double size = gridScore.getPrefWidth()/(leaderboard.getNbPlayer()+1);

        Label label = new Label("Miniature : ");
        label.setTextFill(colorText);
        label.setFont(Font.font(15));
        label.setPrefWidth(size);

        Label label1 = new Label("Pseudo : ");
        label1.setTextFill(colorText);
        label1.setFont(Font.font(15));
        label1.setPrefWidth(size);

        Label label2 = new Label("Score : ");
        label2.setTextFill(colorText);
        label2.setFont(Font.font(15));
        label2.setPrefWidth(size);

        Label label3 = new Label("Nombre de parties gagnées : ");
        label3.setTextFill(colorText);
        label3.setFont(Font.font(15));
        label3.setPrefWidth(size);

        gridScore.add(label, 0, 0);
        gridScore.add(label1, 0, 1);
        gridScore.add(label2, 0, 2);
        gridScore.add(label3, 0, 3);

        int i = 1;
        for (Player player : leaderboard.getPlayer().values()){

            label = new Label(player.toString());
            label.setTextFill(colorText);
            label.setFont(Font.font(15));
            label.setAlignment(Pos.CENTER);
            label.setPrefWidth(size);

            label1 = new Label(String.valueOf(player.getScore()));
            label1.setTextFill(colorText);
            label1.setFont(Font.font(15));
            label1.setAlignment(Pos.CENTER);
            label1.setPrefWidth(size);

            label2 = new Label(String.valueOf(player.getNbWin()));
            label2.setTextFill(colorText);
            label2.setFont(Font.font(15));
            label2.setAlignment(Pos.CENTER);
            label2.setPrefWidth(size);

            try {
                gridScore.add(new ImageView(new Image(new FileInputStream(player.getImage()), size, size, false, true)), i, 0);
            } catch (FileNotFoundException e) {
                gridScore.add(new ImageView(new Image(Main.class.getResourceAsStream(player.getImage()), size, size, false, true)), i, 0);
            }

            gridScore.add(label, i, 1);
            gridScore.add(label1, i, 2);
            gridScore.add(label2, i, 3);
            i++;
        }

    }
}
