package se.lexicon.romeobot.models;

public class ChocolateBars extends Products {

    private int weight;
    private int chocolatePercent;

    public ChocolateBars(String name, String description, int price, int weight, int chocolatePercent) {
        super(name, description, price);
        this.weight = weight;
        this.chocolatePercent = chocolatePercent;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getChocolatePercent() {
        return chocolatePercent;
    }

    public void setChocolatePercent(int chocolatePercent) {
        this.chocolatePercent = chocolatePercent;
    }

    @Override
    public String examine() {
        String info = getProductId() + ", Price: " + getPrice() + " Kr. -" + getName();

        for (int i = 0; i < 20 - getName().length(); i++) {
            info = info + " ";
        }
        info = info + "Weight: " + getWeight() + " g.  " + getDescription();
        info = info + getChocolatePercent() + "% chocolate.";
        info = info + use();
        return info;
    }
}
