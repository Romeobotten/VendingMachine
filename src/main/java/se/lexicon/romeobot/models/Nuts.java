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
        return "Info: nr " + getProductId() + " " + getName() + " Declaration: " + getDescription() +
                " Weight: " + getWeight () + " gram."+ use();
    }
}
