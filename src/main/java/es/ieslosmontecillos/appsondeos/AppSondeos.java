/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ieslosmontecillos.appsondeos;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import static javafx.scene.paint.Color.LIGHTSTEELBLUE;

/**
 *
 * @author Profesora
 */
public class AppSondeos extends Application {
    
    @Override
    public void start(Stage primaryStage) {

        StackPane root = new StackPane();

        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);

        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);


        Foods foods = new Foods();
        Readings readings = new Readings();
        foods.setText("Foods");
        readings.setText("Readings");
        tabPane.getTabs().add(foods);
        tabPane.getTabs().add(readings);

root.getChildren().add(tabPane);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
