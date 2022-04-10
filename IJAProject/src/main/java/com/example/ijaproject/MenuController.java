package com.example.ijaproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    private MenuItem menuFileExit;

    @FXML
    void exitProgram(ActionEvent event) {
        System.exit(0);

    }

    @FXML
    void openFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select file");
        
    }

}
