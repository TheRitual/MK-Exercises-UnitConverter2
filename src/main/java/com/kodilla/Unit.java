package com.kodilla;

public abstract class Unit implements UnitInterface{
    protected UnitType type;
    protected String fullName;
    protected String shortName;
    protected boolean si;

    Unit(UnitType type, String fullName, String shortName, boolean isSi) {
        this.type = type;
        this.fullName = fullName;
        this.shortName = shortName;
        this.si = isSi;
    }

    public UnitType getType() {
        return type;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public boolean isSi(){
        return this.si;
    }

    @Override
    public String toString() {
        return fullName + " [" + shortName + "] is " + type + " unit";
    }
}