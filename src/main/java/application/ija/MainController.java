package application.ija;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

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



}