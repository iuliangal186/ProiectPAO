package model;

public class Phone extends Product{
    private float screen;
    private String brand;
    private Battery battery;

    public Phone(long id, String name, double price, int stock, float screen, String brand, Battery battery){
        super(id, name, price, stock);
        this.screen = screen;
        this.brand = brand;
        this.battery = battery;
    }

    public float getScreen() {
        return screen;
    }

    public void setScreen(float screen) {
        this.screen = screen;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    @Override
    public String toString(){
        return super.toString() + " / " + screen + " / " + brand + " / " + battery.getType() + " / " + battery.getCapacity()
                + " / " + battery.getVoltage();
    }
}
