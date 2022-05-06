package application.ija;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseButton;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main controller for whole application
 */
public class MainController {

    @FXML
    private VBox leftPane;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private MenuBar menuBar;

    @FXML
    private AnchorPane rightPane;

    @FXML
    private SplitPane splitPane;

    @FXML
    private Button classButton;

    @FXML
    private Button interfaceButton;

    ClassDiagram classDiagram = new ClassDiagram();

    /**
     * Creates new UML representation of class/interface
     * @param event
     */
    @FXML
    void createClass(ActionEvent event) {
        try{
            VBox newClass = FXMLLoader.load(getClass().getResource("diagram-class.fxml"));

            if(event.getSource() == classButton){
                newClass.getStylesheets().add(getClass().getResource("css/class.css").toExternalForm());
            }else{
                newClass.getStylesheets().add(getClass().getResource("css/interface.css").toExternalForm());
            }
            rightPane.getChildren().add(newClass);

        } catch (IOException e){
            System.out.println(e);
        }

    }

    /**
     * Moving UML class across pane
     * @param event
     */
    @FXML
    void dragOver(DragEvent event) {

        VBox vBox = (VBox) event.getGestureSource();
        vBox.relocate(event.getSceneX() - 208, event.getSceneY() - 26);
        event.consume();
    }

    /**
     * Final drop of UML class in pane and saving new coords
     * @param event
     */
    @FXML
    void dragDropped(DragEvent event) {
        // maybe some future code for saving new coords of UML class
        event.setDropCompleted(true);
        event.consume();
    }

    @FXML
    void openFile() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select file");
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        Scanner scanner = new Scanner(selectedFile);

        // čtení UML ze souboru a uložení hodnot do objektů
        UMLClass umlClass = null;
        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            if (line.equals("")){
                continue;
            }

            if (line.contains("class:") || line.contains("interface:")){
                umlClass = new UMLClass();

                String[] parts = line.split(":");
                umlClass.setType(parts[0]);
                umlClass.setxCoord(Integer.parseInt(parts[3]));
                umlClass.setyCoord(Integer.parseInt(parts[4].substring(0, parts[4].length() - 1)));
//                        System.out.println(umlClass);
//                        umlClass.setAxis(parts[1].substring(1), parts[2], parts[3], parts[4].substring(0, parts[4].length() - 1));
                continue;
            }

            if (line.contains("name:")){
                String[] parts = line.split(":");
                umlClass.setName(parts[1].substring(1));
                continue;
            }

            if(line.contains("method:")){
                String[] parts = line.split(":");
                umlClass.setMethods(parts[1].substring(1) + "\n");

                continue;
            }

            if(line.contains("attribute:")){
                String[] parts = line.split(":");
                umlClass.setAttributes(parts[1].substring(1) + "\n");

                continue;
            }

            if(line.contains("endclass") || line.contains("endinterface")){
                classDiagram.addUMLClass(umlClass);
                umlClass = null;
                continue;
            }
        }

        scanner.close();
        drawDiagram();

    }

    /**
     * Function draws all saved classes and connections to pane
     * @throws IOException
     */
    public void drawDiagram() throws IOException {

        ArrayList classList = classDiagram.getClassDiagram();

        for (int i = 0; i < classList.size(); i++){
            UMLClass tmpClass = (UMLClass) classList.get(i);
            VBox newClass = FXMLLoader.load(getClass().getResource("diagram-class.fxml"));

            if(tmpClass.getType().equals("class")){
                newClass.getStylesheets().add(getClass().getResource("css/class.css").toExternalForm());
            }else{
                newClass.getStylesheets().add(getClass().getResource("css/interface.css").toExternalForm());
            }

            Label name = (Label) newClass.getChildren().get(0);
            name.setText(tmpClass.getName());

            TextArea variables = (TextArea) newClass.getChildren().get(1);
            variables.setText(tmpClass.getAttributes());

            TextArea methods = (TextArea) newClass.getChildren().get(2);
            methods.setText(tmpClass.getMethods());

            newClass.relocate(tmpClass.getxCoord() + 208, tmpClass.getyCoord() + 26);
            rightPane.getChildren().add(newClass);
        }

    }

}