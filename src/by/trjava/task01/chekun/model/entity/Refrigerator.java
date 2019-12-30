package by.trjava.task01.chekun.model.entity;

public class Refrigerator extends Appliance {


    private double overallCapacity;

    private int freezerCapacity;


    public Refrigerator() {
    }

    public Refrigerator(int id, double powerConsumption, double weight, int freezerCapacity, double overallCapacity, double height, double width) {
        super(id, "Refrigerator");

        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.freezerCapacity = freezerCapacity;
        this.overallCapacity = overallCapacity;
        this.height = height;
        this.width = width;
    }


    public double getOverallCapacity() {
        return overallCapacity;
    }

    public void setOverallCapacity(double overallCapacity) {
        this.overallCapacity = overallCapacity;
    }

    public int getFreezerCapacity() {
        return freezerCapacity;
    }

    public void setFreezerCapacity(int freezerCapacity) {
        this.freezerCapacity = freezerCapacity;
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
        Refrigerator refrigerator = (Refrigerator) obj;

        return Double.compare(powerConsumption, refrigerator.powerConsumption) == 0
                && Double.compare(weight, refrigerator.weight) == 0
                && freezerCapacity == refrigerator.freezerCapacity
                && Double.compare(overallCapacity, refrigerator.overallCapacity) == 0
                && Double.compare(height, refrigerator.height) == 0
                && Double.compare(width, refrigerator.width) == 0;
    }

    @Override
    public int hashCode() {
        return (int) (31 * powerConsumption + weight + freezerCapacity + overallCapacity + height + weight);
    }


    @Override
    public String toString() {
        return getClass().getName() + "@" +
                "id:" + id +
                " name:" + name +
                " powerConsumption:" + powerConsumption +
                " weight:" + weight +
                " freezerCapacity:" + freezerCapacity +
                " overallCapacity:" + overallCapacity +
                " height:" + height +
                " width:" + width;
    }
}
