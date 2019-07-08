package com.kodilla;

public class Main {
    public static void main(String[] args) {
        if(args.length >= 3) {
            UnitConverter converter = new UnitConverter();
            converter.loadStandardUnits();
            System.out.println(args[0] + " " + args[1] + " converted into " + args[2] + " is " + converter.convert(args[0],args[1],args[2]));
        } else {
            System.out.println("Invalid parameters. USAGE :::" +
                    "\n\tunitconverter [value] [unitA] [unitB]\"" +
                    "\n\tConverts [value] from [unitA] to [unitB]" +
                    "\n\t\texample: \"converter 100 kg lb\"");
        }
    }
}
