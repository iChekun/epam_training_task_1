package by.trjava.task01.chekun.model.entity;

public class TabletPC extends Appliance {

    private int flashMemoryCapacity;

    private String color;

    public TabletPC() {

    }

    public TabletPC(int id, double batteryCapacity, double displayInchs, int memoryRom, int flashMemoryCapacity, String color) {
        super(id, "TabletPC");

        this.flashMemoryCapacity = flashMemoryCapacity;
        this.batteryCapacity = batteryCapacity;
        this.displayInchs = displayInchs;
        this.memoryRom = memoryRom;
        this.color = color;
    }

    public int getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    public void setFlashMemoryCapacity(int flashMemoryCapacity) {
        this.flashMemoryCapacity = flashMemoryCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

        TabletPC tabletPC = (TabletPC) obj;

        return Double.compare(batteryCapacity, tabletPC.batteryCapacity) == 0
                && Double.compare(displayInchs, tabletPC.displayInchs) == 0
                && memoryRom == tabletPC.memoryRom
                && flashMemoryCapacity == tabletPC.flashMemoryCapacity
                && (color == tabletPC.color) || (color != null && color.equalsIgnoreCase(tabletPC.color));
    }

    @Override
    public int hashCode() {
        return (int) (31 * batteryCapacity + displayInchs + memoryRom + flashMemoryCapacity + ((color != null) ? 0 : color.hashCode()));
    }

    @Override
    public String toString() {
        return getClass().getName() + "@"
                + "id:" + id
                + " name:" + name
                + " batteryCapacity:" + batteryCapacity
                + " displayInchs:" + displayInchs
                + " memoryRom:" + memoryRom
                + " flashMemoryCapacity:" + flashMemoryCapacity
                + " color:" + color;
    }
}
