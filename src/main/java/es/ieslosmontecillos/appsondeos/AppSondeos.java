/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ieslosmontecillos.appsondeos;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Objects;


/**
 *
 * @author Alpha Team
 */
public class AppSondeos extends Application {

    @Override

    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        //root.getChildren().add(btnStart);
        

        Scene scene = new Scene(root, 700, 500);


        /* Set the background image */
        root.getStylesheets().add(Objects.requireNonNull(Sports.class.getResource("css/Main.css")).toExternalForm());
        root.setId("main");

        primaryStage.setTitle("Quest");
        primaryStage.setScene(scene);

        /* Menu */
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Quest");
        menuBar.getMenus().add(menu);
        MenuItem menu1 = new MenuItem("Start Quest");
        menu.getItems().add(menu1);
        MenuItem menu2 = new MenuItem("Exit");
        menu.getItems().add(menu2);
        BorderPane.setAlignment(menuBar, Pos.TOP_CENTER);

        /* Botones */
        Button btnStart = new Button("Empezar cuestionario");
        btnStart.getStyleClass().add("buttons");
        Button btnExit = new Button("Salir");
        btnExit.getStyleClass().add("buttons");

        /* Añadimos los botones */
        VBox botonera = new VBox(10, btnStart, btnExit);
        botonera.setStyle("-fx-padding: 15px");

        /* Añadimos la botonera */
        root.setBottom(botonera);
        botonera.setAlignment(Pos.TOP_CENTER);


        //root.getChildren().add(menuBar);
        root.setTop(menuBar);

        primaryStage.show();

        /* Segunda Escena*/
        StackPane root2 = new StackPane();
        Scene scene2 = new Scene(root2, 610, 377);

        /* TabPane */
        TabPane tabPane = new TabPane();
        Tab sports = new Sports();
        sports.closableProperty().setValue(false);
        tabPane.getTabs().add(sports);
        Tab animals = new Animals();
        animals.closableProperty().setValue(false);
        tabPane.getTabs().add(animals);
        Tab meats = new Foods();
        meats.closableProperty().setValue(false);
        tabPane.getTabs().add(meats);
        Tab journeys = new Journeys();
        journeys.closableProperty().setValue(false);
        tabPane.getTabs().add(journeys);
        Tab readings = new Readings();
        readings.closableProperty().setValue(false);
        tabPane.getTabs().add(readings);


        root2.getChildren().add(tabPane);


        btnStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene(scene2);
                primaryStage.setFullScreen(true);
            }
        });

        btnExit.setOnAction(actionEvent -> primaryStage.close());

        menu1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene(scene2);
                primaryStage.setFullScreen(true);
            }
        });

        menu2.setOnAction(actionEvent -> primaryStage.close());

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
