package com.example.ijaproject;

import java.util.ArrayList;

/**
 * @author petr_santler, michal_horejs
 * Whole class diagrams, possesing all the classes of diagram
 * */
public class ClassDiagram {
    /**
     * @param classDiagram arraylist of all the classes inside the diagram
     */
    ArrayList classDiagram = new ArrayList<UMLClass>();

    public void addClass(UMLClass obj){
        classDiagram.add(obj);
    }

    public ArrayList getClassDiagram() {
        return classDiagram;
    }

    @Override
    public String toString() {

        for (Object tmp : classDiagram){
            System.out.println(tmp);
        }
        return "";
    }


}
