package model;

public class Clothes extends Product{
    protected String brand;
    protected String season;

    public Clothes(long id, String name, double price, int stock,
                String brand, String season) {
        super(id, name, price, stock);
        this.season = season;
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    @Override
    public String toString(){
        return super.toString() + " / " + brand + " / " + season;
    }


}
