package es.ieslosmontecillos.appsondeos;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.text.NumberFormat;

public class Animals extends Survey{
    private GridPane grid;
    /** First question */
    private Label lbl1;
    private VBox vbox1;
    private RadioButton rdb1;
    private RadioButton rdb2;
    private ToggleGroup toggle1;
    /** Case yes */
    // 1
    private Label lbl2;
    private CheckBox cbx1;
    private CheckBox cbx2;
    private CheckBox cbx3;
    private CheckBox cbx4;
    private TextField txt1;
    private VBox vbox2;
    // 2
    private Label lbl3;
    private RadioButton rdb3;
    private RadioButton rdb4;
    private RadioButton rdb5;
    private VBox vbox3;
    private ToggleGroup toggle2;
    // 3
    private Label lbl4;
    private RadioButton rdb6;
    private RadioButton rdb7;
    private ToggleGroup toggle3;
    private VBox vbox4;
    private Label lbl5;
    private Slider slider1;
    private TextField txt2;
    private HBox hbox1;
    public Animals(){
        makeGUI();
    }

    @Override
    void makeGUI() {
        setText("Animales");

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        //grid.setPadding(new Insets(100, 100, 100, 100));

        /** First question */
        lbl1 = new Label("¿Tienes animales casa?");
        toggle1 = new ToggleGroup();
        vbox1 = new VBox();
        rdb1 = new RadioButton("Sí");
        rdb2 = new RadioButton("No");

        rdb1.setToggleGroup(toggle1);
        rdb2.setToggleGroup(toggle1);

        vbox1.getChildren().addAll(rdb1, rdb2);
        grid.add(lbl1, 0, 0);
        grid.add(vbox1, 1, 0);

        /** Case yes*/
        // 1
        lbl2 = new Label("¿Qué necesitas saber antes\nde adoptar un animal?");
        cbx1 = new CheckBox("Las necesidades de cuidado del animal");
        cbx2 = new CheckBox("El coste de adiestramiento y cuidado del animal");
        cbx3 = new CheckBox("El carácter particular del animal");
        cbx4 = new CheckBox("El precio de adopción del animal");
        txt1 = new TextField("Otra");
        vbox2 = new VBox();
        vbox2.getChildren().addAll(cbx1, cbx2, cbx3, cbx4, txt1);

        grid.add(lbl2, 0, 1);
        grid.add(vbox2, 1, 1);

        // 2
        lbl3 = new Label("¿Cuantas veces alimenta\na su mascota al día?");
        rdb3 = new RadioButton("2 veces");
        rdb4 = new RadioButton("3 veces");
        rdb5 = new RadioButton("Más de 3 veces");
        toggle2 = new ToggleGroup();
        rdb3.setToggleGroup(toggle2);
        rdb4.setToggleGroup(toggle2);
        rdb5.setToggleGroup(toggle2);
        vbox3 = new VBox();
        vbox3.getChildren().addAll(rdb3, rdb4, rdb5);

        grid.add(lbl3, 0, 2);
        grid.add(vbox3, 1, 2);


        // 3
        lbl4 = new Label("¿Saca a su mascota a pasear?");
        rdb6 = new RadioButton("Sí");
        rdb7 = new RadioButton("No");
        rdb6.setToggleGroup(toggle3);
        rdb7.setToggleGroup(toggle3);
        vbox4 = new VBox();
        vbox4.getChildren().addAll(rdb6, rdb7);
        grid.add(lbl4, 0, 3);
        grid.add(vbox4, 1, 3);

        lbl5 = new Label("¿Cuanto tiempo\naproximadamente?");
        slider1 = new Slider(5, 60, 0);
        slider1.setShowTickMarks(true);
        slider1.setShowTickLabels(true);
        slider1.setSnapToTicks(true);
        slider1.setMajorTickUnit(5);
        slider1.setMinWidth(250);
        txt2 = new TextField();
        txt2.setEditable(false);
        txt2.setMaxWidth(70); // Seguir por aquí
        txt2.textProperty().bindBidirectional(slider1.valueProperty(), NumberFormat.getNumberInstance());
        hbox1 = new HBox();
        hbox1.getChildren().addAll(slider1, txt2);
        grid.add(lbl5, 0, 4);
        grid.add(hbox1, 1, 4);

        setContent(grid);
    }

    @Override
    boolean validateSurvey() {
        return false;
    }

    @Override
    void createSCVFile() {

    }
}
