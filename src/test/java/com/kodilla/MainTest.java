package com.kodilla;

import org.junit.Test;

import java.util.HashSet;
import java.util.Random;

public class MainTest {
    @Test
    public void testMainOneArgument() {
        String mainArgs[];
        mainArgs = new String[]{"notNumber"};
        System.out.println("[One argument test]");
        Main.main(mainArgs);
    }

    @Test
    public void testMainTwoArguments(){
        String mainArgs[];
        mainArgs = new String[] {"notNumber", "notUnit"};
        System.out.println("[Two arguments test]");
        Main.main(mainArgs);
    }

    @Test
    public void testMainThreeArguments(){
        String mainArgs[];
        mainArgs = new String[] {"notNumber", "notUnit","anotherNotUnit"};
        System.out.println("[Three arguments test]");
        Main.main(mainArgs);
    }

    @Test
    public void testMainMixedArguments() {
        UnitConverter testConverter = new UnitConverter();
        testConverter.loadStandardUnits();
        HashSet<ExternalUnit> allExternalUnits = testConverter.getAllUnits();
        Random gen = new Random();
        int sample = 1;
        for (ExternalUnit x : allExternalUnits) {
            for (ExternalUnit y : allExternalUnits) {
                String testargs[] = new String[3];
                testargs[0] = Double.toString(gen.nextDouble()*100);
                testargs[1] = x.getShortName();
                testargs[2] = y.getShortName();
                System.out.print("[Types test " + sample + "] ");
                Main.main(testargs);
                sample++;
            }
        }
    }

    //test mismatch

    //mockito
    //spy i captor

    //git config ssh
}