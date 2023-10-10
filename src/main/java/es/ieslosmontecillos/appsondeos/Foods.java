package es.ieslosmontecillos.appsondeos;


/*
* In this class we have the layout of the Food survey.
*
* */


import javafx.collections.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.text.NumberFormat;

public class Foods extends Tab {

    private VBox root;
     private VBox vBox1;
    private HBox hbox1_1;
    private HBox hbox1_2;
    private HBox hbox1_3;
    private VBox vBox2;
    private  HBox hbox2_1;
    private  HBox hbox2_2;
    private VBox vBox3;
    private HBox hbox3_1;
    private HBox hbox3_2;
    private HBox hbox3_3;
    private HBox hbox3_4;

    private TextField txt1;
    private ComboBox<String>  combo1;

    private ComboBox<String>  combo2;
    private ComboBox<String>  combo3;

    private  CheckBox checkBox1;


    private ObservableList<String> flavours;
    private ObservableList<String>  dailyMeals;
    private ObservableList<String> diet;

    private ToggleGroup toggleGroup;

    private RadioButton radioButton1;
    private  RadioButton radioButton2;
    private Slider slider1;
    private Slider slider2;
    private Slider slider3;

    public Foods(){
       makeGUI();

    }

    private void makeGUI() {

         //here we instance every attrib of the class.
        root=new VBox();

        vBox1=new VBox();
            hbox1_1=new HBox();
            hbox1_2=new HBox();
            hbox1_3=new HBox();

        vBox2=new VBox();
            hbox2_1=new HBox();
            hbox2_2=new HBox();

        vBox3=new VBox();
        hbox3_1=new HBox();
        hbox3_2=new HBox();
        hbox3_3=new HBox();
        hbox3_4=new HBox();


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


        txt1=new TextField();

        checkBox1=new CheckBox();

        flavours=FXCollections.observableArrayList();
        dailyMeals=FXCollections.observableArrayList();
        diet=FXCollections.observableArrayList();

        combo1= new ComboBox<>(flavours);
        combo2= new ComboBox<>(dailyMeals);
        combo3= new ComboBox<>(diet);



        toggleGroup = new ToggleGroup();

        radioButton1=new RadioButton();
        radioButton2=new RadioButton();
        slider1=new Slider(0,100,5);
        slider2=new Slider(0,100,5);
        slider3=new Slider(0,100,5);
         // End


        //Adding the options of the checkboxs
        flavours.addAll("Dulce","Salado","Amargo","Ácido","Umami");
        dailyMeals.addAll("Dos o menos","Tres o cuatro","Cinco o más");
        diet.addAll("Vegana","Vegetariana","Sin lactosa","Sin gluten","Sin huevo","Islámica","Judía","India","Sin frutos secos","Sin soja","Sin Carne","Sin marisco");
        //End


        //setting the round Buttons to their respective toggle group.
        radioButton1.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);
        //End

        //first third of the survey

        lbl1.setText("¿Cuál es tu comida favorita?");

        hbox1_1.getChildren().addAll(lbl1,txt1);

        lbl2.setText("¿Cuál es tu sabor favorito?");
        lbl3.setText("¿cuantas comidas diarias haces?");
        hbox1_2.getChildren().addAll(lbl2,combo1, lbl3, combo2);

        lbl4.setText("¿Consideras que haces buena comida?");
        lbl5.setText("Sí:");
        lbl6.setText("No:");

        hbox1_3.getChildren().addAll(lbl4, lbl5,radioButton1, lbl6,radioButton2);


        vBox1.getChildren().addAll(hbox1_1,hbox1_2,hbox1_3);
        //end of the first third of the survey



        //Second third of the survey
        lbl7.setText("¿Haces algún tipo de dieta especial?");
        lbl8.setText("¿Cuál?");

        hbox2_1.getChildren().addAll(checkBox1, lbl7);
        hbox2_2.getChildren().addAll(lbl8, combo3);
        hbox2_2.setVisible(false);



        vBox2.getChildren().addAll(hbox2_1,hbox2_2);

        //end of the second third of the survey

        //third third of the survey

        lbl9.setText("Marque del 1 al 10 su experiencia cocinando con:");
        lbl10.setText("Horno");
        lbl12.setText("Plancha");
        lbl14.setText("Olla");
        //end of the third third of the survey

        hbox3_1.getChildren().add(lbl9);

        hbox3_2.getChildren().addAll(lbl10,slider1, lbl11);
        hbox3_3.getChildren().addAll(lbl12,slider2, lbl13);
        hbox3_4.getChildren().addAll(lbl14,slider3, lbl15);


        lbl11.textProperty().bindBidirectional(slider1.valueProperty(), NumberFormat.getNumberInstance());
        slider1.setShowTickMarks(true); // Habilitar las marcas de paso
        slider1.setMajorTickUnit(1); // Incremento de las marcas de paso
        slider1.setShowTickLabels(true); // Habilitar las etiquetas de las marcas de paso


        lbl13.textProperty().bindBidirectional(slider2.valueProperty(), NumberFormat.getNumberInstance());
        lbl15.textProperty().bindBidirectional(slider3.valueProperty(), NumberFormat.getNumberInstance());
        checkBox1.setOnAction(e-> hbox2_2.setVisible(checkBox1.isSelected()));

        vBox3.getChildren().addAll(hbox3_1, hbox3_2, hbox3_3, hbox3_4);
        root.getChildren().addAll(vBox1,vBox2,vBox3);

        root.getStylesheets().add(Foods.class.getResource("css/Foods.css").toExternalForm());
        root.setId("main");

        setContent(root);
    }

}


/*
*
* método para validar esta clase
* método para pasar esta clase a texto o binario.
* */