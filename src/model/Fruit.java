package model;

public class Fruit extends Food{
    private boolean ripe;

    public Fruit(long id, String name, double price, int stock,
                long barcode, boolean specialEdition, String brand,
                boolean ripe) {
        super(id, name, price, stock, barcode, specialEdition, brand);
        this.ripe = ripe;
    }

    public boolean isRipe() {
        return ripe;
    }

    public void setRipe(boolean ripe) {
        this.ripe = ripe;
    }
}
