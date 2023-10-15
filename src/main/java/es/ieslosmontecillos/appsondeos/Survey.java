package es.ieslosmontecillos.appsondeos;

import javafx.scene.control.Tab;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Survey extends Tab {
    protected String surveyName;

    abstract void  makeGUI();
    abstract boolean validateSurvey();
    abstract String getData();


    void createSCVFile(String datos,String surveyName){

        try {
            File EncCSV = new File("Enc_"+surveyName+".csv");
            FileWriter escritor = new FileWriter(EncCSV);

            // We first write the local date and time
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String time = now.format(formatter);

            escritor.write(time + "\n");

            escritor.write(datos);
            escritor.close();
            System.out.println("El String se ha guardado en Enc_"+surveyName+".csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }
