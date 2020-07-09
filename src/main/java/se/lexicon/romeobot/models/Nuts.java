package se.lexicon.romeobot.models;

public class Nuts extends Products {
    private int weight;
    private boolean salted;

    public Nuts(String name, String description, int price, int weight, boolean salted) {
        super(name, description, price);
        this.weight = weight;
        this.salted = salted;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isSalted() {
        return salted;
    }

    public void setSalted(boolean salted) {
        this.salted = salted;
    }

    @Override
    public String examine() {
        String info = getProductId() + ", Price: " + getPrice() + " Kr. -" + getName();

        for (int i = 0; i < 20 - getName().length(); i++) {
            info = info + " ";
        }
        info = info + "Weight: " + getWeight() + " g.  " + getDescription();
        if (isSalted()) {
            info = info + " Salted. ";
        } else {
            info = info + " NO salt!";
        }
        info = info + use();
        return info;
    }
}
