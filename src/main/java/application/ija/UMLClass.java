package application.ija;

public class UMLClass {

    private String name;
    private String attributes;
    private String methods;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes += attributes;
    }

    public String getMethods() {
        return methods;
    }

    public void setMethods(String methods) {
        this.methods += methods;
    }
}
