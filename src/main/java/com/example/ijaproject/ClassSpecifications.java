package com.example.ijaproject;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * @author petr_santler, michal_horejs
 * specifying class parts such as name, attributes, methods
 * */
public class ClassSpecifications extends UMLClass{

    private TextField titleTextField;


    public VBox fetchUpdateContentsDialog(){
        VBox vbox = new VBox();
        HBox hbox = new HBox();
        HBox hbox2 = new HBox();
        HBox hbox3 = new HBox();
        Label titleLabel = new Label("Title: ");
        titleTextField = new TextField(getName());
        hbox.getChildren().add(titleLabel);
        hbox.getChildren().add(titleTextField);
        vbox.getChildren().add(hbox);
        return vbox;
    }
}
