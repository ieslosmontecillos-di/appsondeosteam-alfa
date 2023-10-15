package es.ieslosmontecillos.appsondeos;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;

public class Journeys extends Survey
{
    private TextField cityTxt;
    private TextField countryTxt;
    private ToggleGroup nativeToggle;
    private RadioButton yesRadio1;
    private RadioButton noRadio1;
    private HBox nativeResHBox2;
    private TextField nativeResTxt;
    private TextField numCountTxt;
    private ToggleGroup transportToggle;
    private ComboBox<String> frecChoices;
    private ToggleGroup travelToggle;
    private RadioButton yesRadio2;
    private GridPane hiddenGridDest;
    private ToggleGroup imageToggle;
    private Button sendBtn;
    private Label sendLbl;

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
        //Elements for Journeys Tab
        GridPane mainGrid = new GridPane();
        mainGrid.setAlignment(Pos.CENTER);
        mainGrid.setHgap(10);
        mainGrid.setVgap(10);
        mainGrid.setPadding(new Insets(20, 20, 20, 20));

        //We add the CSS Class
        mainGrid.getStylesheets().add(Objects.requireNonNull(Journeys.class.getResource("css/Journeys.css")).toExternalForm());
        mainGrid.setId("main");


        /* PERSONAL INFO */

        GridPane gridInfo = new GridPane();
        gridInfo.setVgap(5);
        //We add the Class "container" from Sports.css
        gridInfo.getStyleClass().add("container");

        //Title
        Label titleLbl1 = new Label("Información personal");
        titleLbl1.setFont(new Font(24));

        gridInfo.add(titleLbl1, 0, 0, 1, 1);

        //Elements

        //City
        Label cityLbl = new Label("Introduzca su ciudad natal");
        gridInfo.add(cityLbl, 0, 1, 1, 1);
        cityTxt = new TextField("");
        gridInfo.add(cityTxt, 1, 1, 1, 1);

        //Country
        Label countryLbl = new Label("Introduzca su país natal");
        gridInfo.add(countryLbl, 0, 2, 1, 1);
        countryTxt = new TextField("");
        gridInfo.add(countryTxt, 1, 2, 1, 1);

        //Native Country
        nativeToggle = new ToggleGroup();

        Label nativeLbl = new Label("¿Reside actualmente en su país natal?");
        gridInfo.add(nativeLbl, 0, 3, 1, 1);

        HBox nativeResHBox1 = new HBox(5);

        yesRadio1 = new RadioButton("Sí");
        yesRadio1.setToggleGroup(nativeToggle);
        nativeResHBox1.getChildren().add(yesRadio1);

        noRadio1 = new RadioButton("No");
        noRadio1.setToggleGroup(nativeToggle);
        nativeResHBox1.getChildren().add(noRadio1);

        gridInfo.add(nativeResHBox1, 1, 3, 1, 1);

        nativeResHBox2 = new HBox(10);
        nativeResHBox2.setVisible(false);

        Label nativeResLbl = new Label("Introduzca su país de residencia actual: ");
        nativeResHBox2.getChildren().add(nativeResLbl);

        nativeResTxt = new TextField("");
        nativeResHBox2.getChildren().add(nativeResTxt);

        gridInfo.add(nativeResHBox2, 2, 3, 1, 1);

        //Countries visited
        Label numCountLbl = new Label("Introduzca número de países visitados: ");
        gridInfo.add(numCountLbl, 0, 4, 1, 1);
        numCountTxt = new TextField("");
        gridInfo.add(numCountTxt, 1, 4, 1, 1);

        mainGrid.add(gridInfo, 0, 0, 1, 1);

        //Separator 1
        Separator sep1 = new Separator(Orientation.HORIZONTAL);
        mainGrid.add(sep1, 0, 1, 1, 1);

        /* PREFERENCES */

        GridPane gridPref = new GridPane();
        gridPref.setVgap(5);
        //We add the Class "container" from Sports.css
        gridPref.getStyleClass().add("container");

        //Title
        Label titleLbl2 = new Label("Preferencias");
        titleLbl2.setFont(new Font(24));

        gridPref.add(titleLbl2, 0, 0, 1, 1);

        //Transport
        VBox transportVB = new VBox(5);

        transportToggle = new ToggleGroup();

        Label transportLbl = new Label("Medio de transporte preferido: ");
        transportVB.getChildren().add(transportLbl);

        RadioButton carRadio = new RadioButton("Coche");
        carRadio.setToggleGroup(transportToggle);
        transportVB.getChildren().add(carRadio);

        RadioButton motocycleRadio = new RadioButton("Motocicleta");
        motocycleRadio.setToggleGroup(transportToggle);
        transportVB.getChildren().add(motocycleRadio);

        RadioButton planeRadio = new RadioButton("Avión");
        planeRadio.setToggleGroup(transportToggle);
        transportVB.getChildren().add(planeRadio);

        RadioButton boatRadio = new RadioButton("Barco");
        boatRadio.setToggleGroup(transportToggle);
        transportVB.getChildren().add(boatRadio);

        gridPref.add(transportVB, 0, 1, 1, 1);

        //Frecuency
        HBox frecHB = new HBox(10);

        Label frecLbl = new Label("¿Con qué frecuencia lo utiliza?");
        frecHB.getChildren().add(frecLbl);

        frecChoices = new ComboBox<>();
        frecHB.getChildren().add(frecChoices);

        frecChoices.getItems().addAll("1-6 veces al año", "7-14 veces al año", "15-22 veces al año", "Más de 22 veces al año");
        frecChoices.setValue("Seleccione una frecuencia aproximada");

        gridPref.add(frecHB, 0, 2, 1, 1);

        //We add the Grid of Preferences to the Main Grid
        mainGrid.add(gridPref, 0, 2, 1, 1);

        //Separator 2
        Separator sep2 = new Separator(Orientation.HORIZONTAL);
        mainGrid.add(sep2, 0, 3, 1, 1);


        /* DESTINATION */

        //Destination - Container 1
        GridPane gridDest = new GridPane();
        gridDest.setVgap(5);
        //We add the Class "container" from Sports.css
        gridDest.getStyleClass().add("container");

        //Elements
        Label destLbl1 = new Label("¿Considera que le gusta viajar?");
        gridDest.add(destLbl1, 0, 0, 1, 1);

        //Radio Buttons
        travelToggle = new ToggleGroup();

        yesRadio2 = new RadioButton("Sí");
        yesRadio2.setToggleGroup(travelToggle);
        gridDest.add(yesRadio2, 1, 0, 1, 1);

        RadioButton noRadio2 = new RadioButton("No");
        noRadio2.setToggleGroup(travelToggle);
        gridDest.add(noRadio2, 2, 0, 1, 1);

        mainGrid.add(gridDest, 0, 4, 1, 1);

        //Destination - Container 2
        hiddenGridDest = new GridPane();
        hiddenGridDest.setVgap(10);
        //We add the Class "container" from Sports.css
        hiddenGridDest.getStyleClass().add("container");
        hiddenGridDest.setVisible(false);


        //Elements
        Label destLbl2 = new Label("Si tuvieras que escoger un destino para tu próximo viaje, ¿cuál sería?");
        hiddenGridDest.add(destLbl2, 0, 0, 1, 1);

        //Images
        try
        {
            imageToggle = new ToggleGroup();

            //Image 1
            FileInputStream input1 = new FileInputStream("src\\main\\resources\\es\\ieslosmontecillos\\appsondeos\\img\\egypt.jpg");
            Image img1 = new Image(input1);
            ImageView imgView1 = new ImageView(img1);
            imgView1.setFitWidth(200);
            imgView1.setFitHeight(150);
            hiddenGridDest.add(imgView1, 0, 1, 1, 1);

            //ToggleButton 1
            ToggleButton imgTg1 = new ToggleButton("Egipto");
            imgTg1.setToggleGroup(imageToggle);
            imgTg1.setGraphic(imgView1);
            hiddenGridDest.add(imgTg1, 0, 2, 1, 1);

            //Image 2
            FileInputStream input2 = new FileInputStream("src\\main\\resources\\es\\ieslosmontecillos\\appsondeos\\img\\azores.jpg");
            Image img2 = new Image(input2);
            ImageView imgView2 = new ImageView(img2);
            imgView2.setFitWidth(200);
            imgView2.setFitHeight(150);
            hiddenGridDest.add(imgView2, 1, 1, 1, 1);

            //ToggleButton 2
            ToggleButton imgTg2 = new ToggleButton("Islas Azores");
            imgTg2.setToggleGroup(imageToggle);
            imgTg2.setGraphic(imgView2);
            hiddenGridDest.add(imgTg2, 1, 2, 1, 1);

            //Image 3
            FileInputStream input3 = new FileInputStream("src\\main\\resources\\es\\ieslosmontecillos\\appsondeos\\img\\sydney.jpg");
            Image img3 = new Image(input3);
            ImageView imgView3 = new ImageView(img3);
            imgView3.setFitWidth(200);
            imgView3.setFitHeight(150);
            hiddenGridDest.add(imgView3, 0, 3, 1, 1);

            //ToggleButton 3
            ToggleButton imgTg3 = new ToggleButton("Sydney");
            imgTg3.setToggleGroup(imageToggle);
            imgTg3.setGraphic(imgView3);
            hiddenGridDest.add(imgTg3, 0, 4, 1, 1);

            //Image 4
            FileInputStream input4 = new FileInputStream("src\\main\\resources\\es\\ieslosmontecillos\\appsondeos\\img\\bali.jpg");
            Image img4 = new Image(input4);
            ImageView imgView4 = new ImageView(img4);
            imgView4.setFitWidth(200);
            imgView4.setFitHeight(150);
            hiddenGridDest.add(imgView4, 1, 3, 1, 1);

            //ToggleButton 4
            ToggleButton imgTg4 = new ToggleButton("Bali");
            imgTg4.setToggleGroup(imageToggle);
            imgTg4.setGraphic(imgView4);
            hiddenGridDest.add(imgTg4, 1, 4, 1, 1);
        }
        catch (FileNotFoundException ex)
        {
            System.err.println("Image not found");
        }

        mainGrid.add(hiddenGridDest, 0, 5, 1, 1);


        /* SEND */

        //Send Button
        sendBtn = new Button("Enviar");
        sendBtn.setAlignment(Pos.CENTER);

        //We add the Class "sendButton" from Journeys.css
        sendBtn.getStyleClass().add("sendButton");
        mainGrid.add(sendBtn, 0, 6, 1, 1);

        //Send Label (Result)
        sendLbl = new Label();
        //We add the Class "container" from Journeys.css
        sendLbl.getStyleClass().add("container");
        sendLbl.setVisible(false);
        mainGrid.add(sendLbl, 0, 7, 1, 1);

        //Finallly, we add the GridPane to this Tab
        setContent(mainGrid);
    }

    //Method to validate each field of the survey
    @Override
    boolean validateSurvey()
    {
        boolean isValid = true;
        StringBuilder errorMessage = new StringBuilder("Error en la encuesta: ");

        if(cityTxt.getText().isEmpty())
        {
            isValid = false;
            errorMessage.append("Ciudad natal, ");
            cityTxt.setStyle("-fx-background-color: #e74c4c;");
        }
        else
            cityTxt.setStyle("");

        if(countryTxt.getText().isEmpty())
        {
            isValid = false;
            errorMessage.append("País natal, ");
            countryTxt.setStyle("-fx-background-color: #e74c4c;");
        }
        else
            countryTxt.setStyle("");

        Toggle selectedNativeCount = nativeToggle.getSelectedToggle();

        if (selectedNativeCount == null)
        {
            isValid = false;
            errorMessage.append("¿Reside en su país natal?, ");
        }
        else if(selectedNativeCount == noRadio1)
        {
            if(nativeResTxt.getText().isEmpty())
            {
                isValid = false;
                errorMessage.append("País actual, ");
                nativeResTxt.setStyle("-fx-background-color: #e74c4c;");
            }
            else
                nativeResTxt.setStyle("");
        }

        if(numCountTxt.getText().isEmpty())
        {
            isValid = false;
            errorMessage.append("Número de países visitados, ");
            numCountTxt.setStyle("-fx-background-color: #e74c4c;");
        }
        else {
            try
            {
                int numCountriesVisited = Integer.parseInt(numCountTxt.getText());
                if (numCountriesVisited < 0)
                {
                    isValid = false;
                    errorMessage.append("Número de países visitados no válido, ");
                    numCountTxt.setStyle("-fx-background-color: #e74c4c;");
                }
                else
                    numCountTxt.setStyle("");
            }
            catch (NumberFormatException e)
            {
                isValid = false;
                errorMessage.append("Número de países visitados no válido, ");
            }
        }

        Toggle selectedTransport = transportToggle.getSelectedToggle();
        if (selectedTransport == null)
        {
            isValid = false;
            errorMessage.append("Medio de transporte preferido, ");
        }

        if (frecChoices.getSelectionModel().isEmpty())
        {
            isValid = false;
            errorMessage.append("Frecuencia de uso del transporte, ");
        }


        Toggle selectedTravel = travelToggle.getSelectedToggle();
        if (selectedTravel == null)
        {
            isValid = false;
            errorMessage.append("¿Le gusta viajar?, ");
        }
        else if (selectedTravel == yesRadio2)
        {
            Toggle selectedDestination = imageToggle.getSelectedToggle();
            if (selectedDestination == null)
            {
                isValid = false;
                errorMessage.append("Destino para su próximo viaje, ");
            }
        }

        // Delete the last comma and space of the error message
        if (!isValid)
        {
            errorMessage.setLength(errorMessage.length() - 1);
            sendLbl.setText(errorMessage.toString());
        }

        return isValid;
    }

    @Override
    String getData()
    {
        StringBuilder data = new StringBuilder();

        // Personal Info
        data.append(cityTxt.getText()).append(",");
        data.append(countryTxt.getText()).append(",");

        Toggle selectedNativeCount = nativeToggle.getSelectedToggle();

        String nativeCountValue = "";
        if (selectedNativeCount == yesRadio1)
            nativeCountValue = "Sí";
        else if (selectedNativeCount == noRadio1)
            nativeCountValue = "No";
        data.append(nativeCountValue).append(",");

        if (selectedNativeCount == noRadio1)
            data.append(nativeResTxt.getText()).append(",");
        else
            data.append(",");

        data.append(numCountTxt.getText()).append(",");

        // Preferences
        Toggle selectedTransport = transportToggle.getSelectedToggle();
        data.append(((RadioButton) selectedTransport).getText()).append(",");

        data.append(frecChoices.getValue()).append(",");

        // Destination
        Toggle selectedTravel = travelToggle.getSelectedToggle();

        String travelValue;
        if (selectedTravel == yesRadio2)
            travelValue = "Sí";
        else
            travelValue = "No";

        data.append(travelValue).append(",");

        if (selectedTravel == yesRadio2)
        {
            Toggle selectedDestination = imageToggle.getSelectedToggle();
            data.append(((ToggleButton) selectedDestination).getText());
        }
        else
            data.append("N/A");

        return data.toString();
    }

    public void addEvents()
    {
        /* EVENT TO SHOW THE FIELD "Native Country" */

        nativeToggle.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == yesRadio1)
                nativeResHBox2.setVisible(false); // Hide the HBox
            else if (newValue == noRadio1)
                nativeResHBox2.setVisible(true); // Show the HBox
        });

        /* EVENT TO SHOW OR HIDE THE "hiddenGridDest" */

        travelToggle.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            // Hide the Grid
            hiddenGridDest.setVisible(newValue == yesRadio2); // Show the Grid
        });

        /* EVENT TO VALIDATE THE SURVEY */
        sendBtn.setOnAction(actionEvent -> {
            sendLbl.setVisible(true);
            if(validateSurvey())
            {
                sendLbl.setText("Encuesta enviada con éxito");
                createCSVFile(getData(), "Viajes");
            }
        });
    }
}
