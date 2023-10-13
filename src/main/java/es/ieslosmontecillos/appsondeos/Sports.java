package es.ieslosmontecillos.appsondeos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class Sports extends Survey
{
    //Elements for Sports Tab
    private GridPane grid;
    private HBox hbTitle1;
    private Label titleLbl1;
    private GridPane gridInfo;
    private Label nameLbl;
    private TextField nameTxt;
    private Label ageLbl;
    private TextField ageTxt;
    private Label professionLbl;
    private TextField professionTxt;
    private HBox hbGender;
    private Label genderLbl;
    private ToggleGroup genderToggle;
    private RadioButton maleRadio;
    private RadioButton femaleRadio;
    private RadioButton noRadio;

    private HBox hbTitle2;
    private Label titleLbl2;
    private HBox hb1;
    private CheckBox chb1;
    private ChoiceBox sportsChoices;
    private HBox hb2;

    //Constructor
    public Sports()
    {
        makeGUI();
        addEvents();
    }

    public void makeGUI()
    {
        //Tab properties
        setText("Deportes");

        //GridPane
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(100, 100, 100, 100));

        //We add the CSS Class
        //grid.getStylesheets().add(Sports.class.getResource("css/Sports.css").toExternalForm());
        //grid.setId("main");

        /* PERSONAL INFO */

        gridInfo = new GridPane();

        gridInfo.setVgap(5);

        //Title
        hbTitle1 = new HBox(10);
        titleLbl1 = new Label("Información personal");
        titleLbl1.setFont(new Font(24));

        hbTitle1.getChildren().add(titleLbl1);

        gridInfo.add(hbTitle1, 0, 0, 1, 1);

        //Elements

        //Name
        nameLbl = new Label("Nombre completo:");
        gridInfo.add(nameLbl, 0, 1, 1, 1);
        nameTxt = new TextField("");
        gridInfo.add(nameTxt, 1, 1, 1, 1);

        //Age
        ageLbl = new Label("Edad:");
        gridInfo.add(ageLbl, 0, 2, 1, 1);
        ageTxt = new TextField("");
        ageTxt.setPrefWidth(10);
        gridInfo.add(ageTxt, 1, 2, 1, 1);

        //Profession
        professionLbl = new Label("Profesión:");
        gridInfo.add(professionLbl, 0, 3, 1, 1);
        professionTxt = new TextField("");
        gridInfo.add(professionTxt, 1, 3, 1, 1);

        //Gender
        genderLbl = new Label("Seleccione su género: ");
        gridInfo.add(genderLbl, 0, 4, 1, 1);

        hbGender = new HBox();

        genderToggle = new ToggleGroup();

        maleRadio = new RadioButton("Masculino");
        maleRadio.setToggleGroup(genderToggle);
        hbGender.getChildren().add(maleRadio);

        femaleRadio = new RadioButton("Femenino");
        femaleRadio.setToggleGroup(genderToggle);
        hbGender.getChildren().add(femaleRadio);

        noRadio = new RadioButton("Sin especificar");
        noRadio.setToggleGroup(genderToggle);
        hbGender.getChildren().add(noRadio);

        gridInfo.add(hbGender, 1, 4, 1, 1);

        grid.add(gridInfo, 0, 0, 1, 1);

        /* Container 2 */

        hb1 = new HBox(10);


        //Elements

        //CheckBox 1
        chb1 = new CheckBox("¿Practicas algún deporte?");
        chb1.setFont(new Font(17));

        //ChoiceBox
        sportsChoices = new ChoiceBox();

        //ChoiceBox's choices
        sportsChoices.getItems().add("Fútbol");
        sportsChoices.getItems().add("Baloncesto");
        sportsChoices.getItems().add("Tenis");
        sportsChoices.getItems().add("Golf");
        sportsChoices.getItems().add("Voleibol");
        sportsChoices.getItems().add("Natación");

        sportsChoices.setValue("Seleccione el deporte");

        //We add the elements to the Hbox 1
        hb1.getChildren().add(chb1);
        hb1.getChildren().add(sportsChoices);

        //We add the HBox 1 to the grid
        grid.add(hb1, 0, 1, 1, 1);

        /* HBox2 */

        hb2 = new HBox(10);

        //Elements

        //We add the HBox 2 to the grid
        grid.add(hb2, 0, 2, 1, 1);

        //We add the GridPane to this Tab
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

    public void addEvents()
    {
        //We set the ChoiceBox as "Hidden"
        sportsChoices.setVisible(false);

        //Event for the Checkbox
        chb1.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                if (chb1.isSelected())
                    sportsChoices.setVisible(true);
                else if(!chb1.isSelected())
                    sportsChoices.setVisible(false);
            }
        });
    }
}
