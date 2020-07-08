package se.lexicon.romeobot.Data;

public class ProductIdSequencer {
    private static int productId = 100;

    public static int nextProductId() {
        productId ++;
        return productId;
    }
    public static void reset() {
        productId = 100;
    }
}
