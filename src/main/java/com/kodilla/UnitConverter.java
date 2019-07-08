package com.kodilla;

import javafx.scene.Parent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UnitConverter {
    private List<SiUnit> siUnits;
    private List<ExternalUnit> externalUnits;

    UnitConverter(){
        this.siUnits = new ArrayList<>();
        this.externalUnits = new ArrayList<>();
        this.siUnits.add(new SiUnit(UnitType.LENGTH,"meter","m"));
        this.siUnits.add(new SiUnit(UnitType.MASS,"kilogram","kg"));
        this.siUnits.add(new SiUnit(UnitType.TIME,"second","s"));
        this.siUnits.add(new SiUnit(UnitType.ELECTRIC_CURRENT,"amper","a"));
        this.siUnits.add(new SiUnit(UnitType.TEMPERATURE,"kelvin","k"));
    }

    public final double convert(Double value, String sUnitA, String sUnitB) {
        Unit unitA = getUnit(sUnitA);
        Unit unitB = getUnit(sUnitB);

        if( unitA == null ) {
            System.out.println("Can't recognize unit A -> " + sUnitA);
            return 0;
        }

        if( unitB == null ) {
            System.out.println("Can't recognize unit B -> " + sUnitB);
            return 0;
        }

        if(unitA.getType() == unitB.getType()) {
            double valA, valB;

            if(unitA.isSi()) {
                SiUnit uniA = (SiUnit) unitA;
                valA = uniA.getValue() * value;
            } else {
                ExternalUnit uniA = (ExternalUnit) unitA;
                valA = value * uniA.getFactor();
            }

            if(unitB.isSi()) {
                SiUnit uniB = (SiUnit) unitB;
                valB = uniB.getValue() * valA;
            } else {
                ExternalUnit uniB = (ExternalUnit) unitB;
                valB = valA / uniB.getFactor();
            }

            return valB;
        } else {
            System.out.println("Types mismatch." + unitA.fullName + " is " + unitA.getType() + " type " +
                    "and " + unitB.fullName + " is " + unitB.getType() + " type");
            return 0;
        }
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

    private Unit getUnit(String sUnit) {
        Unit unit = siUnits.stream()
                .filter(siUnit -> siUnit.getShortName() == sUnit)
                .findAny()
                .orElse( null);

        if (unit == null){
            unit = externalUnits.stream()
                    .filter(siUnit -> siUnit.getShortName() == sUnit)
                    .findAny()
                    .orElse( null);
        }

        return unit;
    }

    public void addUnit(UnitType type, String fullName, String shortName, double factor, double offset) {
        this.externalUnits.add(new ExternalUnit(type, fullName, shortName, factor, offset));
    }

    public void addUnit(UnitType type, String fullName, String shortName, double factor) {
        this.addUnit(type, fullName, shortName, factor, 0);
    }
}
