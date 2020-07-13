package se.lexicon.romeobot.models;

import junit.framework.TestCase;
import org.junit.Test;
import se.lexicon.romeobot.Data.ProductIdSequencer;
/**
 * Arrange
 * Act
 * Assert
 */
public class DrinksTest extends TestCase {

    @Test
    public void testGetVolume() {
        // Arrange
        ProductIdSequencer.reset();
        // Act
        Drinks cola33 = new Drinks
                ("Cola Can", "-Carbonated water, cola flavour, no fat.", 18, 33, 10);
        int before = cola33.getVolume();
        cola33.setVolume(150);
        // Assert
        assertEquals(33, before);
        assertEquals(150, cola33.getVolume());
    }

    @Test
    public void testSetAndGetName() {
        // Arrange
        ProductIdSequencer.reset();
        // Act
        Products cola33 = new Drinks
                ("Cola Can", "-Carbonated water, cola flavour, no fat.", 18, 33, 10);
        String name1 = cola33.getName();
        cola33.setName("Coke Can");
        String name2 = cola33.getName();
        // Assert
        assertEquals("Cola Can", name1);
        assertEquals("Coke Can", name2);
    }

    @Test
    public void testExamine() {
        // Arrange
        ProductIdSequencer.reset();
        // Act
        Products cola33 = new Drinks
                ("Cola Can", "-Carbonated water, cola flavour, no fat.", 18, 33, 10);
        Products colazero33 = new Drinks
                ("Cola Zero Can", "-Carbonated water, cola flavour, no fat.", 18, 33, 0);
        Products cola50 = new Drinks
                ("Cola Bottle", "-Carbonated water, cola flavour, no fat.", 22, 50, 10);
        Products colazero50 = new Drinks
                ("Cola Zero Bottle", "-Carbonated water, cola flavour, no fat.", 22, 50, 0);
        Products[] productList = new Products[]{cola33, colazero33, cola50, colazero50};
        // Assert
        assertEquals("104, Price: 22 Kr. -Cola Zero Bottle    Volume: 50 cl.  " +
                "-Carbonated water, cola flavour, no fat. NO sugar!  Drink it!", productList[3].examine());
    }
}
