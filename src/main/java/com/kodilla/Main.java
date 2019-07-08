package com.kodilla;

public class Main {
    public static void main(String[] args) {
        args = new String[3];
        args[0] = "1";
        args[1] = "mi";
        args[2] = "km";
        UnitConverter converter = new UnitConverter();
        converter.addUnit(UnitType.MASS,"grams","g",0.001);
        converter.addUnit(UnitType.LENGTH,"nanometers","nm",0.000000001);
        converter.addUnit(UnitType.LENGTH,"centimeters","cm",0.01);
        converter.addUnit(UnitType.LENGTH,"decimeters","dm",0.1);
        converter.addUnit(UnitType.LENGTH,"dekameters","dam",10);
        converter.addUnit(UnitType.LENGTH,"kilometer","km",1000);
        converter.addUnit(UnitType.LENGTH,"feet","ft",0.3048);
        converter.addUnit(UnitType.LENGTH,"miles","mi",1609.344);


        System.out.println(args[0] + args[1] + " converted into " + args[2] + " is " + converter.convert(args[0],args[1],args[2]));
    }
}
