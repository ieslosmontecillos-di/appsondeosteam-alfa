package es.ieslosmontecillos.appsondeos;


/*
* In this class we have the layout of the Food survey.
*
* */


import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import java.util.Objects;

public class Foods extends Survey {
    private TextField txt1;
    private ComboBox<String> combo1;
    private ComboBox<String> combo2;
    private ComboBox<String> combo3;
    private CheckBox checkBox1;
    private ToggleGroup toggleGroup;
    private final RadioButton radioButton1 = new RadioButton("Si");
    private final RadioButton radioButton2 = new RadioButton("No");
    private TextField slider1;
    private TextField slider2;
    private TextField slider3;
    private Label sendLbl;

    public Foods() {
        setText("Comidas");
        makeGUI();

    }

    @Override
    public void makeGUI() {

        //here we instance every attrib of the class.

        VBox vBox1 = new VBox();
        vBox1.setId("vBox1");

        VBox vBox2 = new VBox();
        vBox2.setId("vBox2");

        VBox vBox3 = new VBox();
        vBox3.setId("vBox3");

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

        txt1 = new TextField();

        checkBox1 = new CheckBox();

        ObservableList<String> flavours = FXCollections.observableArrayList();
        ObservableList<String> dailyMeals = FXCollections.observableArrayList();
        ObservableList<String> diet = FXCollections.observableArrayList();

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
                mainGrid.getStylesheets().add(Objects.requireNonNull(Foods.class.getResource("css/Foods.css")).toExternalForm());
                mainGrid.setId("main");
            } catch(NullPointerException e){
                System.out.println("No se ha podido añadir el css a la aplicación");

            }



            GridPane gridInfo = new GridPane();
            gridInfo.setVgap(5);
        gridInfo.getStyleClass().add("container");

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

            Separator sp1=new Separator();


        GridPane gridAux = new GridPane();
        gridAux.getStyleClass().add("container");

            mainGrid.add(sp1, 0, 2, 1, 1);
            HBox hb1;
            hb1 = new HBox(10);




            lbl4.setText("¿Consideras que haces buena comida?");
            hb1.getChildren().addAll(lbl4,radioButton1,radioButton2);

            gridAux.add(hb1, 0, 1, 1, 1);


        HBox hb2;
        hb2 = new HBox(10);
        lbl5.setText("¿Haces algún tipo de dieta especial?");
        hb2.getChildren().addAll(lbl5,checkBox1);
        gridAux.add(hb2, 0, 2, 1, 1);


        HBox hb3;
        hb3 = new HBox(10);

        gridAux.add(hb3,0,3,1,2);
        hb3.setVisible(false);

        hb3.getChildren().add(combo3);
        mainGrid.add(gridAux, 0, 5, 1, 1);


        Separator sp2=new Separator();
        mainGrid.add(sp2, 0, 6, 1, 1);
        checkBox1.setOnAction(actionEvent -> hb3.setVisible(checkBox1.isSelected()));
            GridPane gridIMC;
            gridIMC = new GridPane();
            gridIMC.setVgap(5);
        gridIMC.getStyleClass().add("container");

        Separator sp3=new Separator();
        mainGrid.add(sp3, 0, 9, 1, 1);

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



            mainGrid.add(gridIMC, 0, 7, 1, 1);
            mainGrid.add(sendButton,0,10,2,2);
        mainGrid.setStyle("-fx-background-color: #dddddd;");

            sendButton.setOnAction(actionEvent -> validateSurvey());
            setContent(mainGrid);
            sendButton.getStyleClass().add("sendButton");
        sendLbl = new Label();
        sendLbl.getStyleClass().add("container");
        sendLbl.setVisible(false);
        
        mainGrid.add(sendLbl,0,13,1,1);
        mainGrid.setId("main");
    }


    @Override
    public boolean validateSurvey() {
        StringBuilder errorMessage = new StringBuilder("Error en la encuesta: ");
        int contadorDeErrores = 0;
        String text = txt1.getText();
        if (text.isEmpty()) {
            contadorDeErrores++;
            errorMessage.append("comida favorita, ");
            txt1.setStyle("-fx-background-color: #e74c4c;");
        }
        if (combo1.getValue() == null) {
            contadorDeErrores++;
            errorMessage.append("Sabor Favorito, ");
            combo1.setStyle("-fx-background-color: #e74c4c;");
        }
        if (combo2.getValue() == null) {
            contadorDeErrores++;
            errorMessage.append("Comidas diarias, ");
            combo2.setStyle("-fx-background-color: #e74c4c;");
        }
        if (toggleGroup.getSelectedToggle() == null) {
            errorMessage.append("marca una respuesta, ");
            contadorDeErrores++;
        }
        text = slider1.getText();
        if(text.isEmpty()){
            contadorDeErrores++;
            errorMessage.append("horno, ");
            slider1.setStyle("-fx-background-color: #e74c4c;");
        }
        text = slider2.getText();
        if(text.isEmpty()){
            contadorDeErrores++;
            errorMessage.append("Plancha, ");
            slider2.setStyle("-fx-background-color: #e74c4c;");
        }
        text = slider3.getText();
        if(text.isEmpty()){
            contadorDeErrores++;
            errorMessage.append("Olla, ");
            slider3.setStyle("-fx-background-color: #e74c4c;");
        }




        if (contadorDeErrores == 0) {
            createCSVFile(getData(), "Comidas");
        }else{
            System.out.println(contadorDeErrores);
            sendLbl.setVisible(true);
            errorMessage.setLength(errorMessage.length() - 1);
            sendLbl.setText(errorMessage.toString());
            System.out.println(errorMessage);
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