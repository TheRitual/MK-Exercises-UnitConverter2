package com.kodilla;

public class SiUnit {
    final private UnitType type;
    final String fullName;
    final String shortName;
    final double value = 1;

    SiUnit(UnitType type, String fullName, String shortName) {
        this.type = type;
        this.fullName = fullName;
        this.shortName = shortName;
    }
}
