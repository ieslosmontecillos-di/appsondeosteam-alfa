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

public class Journeys extends Survey
{
    //Elements for Journeys Tab
    private GridPane mainGrid;
    private GridPane gridPref;
    private Label titleLbl1;
    private VBox transportVB;
    private Label transportLbl;
    private ToggleGroup transportToggle;
    private RadioButton carRadio;
    private RadioButton motocycleRadio;
    private RadioButton planeRadio;
    private RadioButton boatRadio;
    private HBox frecHB;
    private Label frecLbl;
    private ComboBox frecChoices;
    private Separator sep1;
    private GridPane gridDest;
    private Label destLbl1;
    private ToggleGroup travelToggle;
    private RadioButton yesRadio;
    private RadioButton noRadio;
    private GridPane hiddenGridDest;
    private Label destLbl2;
    private ToggleGroup imageToggle;
    private FileInputStream input1;
    private Image img1;
    private ImageView imgView1;
    private ToggleButton imgTg1;
    private FileInputStream input2;
    private Image img2;
    private ImageView imgView2;
    private ToggleButton imgTg2;
    private FileInputStream input3;
    private Image img3;
    private ImageView imgView3;
    private ToggleButton imgTg3;
    private FileInputStream input4;
    private Image img4;
    private ImageView imgView4;
    private ToggleButton imgTg4;
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
        mainGrid = new GridPane();
        mainGrid.setAlignment(Pos.CENTER);
        mainGrid.setHgap(10);
        mainGrid.setVgap(10);
        mainGrid.setPadding(new Insets(100, 100, 100, 100));

        //We add the CSS Class
        mainGrid.getStylesheets().add(Journeys.class.getResource("css/Journeys.css").toExternalForm());
        mainGrid.setId("main");

        /* PREFERENCES */

        gridPref = new GridPane();
        gridPref.setVgap(5);

        //Title
        titleLbl1 = new Label("Preferencias");
        titleLbl1.setFont(new Font(24));

        gridPref.add(titleLbl1, 0, 0, 1, 1);

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

        gridPref.add(transportVB, 0, 1, 1, 1);

        //Frecuency
        frecHB = new HBox(10);

        frecLbl = new Label("¿Con qué frecuencia lo utiliza?");
        frecHB.getChildren().add(frecLbl);

        frecChoices = new ComboBox();
        frecHB.getChildren().add(frecChoices);

        frecChoices.getItems().addAll("1-6 veces al año", "7-14 veces al año", "15-22 veces al año", "Más de 22 veces al año");
        frecChoices.setValue("Seleccione una frecuencia aproximada");

        gridPref.add(frecHB, 0, 2, 1, 1);

        //We add the Grid of Preferences to the Main Grid
        mainGrid.add(gridPref, 0, 0, 1, 1);

        //Separator 1
        sep1 = new Separator(Orientation.HORIZONTAL);
        mainGrid.add(sep1, 0, 1, 1, 1);


        /* DESTINATION */

        //Destination - Container 1
        gridDest = new GridPane();
        gridDest.setVgap(5);

        //Elements
        destLbl1 = new Label("¿Consideras que te gusta viajar?");
        gridDest.add(destLbl1, 0, 0, 1, 1);

        //Radio Buttons
        travelToggle = new ToggleGroup();

        yesRadio = new RadioButton("Sí");
        yesRadio.setToggleGroup(travelToggle);
        gridDest.add(yesRadio, 1, 0, 1, 1);

        noRadio = new RadioButton("No");
        noRadio.setToggleGroup(travelToggle);
        gridDest.add(noRadio, 2, 0, 1, 1);

        mainGrid.add(gridDest, 0, 2, 1, 1);

        //Destination - Container 2
        hiddenGridDest = new GridPane();
        hiddenGridDest.setVgap(10);
        hiddenGridDest.setVisible(false);


        //Elements
        destLbl2 = new Label("Si tuvieras que escoger un destino para tu próximo viaje, ¿cuál sería?");
        hiddenGridDest.add(destLbl2, 0, 0, 1, 1);

        //Images
        try
        {
            imageToggle = new ToggleGroup();

            //Image 1
            input1 = new FileInputStream("src\\main\\resources\\es\\ieslosmontecillos\\appsondeos\\img\\egypt.jpg");
            img1 = new Image(input1);
            imgView1 = new ImageView(img1);
            imgView1.setFitWidth(200);
            imgView1.setFitHeight(150);
            hiddenGridDest.add(imgView1, 0, 1, 1, 1);

            //ToggleButton 1
            imgTg1 = new ToggleButton("Egipto");
            imgTg1.setToggleGroup(imageToggle);
            imgTg1.setGraphic(imgView1);
            hiddenGridDest.add(imgTg1, 0, 2, 1, 1);

            //Image 2
            input2 = new FileInputStream("src\\main\\resources\\es\\ieslosmontecillos\\appsondeos\\img\\azores.jpg");
            img2 = new Image(input2);
            imgView2 = new ImageView(img2);
            imgView2.setFitWidth(200);
            imgView2.setFitHeight(150);
            hiddenGridDest.add(imgView2, 1, 1, 1, 1);

            //ToggleButton 2
            imgTg2 = new ToggleButton("Islas Azores");
            imgTg2.setToggleGroup(imageToggle);
            imgTg2.setGraphic(imgView2);
            hiddenGridDest.add(imgTg2, 1, 2, 1, 1);

            //Image 3
            input3 = new FileInputStream("src\\main\\resources\\es\\ieslosmontecillos\\appsondeos\\img\\sydney.jpg");
            img3 = new Image(input3);
            imgView3 = new ImageView(img3);
            imgView3.setFitWidth(200);
            imgView3.setFitHeight(150);
            hiddenGridDest.add(imgView3, 0, 3, 1, 1);

            //ToggleButton 3
            imgTg3 = new ToggleButton("Sydney");
            imgTg3.setToggleGroup(imageToggle);
            imgTg3.setGraphic(imgView3);
            hiddenGridDest.add(imgTg3, 0, 4, 1, 1);

            //Image 4
            input4 = new FileInputStream("src\\main\\resources\\es\\ieslosmontecillos\\appsondeos\\img\\bali.jpg");
            img4 = new Image(input4);
            imgView4 = new ImageView(img4);
            imgView4.setFitWidth(200);
            imgView4.setFitHeight(150);
            hiddenGridDest.add(imgView4, 1, 3, 1, 1);

            //ToggleButton 4
            imgTg4 = new ToggleButton("Bali");
            imgTg4.setToggleGroup(imageToggle);
            imgTg4.setGraphic(imgView4);
            hiddenGridDest.add(imgTg4, 1, 4, 1, 1);
        }
        catch (FileNotFoundException ex)
        {
            System.err.println("Image not found");
        }

        mainGrid.add(hiddenGridDest, 0, 3, 1, 1);

        /* SEND */
        sendBtn = new Button("Enviar");
        sendBtn.setAlignment(Pos.CENTER);
        mainGrid.add(sendBtn, 0, 4, 1, 1);

        sendLbl = new Label("");
        mainGrid.add(sendLbl, 0, 5, 1, 1);

        //Finallly, we add the GridPane to this Tab
        setContent(mainGrid);
    }

    //Method to validate each field of the survey
    @Override
    boolean validateSurvey()
    {
        boolean isValid = true;
        StringBuilder errorMessage = new StringBuilder("Por favor, complete los siguientes campos: ");

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
        else if (selectedTravel == yesRadio)
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
            errorMessage.setLength(errorMessage.length() - 2);
            sendLbl.setText(errorMessage.toString());
        }

        return isValid;
    }

    @Override
    String getData() {
        StringBuilder data = new StringBuilder();
        data.append("TransportePreferido;FrecuenciaTransporte;LeGustaViajar;DestinoElegido\n");

        RadioButton selectedTransport = (RadioButton) transportToggle.getSelectedToggle();
        data.append(selectedTransport.getText()).append(";");

        data.append(frecChoices.getValue()).append(";");

        Toggle selectedTravel = travelToggle.getSelectedToggle();
        data.append(selectedTravel == yesRadio ? "Sí;" : "No;");

        if (selectedTravel == yesRadio) {
            Toggle selectedDestination = imageToggle.getSelectedToggle();
            ToggleButton selectedToggleButton = (ToggleButton) selectedDestination;
            data.append(selectedToggleButton.getText());
        } else {
            data.append("No especificado");
        }

        return data.toString();
    }

    public void addEvents()
    {
        /* EVENT TO SHOW OR HIDE THE "hiddenGridDest" */

        travelToggle.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == yesRadio)
                hiddenGridDest.setVisible(true); // Mostrar cuando se selecciona "Sí"
            else
                hiddenGridDest.setVisible(false); // Ocultar en cualquier otro caso
        });

        /* EVENT TO VALIDATE THE SURVEY */
        sendBtn.setOnAction(actionEvent -> {
            if(validateSurvey())
            {
                sendLbl.setText("Encuesta enviada con éxito");
                createCSVFile(getData(), "Viajes");
            }
        });
    }
}
