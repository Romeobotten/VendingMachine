package se.lexicon.romeobot.models;

import junit.framework.TestCase;
import org.junit.Test;
import se.lexicon.romeobot.Data.ProductIdSequencer;

public class NutsTest extends TestCase {

    @Test
    public void testSetAndGetName() {
        // Arrange
        ProductIdSequencer.reset();
        // Act
        Products walnut150 = new Nuts
                ("Walnuts Sm Natural", "-60% fat, 15% carbon hydrates, 15% protein.",
                        24, 150, false);
        walnut150.setName("Walnuts Nat.");
        // Assert
        assertEquals("Walnuts Nat.", walnut150.getName());
    }

    @Test
    public void testExamine() {

        // Arrange
        ProductIdSequencer.reset();
        // Act
        Products walnut150 = new Nuts
                ("Walnuts Sm Natural", "-60% fat, 15% carbon hydrates, 15% protein.",
                        24, 150, false);
        Products peanuts500 = new Nuts
                ("Peanuts Big", "-50% fat, 20% carbon hydrates, 25% protein.",
                        20, 500, true);
        Products cashew500 = new Nuts
                ("Cashewnuts Big", "-50% fat, 25% carbon hydrates, 20% protein.",
                        45, 500, true);
        // Assertq
        assertEquals("103, Price: 45 Kr. -Cashewnuts Big      Weight: 500 g.  -50% fat, 25% carbon hydrates, 20% protein. Salted.  Eat it!", cashew500.examine());
    }
}