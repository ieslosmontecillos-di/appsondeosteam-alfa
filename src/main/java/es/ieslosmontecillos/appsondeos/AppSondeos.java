/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ieslosmontecillos.appsondeos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Profesora
 */
public class AppSondeos extends Application {
    @Override
    public void start(Stage primaryStage)
    {
        TabPane mainTab = new TabPane();

        Sports sports = new Sports();
        mainTab.getTabs().add(sports);

        Journeys journeys = new Journeys();
        mainTab.getTabs().add(journeys);

        GridPane root = new GridPane();
        
        Scene scene = new Scene(root, 800, 700);

        root.getChildren().add(mainTab);
        
        primaryStage.setTitle("Encuesta");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
