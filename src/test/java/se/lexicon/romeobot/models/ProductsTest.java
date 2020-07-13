package se.lexicon.romeobot.models;

import junit.framework.TestCase;
import org.junit.Test;
import se.lexicon.romeobot.Data.ProductIdSequencer;
/**
 * Arrange
 * Act
 * Assert
 */
public class ProductsTest extends TestCase {

    @Test
    public void testGetProductId() {
        // Arrange
        ProductIdSequencer.reset();
        // Act
        Products colazero33 = new Drinks
                ("Cola Zero Can", "-Carbonated water, cola flavour, no fat.", 18, 33, 0);
        Products cola50 = new Drinks
                ("Cola Bottle", "-Carbonated water, cola flavour, no fat.", 22, 50, 10);
        Products colazero50 = new Drinks
                ("Cola Zero Bottle", "-Carbonated water, cola flavour, no fat.", 22, 50, 0);
        // Assert
        assertEquals(101, colazero33.getProductId());
        assertEquals(103, colazero50.getProductId());
    }

    @Test
    public void testTestGetAndSetDescription() {
        // Arrange
        ProductIdSequencer.reset();
        // Act
        Products cola33 = new Drinks
                ("Cola Can", "-Carbonated water, cola flavour, no fat.", 18, 33, 10);
        String name1 = cola33.getDescription();
        cola33.setDescription("-Carbonated water, coke flavour, no fat.");
        String name2 = cola33.getDescription();
        // Assert
        assertEquals("-Carbonated water, cola flavour, no fat.", name1);
        assertEquals("-Carbonated water, coke flavour, no fat.", name2);
    }
}
