package com.kodilla;

public class Unit {
    final private UnitType type;
    final String fullName;
    final String shortName;
    final double factor;

    Unit(UnitType type, String fullName, String shortName, double factor, double offset) {
        this.type = type;
        this.fullName = fullName;
        this.shortName = shortName;
        this.factor = factor;
    }
}
