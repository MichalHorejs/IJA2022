package application.ija;

public class UMLClass {

    private String name;
    private String attributes;
    private String methods;
    private String type;
    private int xCoord;
    private int yCoord;

    public UMLClass() {
        this.attributes = "";
        this.methods = "";
    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    @Override
    public String toString() {
        return "UMLClass{" +
                "name='" + name + '\'' +
                ", attributes='" + attributes + '\'' +
                ", methods='" + methods + '\'' +
                ", type='" + type + '\'' +
                ", xCoord=" + xCoord +
                ", yCoord=" + yCoord +
                '}' + "\n\n";
    }

    public void resetAttributes(String attributes){
        this.attributes = attributes;
    }

    public void resetMethods(String methods){
        this.methods = methods;
    }
}
