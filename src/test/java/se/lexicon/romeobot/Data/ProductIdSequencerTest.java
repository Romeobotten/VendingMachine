package se.lexicon.romeobot.Data;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ProductIdSequencerTest {
    /**
     * We are only going to do the basic tests, K I S S
     * Arrange
     * Act
     * Assert
     */

    @Test
    public void TestProductIdSequencer() {
        // Arrange
        ProductIdSequencer.reset();
        // Act
        int productId101 = ProductIdSequencer.nextProductId();
        int productId102 = ProductIdSequencer.nextProductId();
        ProductIdSequencer.reset();
        int productId103 = ProductIdSequencer.nextProductId();
        // Assert
        assertTrue((productId101 == 101) && (productId102 == 102) && (productId103 == 101));
    }
}