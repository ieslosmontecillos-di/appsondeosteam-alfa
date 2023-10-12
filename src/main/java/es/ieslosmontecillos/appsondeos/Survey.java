package es.ieslosmontecillos.appsondeos;

import javafx.scene.control.Tab;

public abstract class Survey extends Tab {

    abstract void  makeGUI();
    abstract boolean validateSurvey();
    abstract void createSCVFile();



}
