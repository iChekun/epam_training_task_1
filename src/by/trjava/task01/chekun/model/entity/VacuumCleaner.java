package by.trjava.task01.chekun.model.entity;

public class VacuumCleaner extends Appliance {

    private String filterType;

    private String bagType;

    private String wandType;

    private double motorSpeedRegulation;

    private double cleaningWidth;

    public VacuumCleaner() {
    }

    public VacuumCleaner(int id, double powerConsumption, String filterType, String bagType, String wandType, double motorSpeedRegulation, double cleaningWidth) {
        super(id, "VacuumCleaner");

        this.powerConsumption = powerConsumption;
        this.filterType = filterType;
        this.bagType = bagType;
        this.wandType = wandType;
        this.motorSpeedRegulation = motorSpeedRegulation;
        this.cleaningWidth = cleaningWidth;
    }

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public String getBagType() {
        return bagType;
    }

    public void setBagType(String bagType) {
        this.bagType = bagType;
    }

    public String getWandType() {
        return wandType;
    }

    public void setWandType(String wandType) {
        this.wandType = wandType;
    }

    public double getMotorSpeedRegulation() {
        return motorSpeedRegulation;
    }

    public void setMotorSpeedRegulation(double motorSpeedRegulation) {
        this.motorSpeedRegulation = motorSpeedRegulation;
    }

    public double getCleaningWidth() {
        return cleaningWidth;
    }

    public void setCleaningWidth(double cleaningWidth) {
        this.cleaningWidth = cleaningWidth;
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

        VacuumCleaner vacuumCleaner = (VacuumCleaner) obj;

        return Double.compare(powerConsumption, vacuumCleaner.powerConsumption) == 0
                && (filterType == vacuumCleaner.filterType) || (filterType != null && filterType.equals(vacuumCleaner.filterType))
                && (bagType == vacuumCleaner.bagType) || (bagType != null && bagType.equals(vacuumCleaner.bagType))
                && (wandType == vacuumCleaner.wandType) || (wandType != null && wandType.equals(vacuumCleaner.wandType))
                && Double.compare(motorSpeedRegulation, vacuumCleaner.motorSpeedRegulation) == 0
                && Double.compare(cleaningWidth, vacuumCleaner.cleaningWidth) == 0;
    }

    @Override
    public int hashCode() {
        return (int) (31 * powerConsumption + motorSpeedRegulation + cleaningWidth
                + ((filterType != null) ? 0 : filterType.hashCode())
                + ((bagType != null) ? 0 : bagType.hashCode())
                + ((wandType != null) ? 0 : wandType.hashCode()));
    }

    @Override
    public String toString() {
        return getClass().getName() + "@"
                + "id:" + id
                + " name:" + name
                + " powerConsumption:" + powerConsumption
                + " motorSpeedRegulation:" + motorSpeedRegulation
                + " cleaningWidth:" + cleaningWidth
                + " filterType:" + filterType
                + " bagType:" + bagType
                + " wandType:" + wandType;
    }
}
