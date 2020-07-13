package se.lexicon.romeobot;

import junit.framework.TestCase;
import org.junit.Test;
/**
 * Arrange
 * Act
 * Assert
 */
public class JunkFoodMachineTest extends TestCase {

    @Test
    public void testAddCurrencyAndGetBalance() {
        // Arrange
        JunkFoodMachine myMachine = new JunkFoodMachine();
        // Act
        myMachine.addCurrency(100);
        myMachine.addCurrency(50);
        myMachine.addCurrency(25);
        // Assert
        assertTrue(150 == myMachine.getBalance());
    }

    @Test
    public void testEndSession() {
        // Arrange
        JunkFoodMachine myMachine = new JunkFoodMachine();
        // Act
        myMachine.addCurrency(200);
        myMachine.addCurrency(10);
        myMachine.endSession();
        // Assert
        assertTrue(myMachine.getBalance() == 0);
    }

    @Test
    public void testRequestAndGetDescription() {
        // Arrange
        JunkFoodMachine myMachine = new JunkFoodMachine();
        // Act
        String description1 = myMachine.request(101).getDescription();
        String description2 = myMachine.request(111).getDescription();
        // Assert
        assertEquals(myMachine.getDescription(101), description1);
        assertEquals(myMachine.getDescription(111), description2);
    }
}