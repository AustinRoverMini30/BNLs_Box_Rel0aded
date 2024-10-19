package com.example.bnls_box_rel0aded;

import com.example.bnls_box_rel0aded.model.Version;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.Effect;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static com.example.bnls_box_rel0aded.Main.blur;
import static com.example.bnls_box_rel0aded.Main.dark;

public class settingsController implements Initializable{
    @FXML
    private ColorPicker colorSelector;

    @FXML
    private TabPane tabPane;
    @FXML
    private Tab versionTab;
    @FXML
    private Tab customTab;
    @FXML
    private Tab javaTab;

    @FXML
    private Tab optionsTab;

    @FXML
    private Label gameVer;

    @FXML
    private Label previewText;

    @FXML
    private ImageView returnButton;

    @FXML
    private ImageView searchImage;

    @FXML
    private Label titleCustom;

    @FXML
    private Label titleVersion;

    @FXML
    private Label updateVer;

    @FXML
    private ImageView wallpaperView;

    private Version version;

    @FXML
    private ImageView searchUpdateButton;

    @FXML
    private ImageView previewWallpaper1;

    @FXML
    private ImageView previewWallpaper2;

    @FXML
    private ImageView previewWallpaper3;

    @FXML
    private ImageView previewWallpaper4;

    @FXML
    private ImageView previewWallpaper5;

    @FXML
    private ImageView previewWallpaper6;

    @FXML
    private ImageView previewWallpaper7;

    @FXML
    private ImageView previewWallpaper8;

    @FXML
    private ImageView previewWallpaperCustom;

    @FXML
    private Label wallTitle;

    @FXML
    private ImageView darkBackground;

    @FXML
    private CheckBox blurCheck;

    @FXML
    private Label blurText;

    @FXML
    private CheckBox darkCheck;

    @FXML
    private Label darkText;

    @FXML
    private Label searchUpdateResult;

    public void changeColor(){
        titleCustom.setTextFill(Main.colorText);
        titleVersion.setTextFill(Main.colorText);
        updateVer.setTextFill(Main.colorText);
        gameVer.setTextFill(Main.colorText);
        previewText.setTextFill(Main.colorText);
        wallTitle.setTextFill(Main.colorText);
        darkText.setTextFill(Main.colorText);
        blurText.setTextFill(Main.colorText);
    }

    public void changeWallpaperCustom(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sélectionner une image");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image", "*.jpg", "*.jpeg", "*.png", "*.bmp"));
        File fileSelectd = fileChooser.showOpenDialog(new Stage());

        String path = fileSelectd.getAbsolutePath();
        if (path != null){
            Image image = null;
            try {
                image = new Image(new FileInputStream(path));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            previewWallpaperCustom.setImage(image);

            Main.wallpaper = image;
            wallpaperView.setImage(Main.wallpaper);
        }
    }

    public void alternTab(){
        ImageView versionImage = new ImageView(new Image(Main.class.getResourceAsStream("Image/Version.png"), 180, 180, true, true));
        ImageView customImage = new ImageView(new Image(Main.class.getResourceAsStream("Image/Personnalisation.png"), 180, 180, true, true));

        ImageView versionImageSelected = new ImageView(new Image(Main.class.getResourceAsStream("Image/Version Selected.png"), 180, 180, true, true));
        ImageView customImageSelected = new ImageView(new Image(Main.class.getResourceAsStream("Image/Personnalisation Selected.png"), 180, 180, true, true));

        ImageView javaImage = new ImageView(new Image(Main.class.getResourceAsStream("Image/JAVA.png"), 180, 180, true, true));
        ImageView optionsImage = new ImageView(new Image(Main.class.getResourceAsStream("Image/Options.png"), 180, 180, true, true));

        ImageView javaImageSelected = new ImageView(new Image(Main.class.getResourceAsStream("Image/JAVA Selected.png"), 180, 180, true, true));
        ImageView optionsImageSelected = new ImageView(new Image(Main.class.getResourceAsStream("Image/Options Selected.png"), 180, 180, true, true));

        Tab temp = tabPane.getSelectionModel().getSelectedItem();

        if (temp == versionTab){
            versionTab.setGraphic(versionImageSelected);
            javaTab.setGraphic(javaImage);
            optionsTab.setGraphic(optionsImage);
            customTab.setGraphic(customImage);
        }
        else if (temp == javaTab){
            versionTab.setGraphic(versionImage);
            javaTab.setGraphic(javaImageSelected);
            optionsTab.setGraphic(optionsImage);
            customTab.setGraphic(customImage);
        }
        else if (temp == optionsTab){
            versionTab.setGraphic(versionImage);
            javaTab.setGraphic(javaImage);
            optionsTab.setGraphic(optionsImageSelected);
            customTab.setGraphic(customImage);
        }
        else{
            versionTab.setGraphic(versionImage);
            javaTab.setGraphic(javaImage);
            optionsTab.setGraphic(optionsImage);
            customTab.setGraphic(customImageSelected);
        }
    }

    public static void versionSaveToFile(Version version, String filename) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(version);

        oos.close();
        fos.close();
    }

    public static Version versionBackFromFile(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream dis = new ObjectInputStream(fis);

        Version version = (Version) dis.readObject();

        dis.close();
        fis.close();

        return version;
    }

    @FXML
    void wallpaperClick(MouseEvent event) {
        ImageView temp = (ImageView) event.getSource();

        if (temp.getImage() != null){
            Main.wallpaper = temp.getImage();
            wallpaperView.setImage(Main.wallpaper);
        }
    }

    public void downloadFile(String filename, String url){
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(filename)) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {

        changeColor();

        if (dark){
            darkBackground.setImage(new Image(Main.class.getResourceAsStream("Image/Dark Back.png")));
            darkCheck.setSelected(true);
        }

        try {
            version = versionBackFromFile("version.bin");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (blur){
            wallpaperView.setEffect(new GaussianBlur(20));
            blurCheck.setSelected(true);
        }

        previewWallpaperCustom.setImage(null);

        wallpaperView.setImage(Main.wallpaper);

        updateVer.setText(updateVer.getText() + " " + version.getVersionUpdate());
        gameVer.setText(gameVer.getText() + " " + version.getVersionGame());


        colorSelector.setValue(Main.colorText);

        darkCheck.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (dark){
                    darkCheck.setSelected(false);
                    dark = false;
                    darkBackground.setImage(null);
                }
                else{
                    darkCheck.setSelected(true);
                    dark = true;
                    darkBackground.setImage(new Image(Main.class.getResourceAsStream("Image/Dark Back.png")));
                }
            }
        });

        blurCheck.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (blur){
                    blurCheck.setSelected(false);
                    blur = false;
                    wallpaperView.setEffect(null);
                }
                else{
                    blurCheck.setSelected(true);
                    blur = true;
                    wallpaperView.setEffect(new GaussianBlur(20));
                }
            }
        });

        searchUpdateButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                downloadFile("versionTemp.bin", "https://drive.google.com/uc?export=download&id=1zbt7uUaNQbfIDV6aSfU1WCFo3aUyWn5C");
                Version versionTemp;

                try {
                    versionTemp = versionBackFromFile("versionTemp.bin");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                System.out.println(versionTemp.getVersionGame());

                if (version.comparatorGame(versionTemp)){
                    searchUpdateResult.setText("Aucune mise à jour disponible");
                }
                else{
                    Stage updateStage = new Stage(StageStyle.DECORATED);
                    updateStage.initModality(Modality.WINDOW_MODAL);
                    updateStage.initOwner(searchUpdateButton.getScene().getWindow());

                    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("FXML/updateAvaillable.fxml"));

                    Scene updateScene = null;
                    try {
                        updateScene = new Scene(fxmlLoader.load());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    updateAvaillableController controller = fxmlLoader.getController();
                    controller.version = version;
                    controller.versionTemp = versionTemp;
                    controller.setVersion();

                    updateStage.setTitle("BNL's Box Rel0aded : JAVA Edition    BNL's Box Rel0aded v"+versionTemp.getVersionGame());
                    updateStage.setScene(updateScene);

                    updateStage.setResizable(false);
                    updateStage.initStyle(StageStyle.UNDECORATED);

                    updateStage.show();
                }
            }
        });

        tabPane.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                alternTab();
            }
        });

        searchImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                changeWallpaperCustom();
            }
        });

        colorSelector.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Main.colorText = colorSelector.getValue();
                changeColor();
            }
        });

        returnButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("FXML/menu.fxml"));
                Scene scene = null;
                try {
                    scene = new Scene(fxmlLoader.load());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                Stage temp = (Stage) returnButton.getScene().getWindow();
                temp.setScene(scene);
            }
        });
        alternTab();
    }
}
