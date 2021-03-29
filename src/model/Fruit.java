package model;

import java.util.*;

public class Fruit extends Food{
    private boolean ripe;

    public Fruit(long id, String name, double price, int stock,
                long barcode, boolean specialEdition, String brand,
                boolean ripe) {
        super(id, name, price, stock, barcode, specialEdition, brand);
        this.ripe = ripe;
    }

    public Fruit(){}

    public boolean isRipe() {
        return ripe;
    }

    public void setRipe(boolean ripe) {
        this.ripe = ripe;
    }

    @Override
    public String toString(){
        return super.toString() + " / " + ripe;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return name.equals(fruit.getName());
    }

    @Override
    public int hashCode() {return Objects.hash(name);}
}
