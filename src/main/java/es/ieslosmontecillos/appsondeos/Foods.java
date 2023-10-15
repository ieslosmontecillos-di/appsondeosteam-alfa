package es.ieslosmontecillos.appsondeos;


/*
* In this class we have the layout of the Food survey.
*
* */


import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.text.NumberFormat;
import java.util.Objects;

public class Foods extends Survey {

    private VBox root;

    private TextField txt1;
    private ComboBox<String> combo1;

    private ComboBox<String> combo2;
    private ComboBox<String> combo3;

    private CheckBox checkBox1;


    private ObservableList<String> flavours;
    private ObservableList<String> dailyMeals;
    private ObservableList<String> diet;

    private ToggleGroup toggleGroup;

    private final RadioButton radioButton1 = new RadioButton("Si");
    private final RadioButton radioButton2 = new RadioButton("No");
    private TextField slider1;
    private TextField slider2;
    private TextField slider3;
    private Label lbl12=new Label("");
    private final Label lbl16 = new Label();

    public Foods() {
        setText("Comidas");
        makeGUI();

    }

    @Override
    public void makeGUI() {

        //here we instance every attrib of the class.
        root = new VBox();

        VBox vBox1 = new VBox();
        vBox1.setId("vBox1");
        HBox hbox1_1 = new HBox();
        HBox hbox1_2 = new HBox();
        HBox hbox1_3 = new HBox();

        VBox vBox2 = new VBox();
        vBox2.setId("vBox2");
        HBox hbox2_1 = new HBox();
        HBox hbox2_2 = new HBox();

        VBox vBox3 = new VBox();
        vBox3.setId("vBox3");
        HBox hbox3_1 = new HBox();
        HBox hbox3_2 = new HBox();
        HBox hbox3_3 = new HBox();
        HBox hbox3_4 = new HBox();

        Button sendButton = new Button("Enviar");

        Label lbl1 = new Label();
        Label lbl2 = new Label();
        Label lbl3 = new Label();
        Label lbl4 = new Label();
        Label lbl5 = new Label();
        Label lbl6 = new Label();
        Label lbl7 = new Label();
        Label lbl8 = new Label();
        Label lbl9 = new Label();
        Label lbl10 = new Label();
        Label lbl11 = new Label();
        Label lbl12 = new Label();
        Label lbl13 = new Label();
        Label lbl14 = new Label();
        Label lbl15 = new Label();


        txt1 = new TextField();

        checkBox1 = new CheckBox();

        flavours = FXCollections.observableArrayList();
        dailyMeals = FXCollections.observableArrayList();
        diet = FXCollections.observableArrayList();

        combo1 = new ComboBox<>(flavours);
        combo2 = new ComboBox<>(dailyMeals);
        combo3 = new ComboBox<>(diet);


        toggleGroup = new ToggleGroup();

        slider1 = new TextField();
        slider2 = new TextField();
        slider3 = new TextField();

        // End


        //Adding the options of the checkboxs
        flavours.addAll("Dulce", "Salado", "Amargo", "Ácido", "Umami");
        dailyMeals.addAll("Dos o menos", "Tres o cuatro", "Cinco o más");
        diet.addAll("Vegana", "Vegetariana", "Sin lactosa", "Sin gluten", "Sin huevo", "Islámica", "Judía", "India", "Sin frutos secos", "Sin soja", "Sin Carne", "Sin marisco");
        //End


        //setting the round Buttons to their respective toggle group.
        radioButton1.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);
        //End

        //first third of the survey


            GridPane mainGrid = new GridPane();
            mainGrid.setAlignment(Pos.CENTER);
            mainGrid.setHgap(11);
            mainGrid.setVgap(10);
            mainGrid.setPadding(new Insets(100, 100, 100, 100));

            try {
                mainGrid.getStylesheets().add(Objects.requireNonNull(Sports.class.getResource("css/Sports.css")).toExternalForm());
                mainGrid.setId("main");
            } catch(NullPointerException e){
                System.out.println("No se ha podido añadir el css a la aplicación");

            }



            GridPane gridInfo = new GridPane();
            gridInfo.setVgap(5);


           lbl1.setText("¿Cual es tu comida favorita?");
            gridInfo.add(lbl1, 0, 1, 1, 1);
            txt1 = new TextField("");
            gridInfo.add(txt1, 1, 1, 1, 1);


           lbl2.setText("¿Cual es tu sabor favorito?");
            gridInfo.add(lbl2, 0, 2, 1, 1);

            gridInfo.add(combo1, 1, 2, 1, 1);


            lbl3.setText("¿Cuantas comidas diarias haces?");
            gridInfo.add(lbl3, 0, 3, 1, 1);


            gridInfo.add(combo2, 1, 3, 1, 1);

            mainGrid.add(gridInfo, 0, 0, 1, 1);

            HBox hb1;
            hb1 = new HBox(10);




            lbl4.setText("¿Consideras que haces buena comida?");
            hb1.getChildren().addAll(lbl4,radioButton1,radioButton2);

            mainGrid.add(hb1, 0, 2, 1, 1);


        HBox hb2;
        hb2 = new HBox(10);
        lbl5.setText("¿Haces algún tipo de dieta especial?");
        mainGrid.add(lbl5, 0, 5, 1, 1);
        hb2.getChildren().addAll(lbl5,checkBox1);
        mainGrid.add(hb2, 0, 3, 1, 1);

        HBox hb3;
        hb3 = new HBox(10);
        hb3.setVisible(false);

        hb3.getChildren().add(combo3);
        mainGrid.add(hb3, 0, 4, 1, 1);


        checkBox1.setOnAction(actionEvent -> hb3.setVisible(checkBox1.isSelected()));
            GridPane gridIMC;
            gridIMC = new GridPane();
            gridIMC.setVgap(5);

            Label imcTitle = new Label("Habilidades:");
            imcTitle.setFont(new Font(24));
            gridIMC.add(imcTitle, 0, 0, 1, 1);
            lbl6.setText("Marca del 1 al 10 su experiencia cocinando con:");
            gridIMC.add(lbl6, 0, 1, 1, 1);



            lbl7.setText("Horno");
            gridIMC.add(lbl7, 0, 2, 2, 1);
            gridIMC.add(slider1, 1, 2, 2, 1);


            lbl8.setText("plancha");

             gridIMC.add(lbl8, 0, 3, 2, 1);
             gridIMC.add(slider2, 1, 3, 2, 1);

            lbl9.setText("Olla");
            gridIMC.add(lbl9, 0, 4, 2, 1);
            gridIMC.add(slider3,1,4,2,1);



            mainGrid.add(gridIMC, 0, 6, 1, 1);
            mainGrid.add(sendButton,2,7,2,2);

            sendButton.setOnAction(actionEvent -> validateSurvey());
        mainGrid.add(lbl12,0,8,2,2);
            setContent(mainGrid);

    }


    @Override
    public boolean validateSurvey() {
        int contadorDeErrores = 0;
        String text = txt1.getText();
        if (text.isEmpty()) contadorDeErrores++;
        if (combo1.getValue() == null) contadorDeErrores++;
        if (combo2.getValue() == null) contadorDeErrores++;
        if (toggleGroup.getSelectedToggle() == null) contadorDeErrores++;


        if (contadorDeErrores == 0) {
            createCSVFile(getData(),"Comidas");
            lbl12.setText("");
        }else{
            lbl12.setText("Existen errores en tus respuestas.");
            lbl12.setVisible(true);
        }

        return true;
    }

    @Override
    String getData() {

        String sino;
        if(toggleGroup.getSelectedToggle()==radioButton1){
            sino="si";
        } else{
            sino="no";
        }

        return txt1.getText() + ";" + combo1.getValue() + ";" + combo2.getValue() + ";" + combo3.getValue() + ";" + sino + ";"+slider1.getText()+";" + slider2.getText() + ";" + slider3.getText()+";";

    }

    void createCSVFile(String datos, String surveyName) {
        super.createCSVFile(datos, surveyName);
    }
}
/*
*
* método para validar esta clase
* método para pasar esta clase a texto o binario.
* */