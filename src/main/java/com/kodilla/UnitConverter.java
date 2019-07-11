package com.kodilla;
import java.util.*;

public class UnitConverter {
    private Set<SiUnit> siUnits;
    private Set<ExternalUnit> externalUnits;

    UnitConverter(){
        this.siUnits = new HashSet<>();
        this.externalUnits = new HashSet<>();
        this.siUnits.add(new SiUnit(UnitType.LENGTH,"meter","m"));
        this.siUnits.add(new SiUnit(UnitType.MASS,"kilogram","kg"));
        this.siUnits.add(new SiUnit(UnitType.TIME,"second","s"));
        this.siUnits.add(new SiUnit(UnitType.ELECTRIC_CURRENT,"amper","a"));
        this.siUnits.add(new SiUnit(UnitType.TEMPERATURE,"kelvin","k"));
    }

    public final double convert(Double value, String sUnitA, String sUnitB) {
        sUnitA = sUnitA.toLowerCase();
        sUnitB = sUnitB.toLowerCase();
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
                valA = value * uniA.getFactor() + uniA.getOffset();
            }

            if(unitB.isSi()) {
                SiUnit uniB = (SiUnit) unitB;
                valB = uniB.getValue() * valA;
            } else {
                ExternalUnit uniB = (ExternalUnit) unitB;
                valB = valA / uniB.getFactor() - uniB.getOffset();
            }

            return valB;
        } else {
            System.out.println("Types mismatch ::: " + unitA.fullName + " is " + unitA.getType() + " type " +
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
                .filter(siUnit -> siUnit.getShortName().equals(sUnit))
                .findFirst()
                .orElse( null);
        if (unit == null){
            unit = externalUnits.stream()
                    .filter(siUnit -> siUnit.getShortName().equals(sUnit))
                    .findFirst()
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

    public void loadStandardUnits(){
        this.addUnit(UnitType.MASS,"grams","g",0.001);
        this.addUnit(UnitType.MASS,"decagrams","dag",0.01);
        this.addUnit(UnitType.MASS,"tons","t",1000);
        this.addUnit(UnitType.MASS,"ounces","oz",0.0283495231);
        this.addUnit(UnitType.MASS,"pounds","lb",0.45359237);
        this.addUnit(UnitType.MASS,"stones","st",6.35029318);
        this.addUnit(UnitType.MASS,"quarters","qrt",12.70058636);
        this.addUnit(UnitType.MASS,"hundredweight","cwt",50.80234544);
        this.addUnit(UnitType.LENGTH,"nanometers","nm",0.000000001);
        this.addUnit(UnitType.LENGTH,"centimeters","cm",0.01);
        this.addUnit(UnitType.LENGTH,"decimeters","dm",0.1);
        this.addUnit(UnitType.LENGTH,"dekameters","dam",10);
        this.addUnit(UnitType.LENGTH,"kilometer","km",1000);
        this.addUnit(UnitType.LENGTH,"inches","in",0.0254);
        this.addUnit(UnitType.LENGTH,"feet","ft",0.3048);
        this.addUnit(UnitType.LENGTH,"yards","yd",0.9144);
        this.addUnit(UnitType.LENGTH,"chains","ch",20.1168);
        this.addUnit(UnitType.LENGTH,"furlong","fur",201.168);
        this.addUnit(UnitType.LENGTH,"miles","mi",1609.344);
        this.addUnit(UnitType.LENGTH,"league","lea",4828.032);
        this.addUnit(UnitType.LENGTH,"nautical miles","nmi",1852);
        this.addUnit(UnitType.LENGTH,"astronomical units","au",149597870700d);
        this.addUnit(UnitType.LENGTH,"light year","ly",9460730472580044d);
        this.addUnit(UnitType.ELECTRIC_CURRENT,"biots","bi",10);
        this.addUnit(UnitType.TIME,"minutes","min",60);
        this.addUnit(UnitType.TIME,"hours","h",3600);
        this.addUnit(UnitType.TIME,"days","day",86400);
        this.addUnit(UnitType.TIME,"months","mo",2629743.83);
        this.addUnit(UnitType.TIME,"years","yr",31556926);
    }

    public HashSet getAllUnits() {
        HashSet set = (HashSet)this.externalUnits;
        return (HashSet) set.clone();
    }
}
