package se.lexicon.romeobot.models;

public class Drinks extends Products {
    private int volume;
    private int sugarPercent;
    private boolean sugarFree;

    public Drinks(String name, String description, int price, int volume, int sugarPercent) {
        super(name, description, price);
        this.volume = volume;
        this.sugarPercent = sugarPercent;
        if (sugarPercent == 0) {
            this.sugarFree = true;
        }
        else {
            this.sugarFree = false;
        }
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getSugarPercent() {
        return sugarPercent;
    }

    public void setSugarPercent(int sugarPercent) {
        this.sugarPercent = sugarPercent;
        if (sugarPercent == 0) {
            this.sugarFree = true;
        }
        else {
            this.sugarFree = false;
        }
    }

    public boolean isSugarFree() {
        return sugarFree;
    }

    @Override
    public String examine() {
        return "Info: nr " + getProductId() + " " + getName() + " Declaration: " + getDescription() +
                " sugar: " +getSugarPercent() + "% sugar." + use();
    }
    @Override
    String use(){
        return " Drink it!";
    }
}
