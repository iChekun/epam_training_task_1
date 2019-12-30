package by.trjava.task01.chekun.model.entity;


public class Oven extends Appliance {

    private int capacity;

    private double depth;

    public Oven() {

    }

    public Oven(int id, double powerConsumption, double weight, int capacity, double depth, double height, double width) {
        super(id,"Oven");

        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.capacity = capacity;
        this.depth = depth;
        this.height = height;
        this.width = width;
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
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

        Oven oven = (Oven) obj;

        return Double.compare(powerConsumption, oven.powerConsumption) == 0
                && Double.compare(weight, oven.weight) == 0
                && capacity == oven.capacity
                && Double.compare(depth, oven.depth) == 0
                && Double.compare(height, oven.height) == 0
                && Double.compare(width, oven.width) == 0;

    }

    @Override
    public int hashCode() {
        return (int) (31 * powerConsumption + weight + capacity + depth + height + width);
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" +
                "id:" + id +
                " name:" + name +
                " powerConsumption:" + powerConsumption +
                " weight:" + weight +
                " capacity:" + capacity +
                " depth:" + depth +
                " height:" + height +
                " width:" + width;
    }
}
