package es.ieslosmontecillos.appsondeos;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class Sports extends Survey
{
    //Elements for Sports Tab
    private GridPane mainGrid;
    private GridPane gridInfo;
    private Label titleLbl1;
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
    private Separator sep1;
    private HBox hb1;
    private CheckBox chb1;
    private ComboBox sportsChoices;
    private Separator sep2;
    private GridPane gridFrec;
    private Label titleLbl2;
    private Label frecTitle;
    private Label frecLbl1;
    private Slider frecSlider1;
    private Label frecValue1;
    private Label frecLbl2;
    private Slider frecSlider2;
    private Label frecValue2;
    private Label frecLbl3;
    private Slider frecSlider3;
    private Label frecValue3;
    private Separator sep3;
    private GridPane gridIMC;
    private Label imcTitle;
    private Label imcLbl1;
    private Button imcBtn;
    private GridPane hiddenGridIMC;
    private Label imcLblWg;
    private TextField imcTxtWg;
    private Label imcLblHg;
    private TextField imcTxtHg;
    private Button imcBtnCalc;
    private Label imcResult;
    private Button sendBtn;
    private Label sendLbl;

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
        mainGrid = new GridPane();
        mainGrid.setAlignment(Pos.CENTER);
        mainGrid.setHgap(10);
        mainGrid.setVgap(10);
        mainGrid.setPadding(new Insets(100, 100, 100, 100));

        //We add the CSS Class
        mainGrid.getStylesheets().add(Sports.class.getResource("css/Sports.css").toExternalForm());
        mainGrid.setId("main");

        /* PERSONAL INFO */

        gridInfo = new GridPane();
        gridInfo.setVgap(5);

        //Title
        titleLbl1 = new Label("Información personal");
        titleLbl1.setFont(new Font(24));

        gridInfo.add(titleLbl1, 0, 0, 1, 1);

        //Elements

        //Profession
        professionLbl = new Label("Profesión:");
        gridInfo.add(professionLbl, 0, 1, 1, 1);
        professionTxt = new TextField("");
        gridInfo.add(professionTxt, 1, 1, 1, 1);

        //Age
        ageLbl = new Label("Edad:");
        gridInfo.add(ageLbl, 0, 2, 1, 1);
        ageTxt = new TextField("");
        ageTxt.setPrefWidth(10);
        gridInfo.add(ageTxt, 1, 2, 1, 1);

        //Gender
        genderLbl = new Label("Seleccione su género: ");
        gridInfo.add(genderLbl, 0, 3, 1, 1);

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

        gridInfo.add(hbGender, 1, 3, 1, 1);

        mainGrid.add(gridInfo, 0, 0, 1, 1);

        //Separator 1
        sep1 = new Separator(Orientation.HORIZONTAL);
        mainGrid.add(sep1, 0, 1, 1, 1);


        /* CONTAINER 2 */

        hb1 = new HBox(10);

        //Elements

        //CheckBox 1
        chb1 = new CheckBox("¿Practicas algún deporte?");
        chb1.setFont(new Font(17));

        //ComboBox
        sportsChoices = new ComboBox();

        //ComboBox's choices
        sportsChoices.getItems().addAll("Fútbol", "Baloncesto", "Tenis", "Golf", "Voleibol", "Natación");
        sportsChoices.setValue("Seleccione el deporte");

        //We add the elements to the Hbox 1
        hb1.getChildren().add(chb1);
        hb1.getChildren().add(sportsChoices);

        //We add the HBox 1 to the grid
        mainGrid.add(hb1, 0, 2, 1, 1);

        //Separator 2
        sep2 = new Separator(Orientation.HORIZONTAL);
        mainGrid.add(sep2, 0, 3, 1, 1);


        /* FRECUENCY */

        //Container
        gridFrec = new GridPane();
        gridFrec.setVgap(5);

        //Elements
        titleLbl2 = new Label("Aficiones");
        titleLbl2.setFont(new Font(24));
        gridFrec.add(titleLbl2, 0, 0, 1, 1);

        frecTitle = new Label("Marque su grado de frecuencia a: ");
        gridFrec.add(frecTitle, 0, 1, 1, 1);

        //Labels and Sliders for Frecuency

        //Frecuency 1
        frecLbl1 = new Label("Salir de fiesta");
        gridFrec.add(frecLbl1, 0, 2, 1, 1);

        frecSlider1 = new Slider(0, 10, 0);
        frecSlider1.setSnapToTicks(true);
        frecSlider1.setMajorTickUnit(1);
        frecSlider1.setMinorTickCount(0);

        gridFrec.add(frecSlider1, 1, 2, 1, 1);

        frecValue1 = new Label("0");
        gridFrec.add(frecValue1, 2, 2, 1, 1);


        //Frecuency 2
        frecLbl2 = new Label("Comer saludable");
        gridFrec.add(frecLbl2, 0, 3, 1, 1);

        frecSlider2 = new Slider(0, 10, 0);
        frecSlider2.setSnapToTicks(true);
        frecSlider2.setMajorTickUnit(1);
        frecSlider2.setMinorTickCount(0);

        gridFrec.add(frecSlider2, 1, 3, 1, 1);

        frecValue2 = new Label("0");
        gridFrec.add(frecValue2, 2, 3, 1, 1);

        //Frecuency 3
        frecLbl3 = new Label("Realizar ejercicio");
        gridFrec.add(frecLbl3, 0, 4, 1, 1);

        frecSlider3 = new Slider(0, 10, 0);
        frecSlider3.setSnapToTicks(true);
        frecSlider3.setMajorTickUnit(1);
        frecSlider3.setMinorTickCount(0);

        gridFrec.add(frecSlider3, 1, 4, 1, 1);

        frecValue3 = new Label("0");
        gridFrec.add(frecValue3, 2, 4, 1, 1);

        //We add the HBox 2 to the grid
        mainGrid.add(gridFrec, 0, 4, 1, 1);

        //Separator 3
        sep3 = new Separator(Orientation.HORIZONTAL);
        mainGrid.add(sep3, 0, 5, 1, 1);


        /* IMC */

        gridIMC = new GridPane();
        gridIMC.setVgap(5);

        imcTitle = new Label("IMC (Índice de Masa Corporal)");
        imcTitle.setFont(new Font(24));
        gridIMC.add(imcTitle, 0, 0, 1, 1);

        imcLbl1 = new Label("¿Deseas conocer tu IMC?");
        gridIMC.add(imcLbl1, 0, 1, 1, 1);

        imcBtn = new Button("Conocer su IMC");
        gridIMC.add(imcBtn, 0, 2, 1, 1);

        //Hidden GridPane
        hiddenGridIMC = new GridPane();
        hiddenGridIMC.setVgap(5);
        hiddenGridIMC.setVisible(false);

        imcLblWg = new Label("Introduzca su peso(kg):");
        hiddenGridIMC.add(imcLblWg, 0, 0, 1, 1);
        imcTxtWg = new TextField();
        hiddenGridIMC.add(imcTxtWg, 0, 1, 1, 1);

        imcLblHg = new Label("Introduzca su estatura(cm):");
        hiddenGridIMC.add(imcLblHg, 0, 2, 1, 1);
        imcTxtHg = new TextField();
        hiddenGridIMC.add(imcTxtHg, 0, 3, 1, 1);

        imcBtnCalc = new Button("Calcular");
        hiddenGridIMC.add(imcBtnCalc, 0, 4, 1, 1);

        imcResult = new Label("");
        hiddenGridIMC.add(imcResult, 1, 4, 1, 1);

        gridIMC.add(hiddenGridIMC, 0, 3, 1, 1);

        //We add the Grid of IMC to the Main Grid
        mainGrid.add(gridIMC, 0, 6, 1, 1);

        /* SEND */
        sendBtn = new Button("Enviar");
        sendBtn.setAlignment(Pos.CENTER);
        mainGrid.add(sendBtn, 0, 7, 1, 1);

        sendLbl = new Label("");
        mainGrid.add(sendLbl, 0, 8, 1, 1);

        //Finallly, we add the GridPane to this Tab
        setContent(mainGrid);
    }

    //Method to validate each field of the survey
    @Override
    boolean validateSurvey()
    {
        boolean isValid = true;
        StringBuilder errorMessage = new StringBuilder("Error en la encuesta: ");

        if (professionTxt.getText().isEmpty())
        {
            isValid = false;
            errorMessage.append("Profesión, ");
        }

        if (ageTxt.getText().isEmpty())
        {
            isValid = false;
            errorMessage.append("Edad, ");
        }
        else
        {
            // Verify if "age" contains correct number values
            try
            {
                int age = Integer.parseInt(ageTxt.getText());
                if (age <= 0)
                {
                    isValid = false;
                    errorMessage.append("Edad no válida, ");
                }
                else if(age < 18)
                {
                    isValid = false;
                    errorMessage.append("Esta encuesta no está permitida para menores de edad.");
                }
            }
            catch (NumberFormatException e)
            {
                isValid = false;
                errorMessage.append("Edad no válida, ");
            }
        }

        if (genderToggle.getSelectedToggle() == null)
        {
            isValid = false;
            errorMessage.append("Género, ");
        }

        if (chb1.isSelected() && sportsChoices.getSelectionModel().isEmpty())
        {
            isValid = false;
            errorMessage.append("Deporte, ");
        }

        if (hiddenGridIMC.isVisible())
        {
            if (imcTxtWg.getText().isEmpty() || imcTxtHg.getText().isEmpty())
            {
                isValid = false;
                errorMessage.append("Peso o estatura para IMC, ");
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
    String getData()
    {
        StringBuilder data = new StringBuilder();

        // Profession
        data.append(professionTxt.getText()).append(",");

        // Age
        data.append(ageTxt.getText()).append(",");

        // Gender
        Toggle selectedGender = genderToggle.getSelectedToggle();
        if (selectedGender != null)
        {
            RadioButton selectedRadio = (RadioButton) selectedGender;
            data.append(selectedRadio.getText()).append(",");
        } else
            data.append("Sin especificar,");

        // Sport
        if (chb1.isSelected() && sportsChoices.getSelectionModel().getSelectedItem() != null)
            data.append(sportsChoices.getSelectionModel().getSelectedItem().toString()).append(",");
        else
            data.append("No especificado,");

        // Frecuency
        data.append(frecSlider1.getValue()).append(",");
        data.append(frecSlider2.getValue()).append(",");
        data.append(frecSlider3.getValue()).append(",");

        // IMC
        if (hiddenGridIMC.isVisible())
        {
            String weight = imcTxtWg.getText();
            String height = imcTxtHg.getText();
            try
            {
                double weightValue = Double.parseDouble(weight);
                double heightValue = Double.parseDouble(height) / 100;
                double imc = weightValue / (heightValue * heightValue);
                data.append(String.format("%.2f", imc));
            }
            catch (NumberFormatException e)
            {
                data.append("No especificado");
            }
        }
        else
            data.append("No especificado");

        return data.toString();
    }

    public void addEvents()
    {
        /* EVENT FOR THE COMBOBOX OBJECT */

        //We set the ComboBox as "Hidden"
        sportsChoices.setVisible(false);

        //Listener that hide and show the ComboBox
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


        /* EVENT FOR THE SLIDE OBJECT */

        frecSlider1.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue)
            {
                    frecValue1.textProperty().setValue(
                            String.valueOf(newValue.intValue())
                    );
            }
        });

        frecSlider2.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue)
            {
                frecValue2.textProperty().setValue(
                        String.valueOf(newValue.intValue())
                );
            }
        });

        frecSlider3.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue)
            {
                frecValue3.textProperty().setValue(
                        String.valueOf(newValue.intValue())
                );
            }
        });

        /* EVENT TO SHOW "HiddenGridIMC" */

        imcBtn.setOnAction(actionEvent -> {
            hiddenGridIMC.setVisible(true);
        });

        /* EVENT TO CALCULATE ICM */

        imcBtnCalc.setOnAction(actionEvent -> {
            try
            {
                double weight = Double.parseDouble(imcTxtWg.getText());
                double height = (Double.parseDouble(imcTxtHg.getText()))/100;

                double imc = weight / (height * height);

                String result = String.format("Tu IMC es: %.2f", imc);

                imcResult.setText(result);
            }
            catch (NumberFormatException e)
            {
                imcResult.setText("Por favor, ingrese valores válidos.");
            }
        });

        /* EVENT TO VALIDATE THE SURVEY */
        sendBtn.setOnAction(actionEvent -> {
            if(validateSurvey())
            {
                sendLbl.setText("Encuesta enviada con éxito");
                createCSVFile(getData(), "Deportes");
            }
        });
    }
}
