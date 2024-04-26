package edu.bsu.cs.view;


import edu.bsu.cs.model.API_Requests;
import edu.bsu.cs.model.Access;
import edu.bsu.cs.model.ErrorCatcher;
import edu.bsu.cs.model.JSON_Formatter;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.stage.Stage;


import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class Artist extends Application {
    public static final int[] WINDOW_SIZE = {1090, 750};
    public Button albumBTN;
    public Button trackBTN;


    public static void main(String[] args) {
        launch(args);
    }


    @FXML
    private Button artistSearchBTN;
    @FXML
    public TextArea artistOutputField = new TextArea("");
    @FXML
    private Button homeBTN = new Button("");
    @FXML
    private TextField artistSearchBar = new TextField();



    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("artistScene.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, WINDOW_SIZE[0], WINDOW_SIZE[1]);
            stage.setScene(scene);
            stage.show();
            homeBTN.setOnAction(this::configureHomeButton);
            albumBTN.setOnAction(this::configureAlbumButton);
            trackBTN.setOnAction(this::configureTrackButton);
            configureArtistSearchButton();
        } catch (Exception e) {
            ErrorCatcher.viewClassErrorCatch();
        }
    }


    @FXML
    private void configureHomeButton(javafx.event.ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("GUI.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, WINDOW_SIZE[0], WINDOW_SIZE[1]));
            stage.show();
        } catch (Exception e) {
            ErrorCatcher.viewClassErrorCatch();
        }
    }
    @FXML
    public void configureAlbumButton(javafx.event.ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(requireNonNull(getClass().getClassLoader().getResource("albumScene.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, WINDOW_SIZE[0], WINDOW_SIZE[1]));
            stage.show();
        } catch (Exception e) {
            ErrorCatcher.viewClassErrorCatch();
        }
    }

    @FXML
    public void configureTrackButton(javafx.event.ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(requireNonNull(getClass().getClassLoader().getResource("trackScene.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, WINDOW_SIZE[0], WINDOW_SIZE[1]));
            stage.show();
        } catch (Exception e) {
            ErrorCatcher.viewClassErrorCatch();
        }
    }





    @FXML
    public void configureArtistSearchBar() {
        try {
            API_Requests pullArtist = new API_Requests();
            String responseBody = pullArtist.searchForArtist(Access.getAccessToken(), artistSearchBar.getText());
            artistOutputField.clear();
            String formattedData = JSON_Formatter.formatArtist(responseBody);
            artistOutputField.setText(formattedData);
            artistOutputField.setEditable(false);


        }catch (Exception e){
            ErrorCatcher.viewClassErrorCatch();
        }
    }
    @FXML
    private void configureArtistSearchButton() {
        artistSearchBTN.setOnAction(event -> configureArtistSearchBar());
    }










}