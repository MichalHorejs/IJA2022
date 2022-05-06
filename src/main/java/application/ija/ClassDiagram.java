package application.ija;

import java.util.ArrayList;
import java.util.List;

public class ClassDiagram {

    private List classList;

    public ClassDiagram() {
        this.classList = new ArrayList();
    }

    public void addUMLClass(UMLClass newClass){
        classList.add(newClass);
    }
}
