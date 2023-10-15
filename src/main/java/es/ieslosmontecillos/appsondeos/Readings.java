package es.ieslosmontecillos.appsondeos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

import java.util.Objects;

public class Readings extends Survey {

    private TextField favBookTxt;
    private TextField ageTxt;
    private TextField lecturaTxt;
    private TextField libroNoTerminadoTxt;
    private TextField libroConMasPaginasTxt;
    private TextField cantidadDePaginasTxt;
    private TextArea textArea;
    private CheckBox chb1;
    ToggleGroup genderToggle;
    RadioButton maleRadio;
    RadioButton femaleRadio;

    public Readings(){
        setText("Lecturas");
        makeGUI();

    }

    public void makeGUI()
    {



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


        Label lecturaLbl = new Label("¿Cual es su libro favorito?");
        gridInfo.add(lecturaLbl, 0, 1, 1, 1);
        favBookTxt = new TextField("");
        gridInfo.add(favBookTxt, 1, 1, 1, 1);


        Label ageLbl = new Label("Edad:");
        gridInfo.add(ageLbl, 0, 2, 1, 1);
        ageTxt = new TextField("");
        ageTxt.setPrefWidth(10);
        gridInfo.add(ageTxt, 1, 2, 1, 1);


        Label genderLbl = new Label("Seleccione su género: ");
        gridInfo.add(genderLbl, 0, 3, 1, 1);


        HBox hbGender = new HBox();
        genderToggle = new ToggleGroup();
        maleRadio = new RadioButton("Masculino");
        maleRadio.setToggleGroup(genderToggle);
        hbGender.getChildren().add(maleRadio);

        femaleRadio = new RadioButton("Femenino");
        femaleRadio.setToggleGroup(genderToggle);
        hbGender.getChildren().add(femaleRadio);

        RadioButton noRadio = new RadioButton("Sin especificar");
        noRadio.setToggleGroup(genderToggle);
        hbGender.getChildren().add(noRadio);

        gridInfo.add(hbGender, 1, 3, 1, 1);

        mainGrid.add(gridInfo, 0, 0, 1, 1);

        Separator sep1 = new Separator(Orientation.HORIZONTAL);
        mainGrid.add(sep1, 0, 1, 1, 1);

        HBox hb1;
        hb1 = new HBox(10);

        chb1 = new CheckBox("¿Tienes alguna lectura en curso?");
        chb1.setFont(new Font(17));
        lecturaTxt=new TextField();

        chb1.setOnAction(actionEvent -> {
            if (chb1.isSelected())
                lecturaTxt.setVisible(true);
            else if(!chb1.isSelected())
                lecturaTxt.setVisible(false);
        });

        hb1.getChildren().addAll(chb1,lecturaTxt);
        lecturaTxt.setVisible(false);


        mainGrid.add(hb1, 0, 2, 1, 1);

        Separator sep2;
        sep2 = new Separator(Orientation.HORIZONTAL);
        mainGrid.add(sep2, 0, 3, 1, 1);

        GridPane gridFrec;
        gridFrec = new GridPane();
        gridFrec.setVgap(5);



        Label frecTitle;
        frecTitle = new Label("Hablemos sobre libros:");
        gridFrec.add(frecTitle, 0, 1, 1, 1);

        Label frecLbl1 = new Label("Ultimo libro que no has terminado de leer");
        gridFrec.add(frecLbl1, 0, 2, 1, 1);

        libroNoTerminadoTxt=new TextField();

        gridFrec.add(libroNoTerminadoTxt, 1, 2, 1, 1);


        Label frecLbl2 = new Label("Libro con más páginas que has leido");
        gridFrec.add(frecLbl2, 0, 3, 1, 1);

        libroConMasPaginasTxt=new TextField();

        gridFrec.add(libroConMasPaginasTxt, 1, 3, 1, 1);


        Label frecLbl3 = new Label("¿Cuántas páginas tenía?");
        gridFrec.add(frecLbl3, 0, 4, 1, 1);

        cantidadDePaginasTxt=new TextField();
        gridFrec.add(cantidadDePaginasTxt, 1, 4, 1, 1);


        mainGrid.add(gridFrec, 0, 4, 1, 1);

        Separator sep3 = new Separator(Orientation.HORIZONTAL);
        mainGrid.add(sep3, 0, 5, 1, 1);


        GridPane gridIMC;
        gridIMC = new GridPane();
        gridIMC.setVgap(5);

        Label imcTitle = new Label("Reseña:");
        imcTitle.setFont(new Font(24));
        gridIMC.add(imcTitle, 0, 0, 1, 1);

        Label imcLbl1 = new Label("Vas a realizar la reseña de tu libro favorito");
        gridIMC.add(imcLbl1, 0, 1, 1, 1);

         textArea=new TextArea();
        textArea.setMinSize(400,400);
        textArea.setWrapText(true);
        gridIMC.add(textArea, 0, 2, 1, 1);

        mainGrid.add(gridIMC, 0, 6, 1, 1);


        Button sendButton = new Button("Enviar.");
        mainGrid.add(sendButton, 0, 8, 1, 1);

        sendButton.setOnAction(actionEvent -> validateSurvey());
        setContent(mainGrid);
    }

    @Override
    boolean validateSurvey() {

        int contadorDeErrores = 0;

        String text = favBookTxt.getText();
        if (text.isEmpty()) contadorDeErrores++;

        text = ageTxt.getText();
        if (text.isEmpty()) contadorDeErrores++;

        text = lecturaTxt.getText();
        if (text.isEmpty()) contadorDeErrores++;

        text = libroNoTerminadoTxt.getText();
        if (text.isEmpty()) contadorDeErrores++;

        text = libroConMasPaginasTxt.getText();
        if (text.isEmpty()) contadorDeErrores++;

        text = cantidadDePaginasTxt.getText();
        if (text.isEmpty()) contadorDeErrores++;

        text = textArea.getText();
        if (text.isEmpty()) contadorDeErrores++;

        if (contadorDeErrores == 0) {
            createCSVFile(getData(),"Lecturas");
            return true;
        }

        return false;
    }

    @Override
    String getData() {

        String gender;
        if (genderToggle.getSelectedToggle()==maleRadio){
            gender="Masculino";
        }else {
            if (genderToggle.getSelectedToggle()==femaleRadio) {
                gender = "Femenino";

            }else {
                gender="No especificado";
            }
        }


        return chb1.isSelected() ? favBookTxt.getText() + ";" +
                ageTxt.getText() + ";" +
                        gender+";" +
                lecturaTxt.getText() + ";" +
                libroNoTerminadoTxt.getText() + ";" +
                libroConMasPaginasTxt.getText() + ";" +
                cantidadDePaginasTxt.getText() + ";" +
                textArea.getText() + ";"
                :
                favBookTxt.getText() + ";" +
                ageTxt.getText() + ";" +
                        gender+";"+
                lecturaTxt.getText() + ";" +
                libroConMasPaginasTxt.getText() + ";" +
                cantidadDePaginasTxt.getText() + ";" +
                textArea.getText() + ";";
    }



    void createCSVFile(String datos, String surveyName) {
        super.createCSVFile(datos, surveyName);
    }

}
