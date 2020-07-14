package se.lexicon.romeobot;

import junit.framework.TestCase;
import org.junit.Test;
import se.lexicon.romeobot.Data.ProductIdSequencer;

/**
 * Arrange
 * Act
 * Assert
 */
public class JunkFoodMachineTest extends TestCase {

    @Test
    public void testGetProducts() {
        // Arrange
        JunkFoodMachine myMachine = new JunkFoodMachine();
        // Act
        String test1 = myMachine.getProducts('d')[1];
        String test2 = myMachine.getProducts('n')[1];
        String test3 = myMachine.getProducts('c')[1];
        String test4 = myMachine.getProducts()[1];
        String test5 = myMachine.getProducts()[8];
        String test6 = myMachine.getProducts()[14];
        // Assert
        assertEquals(test1, test4);

        assertEquals(test2, test5);
        assertEquals(test3, test6);
        assertNotSame(test2, test4);
        assertNotSame(test3, test4);
    }

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
        myMachine.addCurrency(300);
        myMachine.addCurrency(4);
        myMachine.addCurrency(10);
        int before = myMachine.getBalance();
        myMachine.endSession();
        // Assert
        assertTrue(before == 210);
        assertTrue(myMachine.getBalance() == 0);
    }

    @Test
    public void testRequestAndGetDescription() {
        // Arrange
        ProductIdSequencer.reset();
        JunkFoodMachine myMachine = new JunkFoodMachine();
        // Act
        String description1 = myMachine.request(101).getDescription();
        String description2 = myMachine.request(111).getDescription();
        // Assert
        assertEquals(myMachine.getDescription(101), description1);
        assertEquals(myMachine.getDescription(111), description2);
        assertNull(myMachine.getDescription(121));
    }
}