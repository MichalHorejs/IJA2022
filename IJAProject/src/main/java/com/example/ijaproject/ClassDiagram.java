package com.example.ijaproject;

import java.util.ArrayList;

public class ClassDiagram {

    ArrayList classDiagram = new ArrayList<>();

    public void addClass(UMLClass obj){
        classDiagram.add(obj);
    }

    @Override
    public String toString() {

        for (Object tmp : classDiagram){
            System.out.println(tmp);
        }
        return "";
    }
}
