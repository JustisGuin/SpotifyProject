package edu.bsu.cs.view;


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.stage.Stage;


import java.util.Objects;

public class Artist extends Application {
    public static final int[] WINDOW_SIZE = {800, 600};

    public static void main(String[] args) {
        launch(args);
    }



    @FXML
    private Button homeBTN = new Button("");
    @FXML
    private final TextArea outputField = new TextArea();
    @FXML
    private final TextField albumSearchField= new TextField();



    @Override
    public void start(Stage stage) {
        try {
            outputField.setMinHeight(400);
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("artistScene.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, WINDOW_SIZE[0], WINDOW_SIZE[1]);
            stage.setScene(scene);
            stage.show();
            homeBTN.setOnAction(this::configureHomeButton);
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










}