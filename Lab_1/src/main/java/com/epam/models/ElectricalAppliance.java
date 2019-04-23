package com.epam.models;

public class ElectricalAppliance {

    private String applianceName;
    private String brand;
    private int powerConsumption;
    private int yearProduction;
    private boolean turnOn;

    public ElectricalAppliance(String applianceName, String brand, int powerConsumption, int yearProduction, boolean turnOn) {
        this.applianceName = applianceName;
        this.brand = brand;
        this.powerConsumption = powerConsumption;
        this.yearProduction = yearProduction;
        this.turnOn = turnOn;
    }

    public String getApplianceName() {
        return applianceName;
    }

    public void setApplianceName(String applianceName) {
        this.applianceName = applianceName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getYearProduction() {
        return yearProduction;
    }

    public void setYearProduction(int yearProduction) {
        this.yearProduction = yearProduction;
    }

    public boolean isTurnOn() {
        return turnOn;
    }

    public void setTurnOn(boolean turnOn) {
        this.turnOn = turnOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ElectricalAppliance)) return false;

        ElectricalAppliance that = (ElectricalAppliance) o;

        if (Double.compare(that.powerConsumption, powerConsumption) != 0) return false;
        if (yearProduction != that.yearProduction) return false;
        if (applianceName != null ? !applianceName.equals(that.applianceName) : that.applianceName != null)
            return false;
        return brand != null ? brand.equals(that.brand) : that.brand == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = applianceName != null ? applianceName.hashCode() : 0;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        temp = Double.doubleToLongBits(powerConsumption);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + yearProduction;
        return result;
    }

    @Override
    public String toString() {
        return "applianceName= " + applianceName +
                ", brand= " + brand +
                ", powerConsumption, watt= " + powerConsumption +
                ", yearProduction= " + yearProduction +
                ", turnOn= " + turnOn +
                ", ";
    }
}
