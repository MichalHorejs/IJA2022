package com.example.ijaproject;

import java.util.ArrayList;

/**
 * @author petr_santler, michal_horejs
 * Represents basic class of class diagram
 * */
public class UMLClass {
    /**
     * @param attributeList contains all attributes of class
     * @param methodList contains all methods of class
     * @param name contains name of class
     * @param type contains type of class, could be normal class or interface
     * @param height contains height of class
     * @param width contains width of class
     * @param centerX the x coordinate in the center of the object to draw
     * @param centerY the y coordinate in the center of the object to draw
     */
    private ArrayList attributeList = new ArrayList<>();
    private ArrayList methodList = new ArrayList<>();
    private String name;
    private String type; // interface/class
    private double height;
    private double width;
    private double centerX;
    private double centerY;

    public void addAttribute(UMLAttribute attr){
        attributeList.add(attr);
    }

    public void addMethod(String meth){
        methodList.add(meth);
    }

    public ArrayList getAttributeList() {
        return attributeList;
    }

    public ArrayList getMethodList() {
        return methodList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    /**
     * Sets initial values for height, width, centerX, centerY
     */
    public void setAxis(String X, String Y, String centerX, String centerY) {
        double x = Double.parseDouble(X);
        double y = Double.parseDouble(Y);
        this.centerX = Double.parseDouble(centerX);
        this.centerY = Double.parseDouble(centerY);
        height = y;
        width = x;
    }

    @Override
    public String toString() {
        System.out.println("Name: " + name + "  Type: " + type +
                "  Width: " + width + " Height: " + height +
                "   CenterX: " + centerX + " CenterY: " + centerY);
        System.out.println("Attributes:");

        for (Object umlA : attributeList){
            System.out.println(umlA);
        }

        System.out.println("Methods:");
        for (Object umlM : methodList){
            System.out.println(umlM);
        }
        return "";
    }

}
