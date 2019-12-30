package by.trjava.task01.chekun.model.entity;

public class Laptop extends Appliance {

    private String OS;

    private int systemMemory;

    private double CPU;

    public Laptop() {

    }

    public Laptop(int id, double batteryCapacity, String OS, int memoryRom, int systemMemory, double CPU, double displayInches) {
        super(id, "Laptop");

        this.batteryCapacity = batteryCapacity;
        this.OS = OS;
        this.memoryRom = memoryRom;
        this.systemMemory = systemMemory;
        this.CPU = CPU;
        this.displayInchs = displayInches;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public int getSystemMemory() {
        return systemMemory;
    }

    public void setSystemMemory(int systemMemory) {
        this.systemMemory = systemMemory;
    }

    public double getCPU() {
        return CPU;
    }

    public void setCPU(double CPU) {
        this.CPU = CPU;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Laptop laptop = (Laptop) obj;

        return Double.compare(batteryCapacity, laptop.batteryCapacity) == 0
                && (OS == laptop.OS) || (OS != null && OS.equalsIgnoreCase(laptop.OS))
                && memoryRom == laptop.memoryRom
                && systemMemory == laptop.systemMemory
                && Double.compare(CPU, laptop.CPU) == 0
                && Double.compare(displayInchs, laptop.displayInchs) == 0;

    }

    @Override
    public int hashCode() {
        return (int) (31 * batteryCapacity + memoryRom + systemMemory + CPU + displayInchs
                + ((OS != null) ? 0 : OS.hashCode()));
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" +
                "id:" + id +
                " name:" + name +
                " batteryCapacity:" + batteryCapacity +
                " OS:" + OS +
                " memoryRom:" + memoryRom +
                " systemMemory:" + systemMemory +
                " CPU:" + CPU +
                " displayInchs:" + displayInchs;
    }
}
