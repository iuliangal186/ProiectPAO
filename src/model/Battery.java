package model;

public class Battery {
    private String type;
    private int capacity;
    private int voltage;

    public Battery(String type, int capacity, int voltage){
        this.type = type;
        this.capacity = capacity;
        this.voltage = voltage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }
}
