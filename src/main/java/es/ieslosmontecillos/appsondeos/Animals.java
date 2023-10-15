package es.ieslosmontecillos.appsondeos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.text.NumberFormat;

public class Animals extends Survey{
    private GridPane grid; // Panel principal
    private HBox firstContainer;
    private GridPane secondContainer;
    private HBox thirdContainer;
    private GridPane fourthContainer;
    private GridPane fifthContainer;

    /* Separators */
    private Separator spt1;
    private Separator spt2;
    private Separator spt3;
    private Separator spt4;

    /* 1 */
    private Label lbl1;
    private VBox vbox1;
    private RadioButton rdb1;
    private RadioButton rdb2;
    private ToggleGroup toggle1;
    // 2
    private Label lbl2;
    private RadioButton rdb2_1;
    private RadioButton rdb2_2;
    private RadioButton rdb2_3;
    private RadioButton rdb2_4;
    private ToggleGroup toggle2_1;
    private TextField txt1;
    private VBox vbox2;
    // 3
    private Label lbl3;
    private RadioButton rdb3;
    private RadioButton rdb4;
    private RadioButton rdb5;
    private VBox vbox3;
    private ToggleGroup toggle2;
    // 4
    private Label lbl4;
    private RadioButton rdb6;
    private RadioButton rdb7;
    private ToggleGroup toggle3;
    private VBox vbox4;
    private Label lbl5;
    private Slider slider1;
    private Label lblSlider;
    private HBox hbox2;

    // 5
    private Label lbl6;
    private RadioButton rdb8;
    private RadioButton rdb9;
    private VBox vbox5;
    private ToggleGroup toggle4;
    private Label lbl7;
    private ComboBox combo1;

    // Buttons
    private Button btnSend;
    private Button btnClean;
    private HBox buttonPanel;
    private Label lblInfo;
    public Animals(){
        makeGUI();
        addEvents();
    }

    @Override
    void makeGUI() {
        setText("Animales");

        // Panel principal
        grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(100, 100, 100, 100));

        //Adding the CSS Class
        grid.getStylesheets().add(Sports.class.getResource("css/Animals.css").toExternalForm());
        grid.setId("main");

        /* 1 */
        lbl1 = new Label("¿Tienes animales casa?");
        toggle1 = new ToggleGroup();
        vbox1 = new VBox();
        rdb1 = new RadioButton("Si");
        rdb2 = new RadioButton("No, pero cuido el de un familiar");

        rdb1.setToggleGroup(toggle1);
        rdb2.setToggleGroup(toggle1);

        vbox1.getChildren().addAll(rdb1, rdb2);
        firstContainer = new HBox(10);
        firstContainer.getStyleClass().add("container");
        firstContainer.getChildren().addAll(lbl1, vbox1);
        //firstContainer.
        grid.add(firstContainer, 0, 0);

        // Adding a separator
        spt1 = new Separator(Orientation.HORIZONTAL);
        grid.add(spt1, 0, 1);

        // 2
        lbl2 = new Label("¿Qué piensa antes\nde adoptar un animal?");
        rdb2_1 = new RadioButton("Las necesidades de cuidado del animal");
        rdb2_2 = new RadioButton("El coste de adiestramiento y cuidado del animal");
        rdb2_3 = new RadioButton("El caracter particular del animal");
        rdb2_4 = new RadioButton("El precio de adopcion del animal");

        toggle2_1 = new ToggleGroup();
        rdb2_1.setToggleGroup(toggle2_1);
        rdb2_2.setToggleGroup(toggle2_1);
        rdb2_3.setToggleGroup(toggle2_1);
        rdb2_4.setToggleGroup(toggle2_1);

        txt1 = new TextField();
        txt1.setMinWidth(280);
        Label lbl21 = new Label("Otro: ");
        HBox hbox1 = new HBox();
        hbox1.getChildren().addAll(lbl21, txt1);
        vbox2 = new VBox(0.5);
        vbox2.getChildren().addAll(rdb2_1, rdb2_2, rdb2_3, rdb2_4, hbox1);

        secondContainer = new GridPane();
        secondContainer.setHgap(10);
        secondContainer.add(lbl2, 0, 0);
        secondContainer.add(vbox2, 1, 0);
        secondContainer.getStyleClass().add("container");

        grid.add(secondContainer, 0, 2);

        // Adding a separator
        spt2 = new Separator(Orientation.HORIZONTAL);
        grid.add(spt2, 0, 3);


        // 3
        lbl3 = new Label("¿Cuantas veces alimenta\na su mascota al día?");
        rdb3 = new RadioButton("2 veces");
        rdb4 = new RadioButton("3 veces");
        rdb5 = new RadioButton("Mas de 3 veces");
        toggle2 = new ToggleGroup();
        rdb3.setToggleGroup(toggle2);
        rdb4.setToggleGroup(toggle2);
        rdb5.setToggleGroup(toggle2);
        vbox3 = new VBox();
        vbox3.getChildren().addAll(rdb3, rdb4, rdb5);

        thirdContainer = new HBox(10);
        thirdContainer.getChildren().addAll(lbl3, vbox3);
        thirdContainer.getStyleClass().add("container");

        grid.add(thirdContainer, 0, 4);

        // Adding a separator
        spt3 = new Separator(Orientation.HORIZONTAL);
        grid.add(spt3, 0, 5);

        // 4
        lbl4 = new Label("¿Saca a su mascota a pasear?");
        rdb6 = new RadioButton("Si");
        rdb7 = new RadioButton("No");
        toggle3 = new ToggleGroup();
        rdb6.setToggleGroup(toggle3);
        rdb7.setToggleGroup(toggle3);
        vbox4 = new VBox();
        vbox4.getChildren().addAll(rdb6, rdb7);


        // 4.2
        lbl5 = new Label("¿Cuanto tiempo\naproximadamente? (minutos)");
        slider1 = new Slider(5, 60, 0);
        slider1.setShowTickLabels(true);
        slider1.setSnapToTicks(true);
        slider1.setMajorTickUnit(5);
        slider1.setMinWidth(300);
        slider1.setMinorTickCount(4);
        lblSlider = new Label();
        lblSlider.setMaxWidth(45);
        lblSlider.textProperty().bindBidirectional(slider1.valueProperty(), NumberFormat.getNumberInstance());
        hbox2 = new HBox();
        hbox2.getChildren().addAll(slider1, lblSlider);

        fourthContainer = new GridPane();
        fourthContainer.setVgap(10);
        fourthContainer.setHgap(10);
        fourthContainer.getStyleClass().add("container");
        fourthContainer.add(lbl4, 0, 0);
        fourthContainer.add(vbox4, 1, 0);
        fourthContainer.add(lbl5, 0, 1);
        fourthContainer.add(hbox2, 1, 1);

        grid.add(fourthContainer, 0, 6);


        lbl5.setVisible(false);
        slider1.setVisible(false);
        lblSlider.setVisible(false);

        // Adding a separator
        spt4 = new Separator(Orientation.HORIZONTAL);
        grid.add(spt4, 0, 8);

        // 5
        lbl6 = new Label("¿Es alérgico a algún animal?");
        rdb8 = new RadioButton("Si");
        rdb9 = new RadioButton("No");
        vbox5 = new VBox();
        vbox5.getChildren().addAll(rdb8, rdb9);
        toggle4 = new ToggleGroup();
        rdb8.setToggleGroup(toggle4);
        rdb9.setToggleGroup(toggle4);


        lbl7 = new Label("¿Cúal?");
        ObservableList<String> items = FXCollections.observableArrayList("Perros", "Gatos", "Hamsters", "Ratones", "Caballos", "Ranas", "Conejos");
        combo1 = new ComboBox<>(items);

        fifthContainer = new GridPane();
        fifthContainer.getStyleClass().add("container");
        fifthContainer.setHgap(10);
        fifthContainer.setVgap(10);
        fifthContainer.add(lbl6, 0, 0);
        fifthContainer.add(vbox5, 1, 0);
        fifthContainer.add(lbl7, 0, 1);
        fifthContainer.add(combo1, 1, 1);

        grid.add(fifthContainer, 0, 9);

        lbl7.setVisible(false);
        combo1.setVisible(false);

        /*  Send and clean button */
        btnSend = new Button("Enviar");
        btnSend.getStyleClass().add("buttons");
        btnClean = new Button("Limpiar");
        btnClean.getStyleClass().add("buttons");
        lblInfo = new Label("Contesta el cuestionario");
        lblInfo.getStyleClass().add("lblValidation");
        buttonPanel = new HBox(10);
        buttonPanel.getChildren().addAll(btnClean, btnSend);

        HBox hboxFinal = new HBox(10);
        hboxFinal.getChildren().addAll(buttonPanel, lblInfo);

        grid.add(hboxFinal, 0, 10);
        //grid.add(lblInfo, 1, 10);

        setContent(grid);
    }

    public void addEvents(){

        /** Hide and show the slider */
        rdb6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(rdb6.isSelected())
                {
                    lbl5.setVisible(true);
                    slider1.setVisible(true);
                    lblSlider.setVisible(true);
                }

            }
        });

        rdb7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(rdb7.isSelected())
                {
                    lbl5.setVisible(false);
                    slider1.setVisible(false);
                    lblSlider.setVisible(false);
                }

            }
        });

        /** Hide and show the comboBox */
        rdb8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(rdb8.isSelected())
                {
                    lbl7.setVisible(true);
                    combo1.setVisible(true);
                }

            }
        });

        rdb9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(rdb9.isSelected())
                {
                    lbl7.setVisible(false);
                    combo1.setVisible(false);
                }

            }
        });

        btnSend.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(validateSurvey())
                {
                    lblInfo.setText("--|Encuesta enviada con éxito|--");
                    lblInfo.setStyle("-fx-text-fill: green");
                    createSCVFile(getData(), "Animales");
                }
                else
                {
                    lblInfo.setText("Error: Elige al menos una opción por pregunta");
                    lblInfo.setStyle("-fx-text-fill: red");
                }
            }
        });
        btnClean.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                toggle1.selectToggle(null);
                toggle2_1.selectToggle(null);
                txt1.setText("");
                toggle2.selectToggle(null);
                toggle3.selectToggle(null);
                slider1.setValue(5);
                slider1.setVisible(false);
                lbl5.setVisible(false);
                lblSlider.setVisible(false);
                toggle4.selectToggle(null);
                combo1.setValue(null);
                combo1.setVisible(false);
                lbl7.setVisible(false);
                lblInfo.setText("Contesta el cuestionario");
                lblInfo.setStyle("-fx-text-fill: black");
            }
        });

    }
    @Override
    boolean validateSurvey() {
        if(toggle1.getSelectedToggle() == null)
            return false;
        if(toggle2_1.getSelectedToggle() == null && txt1.getText().isEmpty())
            return false;
        if(toggle2.getSelectedToggle() == null)
            return false;
        if(toggle3.getSelectedToggle() == null)
            return false;
        if(toggle4.getSelectedToggle() == null)
            return false;
        else if(rdb8.isSelected() && combo1.getSelectionModel().getSelectedItem() == null)
            return false;

        return true;
    }

    @Override
    String getData(){
        String resultTxt;
        double resultSlider;
        String resultComboBox;
        RadioButton rd1 = (RadioButton)toggle1.getSelectedToggle();
        RadioButton rd2_1;
        RadioButton rd2 = (RadioButton)toggle2.getSelectedToggle();
        RadioButton rd3 = (RadioButton)toggle3.getSelectedToggle();
        RadioButton rd4 = (RadioButton)toggle4.getSelectedToggle();

        /* Check if the second Radio buttons are not selected */
        if(toggle2_1.getSelectedToggle() == null)
            rd2_1 = new RadioButton("Nada");
        else
            rd2_1 = (RadioButton)toggle2_1.getSelectedToggle();

        /* Check if the other text field is empty */
        if(txt1.getText().isEmpty())
            resultTxt = "Nada";
        else
            resultTxt = txt1.getText();

        /* Check if the slider question is answered with no*/
        if(rdb7.isSelected())
            resultSlider = 0;
        else
            resultSlider = slider1.getValue();

        /* Check if the combo question is answered with no */
        if(rdb9.isSelected())
            resultComboBox = "Nada";
        else
            resultComboBox = (String)combo1.getValue();

        return rd1.getText() + ";" + rd2_1.getText() + ";"
                + resultTxt + ";" + rd2.getText() + ";" +
                rd3.getText() + ";" + resultSlider + ";" +
                rd4.getText() + ";" + resultComboBox;
    }


    void createSCVFile(String datos, String surveyName) {
        super.createCSVFile(datos, surveyName);
    }
}
