package application.ija;

import java.util.ArrayList;

public class ClassDiagram {

    private ArrayList classDiagram;

    public ClassDiagram() {
        this.classDiagram = new ArrayList<UMLClass>();
    }

    public void addUMLClass(UMLClass newClass){
        classDiagram.add(newClass);
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
