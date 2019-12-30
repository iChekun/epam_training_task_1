package by.trjava.task01.chekun.model.entity;

public abstract class Appliance {

    protected int id;

    protected String name;

    protected double powerConsumption;

    protected double weight;

    protected double height;

    protected double width;

    protected double batteryCapacity;

    protected double displayInchs;

    protected int memoryRom;

    public Appliance() { }

    public Appliance(int id, String name) {
        this.id = id;
        this.name = name + id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public double getDisplayInchs() {
        return displayInchs;
    }

    public void setDisplayInchs(double displayInchs) {
        this.displayInchs = displayInchs;
    }

    public int getMemoryRom() {
        return memoryRom;
    }

    public void setMemoryRom(int memoryRom) {
        this.memoryRom = memoryRom;
    }
}