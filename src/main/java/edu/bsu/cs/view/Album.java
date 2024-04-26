package edu.bsu.cs.view;


import edu.bsu.cs.model.API_Requests;
import edu.bsu.cs.model.Access;
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

public class Album extends Application {
    public static final int[] WINDOW_SIZE = {1090, 750};
    @FXML
    public Button albumSearchBTN;
    @FXML
    public Button artistBTN;
    @FXML
    public TextArea albumOutPutField = new TextArea("");
    @FXML
    public TextField albumSearchBar;
    @FXML
    public Button homeBTN;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("albumScene.fxml")));
            Scene scene = new Scene(root, WINDOW_SIZE[0], WINDOW_SIZE[1]);
            stage.setScene(scene);
            stage.show();
            homeBTN.setOnAction(this::configureHomeButton);
            artistBTN.setOnAction(this::configureArtistButton);

            configureAlbumSearchButton();
        } catch (Exception e) {
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
        }
    }
    @FXML
    public void configureArtistButton(javafx.event.ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(requireNonNull(getClass().getClassLoader().getResource("artistScene.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, WINDOW_SIZE[0], WINDOW_SIZE[1]));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void configureAlbumSearchBar(){
        try {
            API_Requests pullAlbum = new API_Requests();
            String responseBody = pullAlbum.searchForAlbum(Access.getAccessToken(), albumSearchBar.getText());
            albumOutPutField.clear();
            String formattedData = JSON_Formatter.formatAlbum(responseBody).toString();
            int cutoff = formattedData.length() - 1;
            String output = formattedData.substring(1,cutoff);
            albumOutPutField.setText(output);
            albumOutPutField.setEditable(false);


        }
        catch (Exception e ){
            e.printStackTrace();
        }
    }

    @FXML
    private void configureAlbumSearchButton() {
        albumSearchBTN.setOnAction(event -> configureAlbumSearchBar());
    }









}