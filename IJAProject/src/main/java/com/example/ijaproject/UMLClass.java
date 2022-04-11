package com.example.ijaproject;

import java.util.ArrayList;

public class UMLClass {

    private ArrayList attributeList = new ArrayList<>();
    private ArrayList methodList = new ArrayList<>();
    private String name;
    private String type; // interface/class
    private double height;
    private double width;

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

    @Override
    public String toString() {
        System.out.println("Name: " + name + "  Type: " + type);
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

    public void setAxis(String X, String Y) {
        double x = Double.parseDouble(X);
        double y = Double.parseDouble(Y);
        height = x;
        width = y;
    }
}
