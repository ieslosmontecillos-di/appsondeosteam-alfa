package es.ieslosmontecillos.appsondeos;

import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class Readings extends Tab {


    StackPane root;
    HBox hbox;
    Button button1;
    Button button2;
    Button button3;



    public Readings(){
        makeGUI();

    }

    private void makeGUI() {

        hbox=new HBox();
        root=new StackPane();
        button1=new Button("Button1 readings");
        button2=new Button("Button2 readings");
        button3=new Button("button3 readings");


        hbox.getChildren().addAll(button1,button2,button3);

        root.getChildren().add(hbox);

        this.setContent(root);
    }
}
