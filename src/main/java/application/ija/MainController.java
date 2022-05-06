package application.ija;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseButton;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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

    /**
     * Creates new UML representation of class
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
    void openFile() throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select file");
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        Scanner scanner = new Scanner(selectedFile);

        // čtení UML ze souboru a uložení hodnot do objektů
        UMLClass newClass = null;
        while (scanner.hasNextLine()) {

                    String line = scanner.nextLine();
                    if (line.equals("")){
                        continue;
                    }

                    if (line.contains("class:")){
                        newClass = new UMLClass();
                        // TODO set axis for class measurements
            //            String[] parts = line.split(":");
            //            umlClass.setAxis(parts[1].substring(1), parts[2], parts[3], parts[4].substring(0, parts[4].length() - 1));
                        continue;
                    }

                    if (line.contains("interface:")){

                        // TODO set axis for interface measurements
            //            String[] parts = line.split(":");
            //            umlClass.setAxis(parts[1].substring(1), parts[2], parts[3], parts[4].substring(0, parts[4].length() - 1));
                        continue;
                    }

                    if (line.contains("name")){
                        //String[] parts = line.split(":");
                        //DiagramClassController newClass = new DiagramClassController();
                        //newClass.changeClassName(parts[1].replaceAll("\\s+", ""));
                        continue;
                    }

                    if(line.contains("method")){
                        String[] parts = line.split(":");
                        newClass.setMethods(parts[1]);
                        continue;
                    }

                    if(line.contains("attribute")){
                        String[] parts = line.split(":");
                        String[] miniParts = parts[1].split(" ", 3);
                        continue;
                    }

                    if(line.contains("endclass") || line.contains("endinterface")){
                        ClassDiagram classDiagram = new ClassDiagram();
                        classDiagram.addUMLClass(newClass);
                        newClass = null;
                        continue;
                    }

                }
                scanner.close();

    }

}