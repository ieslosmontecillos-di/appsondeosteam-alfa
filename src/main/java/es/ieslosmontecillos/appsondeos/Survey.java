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


    void createCSVFile(String data, String surveyName){

        try {
            File EncCSV = new File("src/main/surveyResults/Enc_" + surveyName + ".csv");
            FileWriter writer = new FileWriter(EncCSV, true);

            // Get the current date and hour
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String time = now.format(formatter);

            // Write date and hour before the data
            writer.write(time + "\n");

            // Write data
            writer.write(data + "\n\n");

            writer.close();
            System.out.println("El String se ha guardado en Enc_" + surveyName + ".csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }
