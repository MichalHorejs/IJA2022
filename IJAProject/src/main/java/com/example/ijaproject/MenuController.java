package com.example.ijaproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class MenuController {

    @FXML
    private MenuItem menuFileExit;

    @FXML
    void exitProgram(ActionEvent event) {
        System.exit(0);

    }

    @FXML
    void openFile(ActionEvent event) throws FileNotFoundException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select file");
        File selectedFile = fileChooser.showOpenDialog(new Stage());

        Scanner scanner = new Scanner(selectedFile);
        ClassDiagram classDiagram = new ClassDiagram();
        UMLClass umlClass = null;

        // čtení UML ze souboru a uložení hodnot do objektů
        while (scanner.hasNextLine()){

            String line = scanner.nextLine();
            if (line.equals("")){
                continue;
            }

            if (line.contains("class:")){
                umlClass = new UMLClass();
                umlClass.setType("class");
                continue;
            }

            if (line.contains("interface:")){
                umlClass = new UMLClass();
                umlClass.setType("interface");
                continue;
            }

            if (line.contains("name")){
                String[] parts = line.split(":");
                umlClass.setName(parts[1].replaceAll("\\s+",""));
                continue;
            }

            if(line.contains("method")){
                String[] parts = line.split(":");
                umlClass.addMethod(parts[1].replaceAll("\\s+",""));
                continue;
            }

            if(line.contains("attribute")){
                String[] parts = line.split(":");
                String[] miniParts = parts[1].split(" ", 3);
                umlClass.addAttribute(new UMLAttribute(miniParts[0], miniParts[1], miniParts[2]));

            }

            if(line.contains("endclass") || line.contains("endinterface")){
                classDiagram.addClass(umlClass);
                continue;
            }

        }

        scanner.close();

        //drawClassDiagram(classDiagram);
        System.out.println(classDiagram);

    }


}
