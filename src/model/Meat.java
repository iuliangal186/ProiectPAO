package model;

public class Meat extends Food {
    private int daysToExpiration;
    private double weight;

    public Meat(long id, String name, double price, int stock,
                long barcode, boolean specialEdition, String brand,
                int daysToExpiration, double weight) {
        super(id, name, price, stock, barcode, specialEdition, brand);
        this.daysToExpiration = daysToExpiration;
        this.weight = weight;
    }

    public int getDaysToExpiration() {
        return daysToExpiration;
    }

    public void setDaysToExpiration(int daysToExpiration) {
        this.daysToExpiration = daysToExpiration;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
