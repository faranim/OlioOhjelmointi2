package org.example.Moduuli7.Moduuli7_4.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.example.Moduuli7.Moduuli7_4.Controller.CConversionController3;

import java.io.IOException;


public class CcView extends Application {

    private Stage primaryStage;
    private BorderPane root;


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Converter 2.0");


        initRootLayout();

    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sceneCC3.fxml"));

            root = fxmlLoader.load();
            CConversionController3 controller = fxmlLoader.getController();
            System.out.println(controller);
            controller.setMainApp();

            // Show the scene containing the root layout.
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addMoneyWindow() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sceneAdd.fxml"));
            BorderPane pane = fxmlLoader.load();
            CConversionController3 controller = fxmlLoader.getController();
            System.out.println(controller);
            controller.setSecondApp();


            Stage newStage = new Stage();
            Scene scene = new Scene(pane);
            newStage.setScene(scene);
            newStage.showAndWait();

            newStage.setOnCloseRequest(event -> {
                controller.setCurrencies();
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}