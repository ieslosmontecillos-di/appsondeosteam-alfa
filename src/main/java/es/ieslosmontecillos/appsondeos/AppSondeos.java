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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author Alpha Team
 */
public class AppSondeos extends Application {

    @Override

    public void start(Stage primaryStage) throws FileNotFoundException {

        BorderPane root = new BorderPane();
        //root.getChildren().add(btnStart);
        
        Scene scene = new Scene(root, 600, 400);
        //FileInputStream input = new FileInputStream("imagen1.jpg");
        FileInputStream input = new FileInputStream("src\\main\\resources\\es.ieslosmontecillos.appsondeos\\MainMenu.jpg");

        Image img = new Image(input);
        //Image img = new Image(getClass().getResource("../MainMenu.jpg").toExternalForm());

        BackgroundImage bgImage = new BackgroundImage(img,
                                                        BackgroundRepeat.NO_REPEAT,
                                                        BackgroundRepeat.NO_REPEAT,
                                                        BackgroundPosition.DEFAULT,
                                                        new BackgroundSize(610, 400, false, false, false, false));
        Background bGround = new Background(bgImage);
        root.setBackground(bGround);

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
        Button btnStart = new Button("Start quest");
        Button btnExit = new Button("Exit");

        /* Añadimos los botones */
        HBox botonera = new HBox(10, btnStart, btnExit);


        /* Añadimos la botonera */
        root.setBottom(botonera);
        botonera.setAlignment(Pos.TOP_CENTER);


        //root.getChildren().add(menuBar);
        root.setTop(menuBar);

        primaryStage.show();

        /** Segunda Escena*/
        StackPane root2 = new StackPane();
        Scene scene2 = new Scene(root2, 600, 400);

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
            public void handle(ActionEvent event) {
                primaryStage.setScene(scene2);
            }
        });

        btnExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.close();
            }
        });

        menu1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene(scene2);
            }
        });

        menu2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.close();
            }
        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
