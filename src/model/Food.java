package model;

public abstract class Food extends Product{
    protected long barcode;
    protected boolean specialEdition;
    protected String brand;

    public Food(long id, String name, double price, int stock,
                long barcode, boolean specialEdition, String brand){
        super(id, name, price, stock);
        this.barcode = barcode;
        this.specialEdition = specialEdition;
        this.brand = brand;
    }

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public boolean isSpecialEdition() {
        return specialEdition;
    }

    public void setSpecialEdition(boolean specialEdition) {
        this.specialEdition = specialEdition;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
