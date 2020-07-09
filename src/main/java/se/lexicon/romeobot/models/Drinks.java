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
        String info = getProductId() + ", Price: " +getPrice() +" Kr. -" + getName();
        for (int i = 0; i < 20 - getName().length(); i++) {
            info = info + " ";
        }
        info = info + "Volume: " + getVolume() + " cl.  " + getDescription();
        if (isSugarFree()) {
            info = info + " NO sugar!  ";
        } else{
            info = info + " " + getSugarPercent() + "% sugar. ";
                    use();
        }
        info = info + use();
        return info;
    }
    @Override
    String use(){
        return "Drink it!";
    }
}
