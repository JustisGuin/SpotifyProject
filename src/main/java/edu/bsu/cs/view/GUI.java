package edu.bsu.cs.view;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Objects;

import static java.util.Objects.*;


public class GUI extends Application {
    public static final int[] WINDOW_SIZE = {1077, 749};
    public Button getalbumBTN;
    public Button getArtistBTN;
    public ImageView spotifyImageView;
    public HBox root;

    public static void main(String[] args) {
        launch(args);
    }


    @FXML
    private final Button homeBTN = new Button("");
    @FXML
    private final TextArea outputField = new TextArea();

    public void initialize() {
        outputField.setMinHeight(400);
    }


    @Override
    public void start(Stage stage) throws IOException {
        outputField.setMinHeight(400);
        configure(stage);
        Parent root = FXMLLoader.load(requireNonNull(getClass().getClassLoader().getResource("GUI.fxml")));
        Scene scene = new Scene(root, WINDOW_SIZE[0], WINDOW_SIZE[1]);
        stage.setScene(scene);
        stage.show();


    }

    private void configure(Stage stage) {
        VBox root = createRoot();
        getalbumBTN.setOnAction(this::handleAlbumButtonAction);
        getArtistBTN.setOnAction(this::handleArtistButtonAction);
        stage.setScene(new Scene(root));
        stage.sizeToScene();
        stage.show();


    }

    private VBox createRoot() {
        VBox root = new VBox();
        getalbumBTN = new Button("Album");
        getArtistBTN = new Button("Artist");
        root.getChildren().addAll(
                getalbumBTN,
                getArtistBTN,
                homeBTN,
                new Label("Search Results:"),
                outputField);
        return root;


    }

    @FXML
    public void handleAlbumButtonAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(requireNonNull(getClass().getClassLoader().getResource("albumScene.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, WINDOW_SIZE[0], WINDOW_SIZE[1]));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleArtistButtonAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(requireNonNull(getClass().getClassLoader().getResource("artistScene.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, WINDOW_SIZE[0], WINDOW_SIZE[1]));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

