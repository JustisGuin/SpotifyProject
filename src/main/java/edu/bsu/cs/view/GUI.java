package edu.bsu.cs.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Objects;


public class GUI extends Application {
    public static final int[] WINDOW_SIZE = {800, 600};
    public static void main(String[] args) {
        launch(args);


    }

    private final Button artistButton = new Button("Artist");
    private final Button albumButton = new Button("Album");
    private final Button trackButton = new Button("Track");
    private final TextField inputField = new TextField();
    private final TextArea outputField = new TextArea();
    private final HBox buttonBox = new HBox();



    @Override
    public void start(Stage primaryStage) throws IOException {

        outputField.setMinHeight(600);
        outputField.setMinWidth(600);
        configure(primaryStage);
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("GUI.fxml")));
        Scene scene = new Scene(root, WINDOW_SIZE[0], WINDOW_SIZE[1]);

        scene.getStylesheets().add("view/gui.css");



    }
    private void handleAlbumButtonClick(ActionEvent event) {
        Stage albumStage = new Stage();
        albumStage.setScene(new Scene(createRoot()));
        albumStage.show();
    }

    private void configure(Stage stage) {
        //albumButton.setOnAction(event -> handleAlbumButtonClick(event));
        stage.setTitle("Wiki Search");
        stage.setScene(new Scene(createRoot()));
        stage.sizeToScene();
        stage.show();

        HBox buttonBox = new HBox();
        buttonBox.getChildren().addAll(artistButton, albumButton, trackButton);

    }

    private Pane createRoot() {
        buttonBox.getChildren().addAll(artistButton, albumButton, trackButton);
        VBox root = new VBox();
        root.getChildren().addAll( //
                new Label("Search for Artist, Track or Album"), //
                inputField,
                buttonBox,
                new Label("Search Results:"),//
                outputField);
        return root;
    }








}

