package edu.bsu.cs.view;


import edu.bsu.cs.model.API_Requests;
import edu.bsu.cs.model.Access;
import edu.bsu.cs.model.JSON_Formatter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.Objects;

import static java.util.Objects.requireNonNull;


public class Track extends Application {
    public static final int[] WINDOW_SIZE = {800, 600};
    public Button homeBTN;
    public Button albumBTN;
    public Button artistBTN;

    public static void main(String[] args) {launch(args);}

    public Button trackSearchBTN;
    public TextField trackOutputField;
    public TextField trackSearchBar;


    @Override
    public void start(Stage stage) {

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("trackScene.fxml")));
            Scene scene = new Scene(root, WINDOW_SIZE[0], WINDOW_SIZE[1]);
            stage.setScene(scene);
            stage.show();
            homeBTN.setOnAction(this::configureHomeButton);
            artistBTN.setOnAction(this::configureArtistButton);
            albumBTN.setOnAction(this::configureAlbumButton);
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
    public void configureAlbumButton(javafx.event.ActionEvent event) {
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
    public void configureTrackSearchBar(){
        try {
            API_Requests pullAlbum = new API_Requests();
            String responseBody = pullAlbum.searchForAlbum(Access.getAccessToken(), trackSearchBar.getText());
            trackOutputField.clear();
            String formattedData = JSON_Formatter.formatAlbum(responseBody).toString();
            trackOutputField.setText(formattedData);


        }
        catch (Exception e ){
            e.printStackTrace();
        }
    }
    @FXML
    private void configureTrackSearchButton() {
        trackSearchBTN.setOnAction(event -> configureTrackSearchBar());
    }
}