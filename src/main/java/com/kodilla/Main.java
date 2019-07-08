package com.kodilla;

public class Main {
    public static void main(String[] args) {
        args = new String[3];
        args[0] = "123";
        args[1] = "day";
        args[2] = "mo";
        UnitConverter converter = new UnitConverter();
        converter.loadStandardUnits();



        System.out.println(args[0] + " " + args[1] + " converted into " + args[2] + " is " + converter.convert(args[0],args[1],args[2]));
    }
}
