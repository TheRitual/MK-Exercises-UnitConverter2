package com.kodilla;

public class SiUnit extends Unit{
    final private double value = 1;

    SiUnit(UnitType type, String fullName, String shortName) {
        super(type,fullName,shortName,true);
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return fullName + " [" + shortName + "] is " + type + " unit with default value " + value;
    }
}
