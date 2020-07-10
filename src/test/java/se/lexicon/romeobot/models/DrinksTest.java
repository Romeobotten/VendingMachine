package se.lexicon.romeobot.models;

import junit.framework.TestCase;

public class DrinksTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
        Products cola33 = new Drinks
                ("Cola Can", "-Carbonated water, cola flavour, no fat.", 18, 33, 10);
        Products colazero33 = new Drinks
                ("Cola Zero Can", "-Carbonated water, cola flavour, no fat.", 18, 33, 0);
        Products cola50 = new Drinks
                ("Cola Bottle", "-Carbonated water, cola flavour, no fat.", 22, 50, 10);
        Products colazero50 = new Drinks
                ("Cola Zero Bottle", "-Carbonated water, cola flavour, no fat.", 22, 50, 0);

    }

    public void testGetVolume() {
    }

    public void testSetVolume() {
    }

    public void testGetSugarPercent() {
    }

    public void testSetSugarPercent() {
    }

    public void testIsSugarFree() {
    }

    public void testExamine() {
        Products cola33 = new Drinks
                ("Cola Can", "-Carbonated water, cola flavour, no fat.", 18, 33, 10);
        Products colazero33 = new Drinks
                ("Cola Zero Can", "-Carbonated water, cola flavour, no fat.", 18, 33, 0);
        Products cola50 = new Drinks
                ("Cola Bottle", "-Carbonated water, cola flavour, no fat.", 22, 50, 10);
        Products colazero50 = new Drinks
                ("Cola Zero Bottle", "-Carbonated water, cola flavour, no fat.", 22, 50, 0);
        Products[] productList = new Products[]{cola33, colazero33, cola50, colazero50};
        assertEquals("108, Price: 22 Kr. -Cola Zero Bottle    Volume: 50 cl.  " +
                "-Carbonated water, cola flavour, no fat. NO sugar!  Drink it!",productList[3].examine());
    }

    public void testUse() {
    }
}