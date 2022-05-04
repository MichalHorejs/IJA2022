package application.ija;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * Controller for specific UML class object
 */
public class DiagramClassController {

    private double xCordPressed;
    private double yCordPressed;

    @FXML
    private TextArea classFunctions;

    @FXML
    private Label className;

    @FXML
    private VBox classPane;

    @FXML
    private TextArea classVariables;

    /**
     * Changes name of class
     * @param event
     */
    @FXML
    void changeClassName(MouseEvent event) {
        className.setText("Ahoj");
    }

    @FXML
    void mousePressed(MouseEvent event) {
        // for smth in future maybe
    }


    /**
     * Relocate dragged UML class to position on mouse cursor
     * @param event
     */
    @FXML
    void mouseReleased(MouseEvent event) {
        classPane.relocate(event.getSceneX() - 208, event.getSceneY() - 26);
    }



}
