package edu.bsu.cs.view;

import edu.bsu.cs.model.*;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.requireNonNull;


public class Track extends Application {
    public static final int[] WINDOW_SIZE = {1090, 780};
    public Button homeBTN;
    public Button albumBTN;
    public Button artistBTN;
    public TextArea trackOutPutField;

    public static void main(String[] args) {launch(args);}

    public Button trackSearchBTN;
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
    public void configureArtistButton(javafx.event.ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(requireNonNull(getClass().getClassLoader().getResource("artistScene.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, WINDOW_SIZE[0], WINDOW_SIZE[1]));
            stage.show();
        } catch (Exception e) {
            ErrorCatcher.viewClassErrorCatch();
        }
    }

    @FXML
    public void configureTrackSearchBar(){
        try {
            API_Requests pullAlbum = new API_Requests();
            String responseBody = pullAlbum.searchForAlbum(Access.getAccessToken(), trackSearchBar.getText());
            trackOutPutField.clear();
            List<String> formattedData = GUI_Json_Formatter.formatTrackGUI(responseBody);
            trackOutPutField.setText(String.valueOf(formattedData));


        }
        catch (Exception e ){
            ErrorCatcher.viewClassErrorCatch();
        }
    }
    @FXML
    private void configureTrackSearchButton() {
        trackSearchBTN.setOnAction(event -> configureTrackSearchBar());
    }
}