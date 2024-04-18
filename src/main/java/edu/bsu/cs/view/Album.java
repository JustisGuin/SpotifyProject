package edu.bsu.cs.view;


import edu.bsu.cs.model.API_Requests;
import edu.bsu.cs.model.Access;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Objects;

public class Album extends Application {
    public static final int[] WINDOW_SIZE = {800, 600};

    public static void main(String[] args) {
        launch(args);
    }



    @FXML
    private final Button homeBTN = new Button("");
    @FXML
    private final TextArea outputField = new TextArea();
    @FXML
    private final TextField albumSearchField= new TextField();


    @Override
    public void start(Stage stage) {
        try {
            outputField.setMinHeight(400);
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("albumScene.fxml")));
            Scene scene = new Scene(root, WINDOW_SIZE[0], WINDOW_SIZE[1]);
            stage.setScene(scene);
            stage.show();
            homeBTN.setOnAction(this::configureHomeButton);
            initialize();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

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

    public void getAlbums() {
        try {
            API_Requests pullAlbum = new API_Requests();
            String resposeBody = pullAlbum.searchForAlbum(Access.getAccessToken(), albumSearchField.getText());

            outputField.setText(resposeBody);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void initialize() {
        albumSearchField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    getAlbums();
                }
            }
        });
    }






}