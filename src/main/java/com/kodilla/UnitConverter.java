package com.kodilla;

import java.util.ArrayList;
import java.util.List;

public class UnitConverter {
    private List<SiUnit> siUnits;
    private List<Unit> externalUnits;

    UnitConverter(){
        this.siUnits = new ArrayList<>();
        this.externalUnits = new ArrayList<>();
        this.siUnits.add(new SiUnit(UnitType.LENGTH,"meter","m"));
        this.siUnits.add(new SiUnit(UnitType.MASS,"kilogram","kg"));
        this.siUnits.add(new SiUnit(UnitType.TIME,"second","s"));
        this.siUnits.add(new SiUnit(UnitType.ELECTRIC_CURRENT,"amper","a"));
        this.siUnits.add(new SiUnit(UnitType.TEMPERATURE,"kelvin","k"));
    }

    public final double convert(Double value, String unitA, String unitB) {

        return 0;
    }

    public void addUnit(UnitType type, String fullName, String shortName, double factor, double offset) {
        this.externalUnits.add(new Unit(type, fullName, shortName, factor, offset));
    }

    public void addUnit(UnitType type, String fullName, String shortName, double factor) {
        this.addUnit(type, fullName, shortName, factor, 0);
    }

    public final double convert(String value, String unitA, String unitB) {
        double val;
        try {
             val = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            System.out.println(e);
            return 0;
        }
        return convert(val, unitA,unitB);
    }
}
