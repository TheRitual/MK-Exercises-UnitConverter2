package com.kodilla;

public class Main {
    public static void main(String[] args) {
        /* args = new String[3];
        args[0] = "100";
        args[1] = "km" ;
        args[2] = "mi" ; */
        UnitConverter converter = new UnitConverter();
        converter.loadStandardUnits();
        if(args.length >= 3) {
            System.out.println(args[0] + " " + args[1] + " converted into " + args[2] + " is " + converter.convert(args[0],args[1],args[2]));
        } else {
            System.out.println("Invalid parameters. USAGE :::" +
                    "\n\tunitconverter [value] [unitA] [unitB]\"" +
                    "\n\tConverts [value] from [unitA] to [unitB]" +
                    "\n\t\texample: \"converter 100 kg lb\"");
        }
    }
}
