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

    public UMLClass getClass(String name){
        for (int i = 0; i < classDiagram.size(); i++){
            UMLClass tmp = (UMLClass) classDiagram.get(i);

            if (tmp.getName().equals(name)){
                return tmp;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        for (Object tmp : classDiagram){
            System.out.println(tmp);
        }
        return "";
    }
}
