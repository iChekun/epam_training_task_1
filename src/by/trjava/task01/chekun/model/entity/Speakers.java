package by.trjava.task01.chekun.model.entity;

public class Speakers extends Appliance {

    private int numberOfSpeakers;

    private String frequencyRange;

    private double cordLenght;

    public Speakers() {
    }

    public Speakers(int id, double powerConsumption, int numberOfSpeakers, String frequencyRange, double cordLenght) {
        super(id, "Speakers");

        this.powerConsumption = powerConsumption;
        this.numberOfSpeakers = numberOfSpeakers;
        this.frequencyRange = frequencyRange;
        this.cordLenght = cordLenght;
    }


    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(int numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public String getFrequencyRange() {
        return frequencyRange;
    }

    public void setFrequencyRange(String frequencyRange) {
        this.frequencyRange = frequencyRange;
    }

    public double getCordLenght() {
        return cordLenght;
    }

    public void setCordLenght(double cordLenght) {
        this.cordLenght = cordLenght;
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
        Speakers speakers = (Speakers) obj;

        return numberOfSpeakers == speakers.numberOfSpeakers
                && (frequencyRange == speakers.frequencyRange) || (frequencyRange != null && frequencyRange.equals(speakers.frequencyRange))
                && Double.compare(powerConsumption, speakers.powerConsumption) == 0
                && Double.compare(cordLenght, speakers.cordLenght) == 0;
    }

    @Override
    public int hashCode() {
        return (int) (31 * numberOfSpeakers + cordLenght + powerConsumption + ((frequencyRange != null) ? 0 : frequencyRange.hashCode()));
    }

    @Override
    public String toString() {
        return getClass().getName() + "@"
                + "id:" + id
                + " name:" + name
                + " numberOfSpeakers:" + numberOfSpeakers
                + " powerConsumption:" + powerConsumption
                + " frequencyRange:" + frequencyRange
                + " cordLenght:" + cordLenght;
    }
}
