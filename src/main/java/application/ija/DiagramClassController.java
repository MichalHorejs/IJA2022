package application.ija;

import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * Controller for specific UML class object
 */
public class DiagramClassController {

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
        if (event.getButton() == MouseButton.SECONDARY){
            AnchorPane parent = (AnchorPane) classPane.getParent();
            parent.getChildren().remove(classPane);

        }else{
            className.setText("Ahoj");
        }
    }

    /**
     * Detection of UML class drag
     * @param event
     */
    @FXML
    void dragDetected(MouseEvent event) {

        Dragboard db = classPane.startDragAndDrop(TransferMode.MOVE);
        ClipboardContent content = new ClipboardContent();
        content.putString("UML class");

        db.setContent(content);
        event.consume();

    }

}
