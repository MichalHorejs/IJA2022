package com.example.ijaproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class MenuController {

    @FXML
    private MenuItem menuFileExit;

    @FXML
    private Canvas canvas;

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
                String[] parts = line.split(":");
                umlClass.setAxis(parts[1].substring(1), parts[2], parts[3], parts[4].substring(0, parts[4].length() - 1));
                continue;
            }

            if (line.contains("interface:")){
                umlClass = new UMLClass();
                umlClass.setType("interface");
                String[] parts = line.split(":");
                umlClass.setAxis(parts[1].substring(1), parts[2], parts[3], parts[4].substring(0, parts[4].length() - 1));
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
        drawClassDiagram(classDiagram);
    }

    public void drawClassDiagram(ClassDiagram classDiagram){

        ArrayList cd = classDiagram.getClassDiagram();
        GraphicsContext gc = canvas.getGraphicsContext2D();

//        UMLClass tmp = (UMLClass) cd.get(0);
//        System.out.println(classDiagram);

        for(int i = 0; i < cd.size(); i++){

            UMLClass tmp = (UMLClass) cd.get(i);
            double startX = tmp.getCenterX() - (tmp.getWidth() / 2);
            double startY = tmp.getCenterY() - (tmp.getHeight() / 2);
            double width = tmp.getWidth();
            double height = tmp.getHeight();

            gc.setStroke(Color.BLACK);
            gc.setLineWidth(2);
            gc.setLineDashes(0);

            gc.strokeLine(startX, startY, startX, startY + height);
            gc.strokeLine(startX, startY + height, startX + width, startY + height);
            gc.strokeLine(startX + width, startY + height, startX + width, startY);
            gc.strokeLine(startX + width, startY, startX, startY);

        }

    }


}
