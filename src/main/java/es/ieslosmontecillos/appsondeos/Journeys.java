package es.ieslosmontecillos.appsondeos;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Journeys extends Survey
{
    //Elements for Journeys Tab
    private GridPane grid;
    private VBox transportVB;
    private Label transportLbl;
    private ToggleGroup transportToggle;
    private RadioButton carRadio;
    private RadioButton motocycleRadio;
    private RadioButton planeRadio;
    private RadioButton boatRadio;
    private HBox frecHB;
    private Label frecLbl;
    private ChoiceBox frecChoices;

    //Constructor
    public Journeys()
    {
        makeGUI();
        addEvents();
    }

    public void makeGUI()
    {
        setText("Viajes");

        //GridPane
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(100, 100, 100, 100));

        //Transport
        transportVB = new VBox(5);

        transportToggle = new ToggleGroup();

        transportLbl = new Label("Medio de transporte preferido: ");
        transportVB.getChildren().add(transportLbl);

        carRadio = new RadioButton("Coche");
        carRadio.setToggleGroup(transportToggle);
        transportVB.getChildren().add(carRadio);

        motocycleRadio = new RadioButton("Motocicleta");
        motocycleRadio.setToggleGroup(transportToggle);
        transportVB.getChildren().add(motocycleRadio);

        planeRadio = new RadioButton("Avión");
        planeRadio.setToggleGroup(transportToggle);
        transportVB.getChildren().add(planeRadio);

        boatRadio = new RadioButton("Barco");
        boatRadio.setToggleGroup(transportToggle);
        transportVB.getChildren().add(boatRadio);

        grid.add(transportVB, 0, 1, 1, 1);

        //grid.add(transportLbl, 0, 1, 1, 1);

        /*
        transportChoices = new ChoiceBox();
        grid.add(transportChoices, 1, 1, 1, 1);

        transportChoices.getItems().add("Coche");
        transportChoices.getItems().add("Motocicleta");
        transportChoices.getItems().add("Avión");
        transportChoices.getItems().add("Barco");

        transportChoices.setValue("Seleccione su medio de transporte preferido");

         */

        //Frecuency
        frecHB = new HBox(10);

        frecLbl = new Label("¿Con qué frecuencia lo utiliza?");
        frecHB.getChildren().add(frecLbl);

        frecChoices = new ChoiceBox();
        frecHB.getChildren().add(frecChoices);

        frecChoices.getItems().add("1-6 veces al año");
        frecChoices.getItems().add("7-14 veces al año");
        frecChoices.getItems().add("15-22 veces al año");
        frecChoices.getItems().add("Más de 22 veces al año");

        frecChoices.setValue("Seleccione una frecuencia aproximada");

        grid.add(frecHB, 0, 2, 1, 1);

        setContent(grid);
    }

    @Override
    boolean validateSurvey() {



        return false;
    }

    @Override
    String getData() {
        return null;
    }

    void createSCVFile() {

    }

    public void addEvents()
    {

    }
}
