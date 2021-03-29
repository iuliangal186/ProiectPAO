package model;

public class Milk extends Food{
    private int daysToExpiration;
    private double volume;

    public Milk(long id, String name, double price, int stock,
                long barcode, boolean specialEdition, String brand,
                int daysToExpiration, double volume) {
        super(id, name, price, stock, barcode, specialEdition, brand);
        this.daysToExpiration = daysToExpiration;
        this.volume = volume;
    }

    public int getDaysToExpiration() {
        return daysToExpiration;
    }

    public void setDaysToExpiration(int daysToExpiration) {
        this.daysToExpiration = daysToExpiration;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString(){
        return super.toString() + " / " + daysToExpiration + " / " + volume;
    }
}
