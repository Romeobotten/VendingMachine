package se.lexicon.romeobot.models;

import junit.framework.TestCase;
import org.junit.Test;
import se.lexicon.romeobot.Data.ProductIdSequencer;
/**
 * Arrange
 * Act
 * Assert
 */
public class ChocolateBarsTest extends TestCase {

    @Test
    public void testSetAndGetWeight() {
        // Arrange
        ProductIdSequencer.reset();
        // Act
        ChocolateBars snickers200 = new ChocolateBars // Cheating to get it to work
                ("Snickers Big", "-28% fat, 45% sugar, 22% peanuts. Chocolate-",
                        18, 200, 22);
        int before = snickers200.getWeight();
        snickers200.setWeight(100);
        // Assert
        assertEquals(200, before);
        assertEquals(100, snickers200.getWeight());
    }

    @Test
    public void testSetAndGetName() {
        // Arrange
        ProductIdSequencer.reset();
        // Act
        Products snickers200 = new ChocolateBars
                ("Snickers Big", "-28% fat, 45% sugar, 22% peanuts. Chocolate-",
                        18, 200, 22);
        snickers200.setName("Snickers Double");
        // Assert
        assertEquals("Snickers Double", snickers200.getName());
    }

    @Test
    public void testExamine() {
        // Arrange
        ProductIdSequencer.reset();
        // Act
        Products snickers200 = new ChocolateBars
                ("Snickers Big", "-28% fat, 45% sugar, 22% peanuts. Chocolate-",
                        18, 200, 22);
        Products mars60 = new ChocolateBars
                ("Mars Small", "-22% fat, 55% sugar, 18% caramel. Chocolate-",
                        10, 60,28);
        Products mars200 = new ChocolateBars
                ("Mars Big", "-22% fat, 55% sugar, 18% caramel. Chocolate-",
                        18, 200, 28);
        // Assert
        assertEquals("103, Price: 18 Kr. -Mars Big            Weight: 200 g.  -22% fat, 55% sugar, 18% caramel. Chocolate-28% chocolate. Eat it!", mars200.examine());
    }
}