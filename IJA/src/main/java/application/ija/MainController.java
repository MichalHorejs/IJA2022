package application.ija;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SplitPane;
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

    /**
     * Creates new UML representation of class
     * @param event
     */
    @FXML
    void createClass(ActionEvent event) {
        try{
            VBox newClass = FXMLLoader.load(getClass().getResource("diagram-class.fxml"));
            rightPane.getChildren().add(newClass);

        } catch (IOException e){
            System.out.println(e);
        }

    }

}