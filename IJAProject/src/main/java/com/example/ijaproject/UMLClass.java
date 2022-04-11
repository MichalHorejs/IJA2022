package com.example.ijaproject;

import java.util.ArrayList;

public class UMLClass {

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
