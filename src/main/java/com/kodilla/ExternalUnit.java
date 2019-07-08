package com.kodilla;

public class ExternalUnit extends Unit{
    final double factor;
    final double offset;

    ExternalUnit(UnitType type, String fullName, String shortName, double factor, double offset) {
        super(type,fullName,shortName,false);
        this.factor = factor;
        this.offset = offset;
    }

    public double getFactor() {
        return factor;
    }

    public double getOffset() {
        return offset;
    }

    @Override
    public String toString() {
        return fullName + " [" + shortName + "] is " + type + " unit with factor " + factor + " and offset " + offset;
    }
}
