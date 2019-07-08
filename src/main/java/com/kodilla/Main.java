package com.kodilla;

public class Main {
    public static void main(String[] args) {
        args = new String[3];
        args[0] = "1000";
        args[1] = "g";
        args[2] = "kg";
        UnitConverter converter = new UnitConverter();
        converter.addUnit(UnitType.MASS,"gram","g",0.0001);

        System.out.println(args[0] + args[1] + " converted into " + args[2] + " is " + converter.convert(args[0],args[1],args[2]));
    }
}
