package com.example.ijaproject;


/**
 * @author petr_santler, michal_horejs
 * defining attribute class and its components
 * */
public class UMLAttribute {

    private String modifier;
    private String dataType;
    private  String attrName;

    /**
     *
     * @param modifier modifiers of attributes, value can be of +, -, #, ~
     * @param dataType data types given to attribute
     * @param attrName name given to attribute
     */
    public UMLAttribute(String modifier, String dataType, String attrName) {
        this.modifier = modifier.replaceAll("\\s+","");
        this.dataType = dataType.replaceAll("\\s+","");
        this.attrName = attrName.replaceAll("\\s+","");
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    @Override
    public String toString() {
        return modifier + dataType + attrName;
    }
}
