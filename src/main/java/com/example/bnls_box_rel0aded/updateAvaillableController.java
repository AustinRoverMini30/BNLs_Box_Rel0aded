package com.example.bnls_box_rel0aded;

import com.example.bnls_box_rel0aded.model.Version;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class updateAvaillableController implements Initializable {
    @FXML
    private Button cancelUpdateButton;

    @FXML
    private ProgressIndicator progressIndicator;

    @FXML
    private Button confirmUpdateButton;

    public Version version;
    public Version versionTemp;

    @FXML
    private Label versionGameLabel;

    @FXML
    private Label versionUpdateLabel;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label updateLabel;

    private double stat = 0;

    public void setVersion(){
        versionGameLabel.setText(versionGameLabel.getText() + " " + version.getVersionGame() +
                " -> " + versionTemp.getVersionGame());
        versionUpdateLabel.setText(versionUpdateLabel.getText() + " " + version.getVersionUpdate() +
                " - > " + versionTemp.getVersionUpdate());
    }

    public void downloadFile(String filename, String url){

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                updateLabel.setText("Estimation de la taille du fichier");
                progressIndicator.setVisible(true);
                progressBar.setVisible(true);
            }
        });

        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(filename)) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;

            double ratio = in.readAllBytes().length/1027;

            BufferedInputStream in2 = new BufferedInputStream(new URL(url).openStream());

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    updateLabel.setText("Téléchargement de BNL's Rel0aded Update Utility");
                    progressIndicator.setVisible(true);
                }
            });

            while ((bytesRead = in2.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        stat = stat + (1/ratio);
                        progressBar.setProgress(stat);
                    }
                });
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cancelUpdateButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Stage stage = (Stage) cancelUpdateButton.getScene().getWindow();
                stage.close();
            }
        });

        confirmUpdateButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                cancelUpdateButton.setDisable(true);
                confirmUpdateButton.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent windowEvent) {
                    }
                });

                if (!version.comparatorUpdate(versionTemp)) {
                    Thread t = new Thread() {
                        public void run() {
                            downloadFile("BNL_Rel0aded_Update_Utility.jar", "https://drive.usercontent.google.com/download?id=19KV0DcE3YYI84MSrYhfpYXTkBISHHQno&export=download&authuser=0&confirm=t&uuid=657453d6-a013-4a8c-bc30-f2d51f2259f9&at=APZUnTUflrnLyBEli15tehomXj0d:1716637774301");

                            ProcessBuilder builder = new ProcessBuilder("java", "-jar" , "BNL_Rel0aded_Update_Utility.jar");
                            try {
                                Process process = builder.start();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            Platform.exit();
                        }
                    };

                    t.start();
                }

                else{
                    ProcessBuilder builder = new ProcessBuilder("java", "-jar" , "BNL_Rel0aded_Update_Utility.jar");
                    try {
                        Process process = builder.start();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    Platform.exit();
                }

            }
        });
    }
}
