package com.epam.models;

public class LargeHomeAppliance extends ElectricalAppliance {

    private LargeHomeApplianceType largeHomeApplianceType;

    public LargeHomeAppliance(String applianceName, String brand, int powerConsumption, int yearProduction, boolean turnOn
            , LargeHomeApplianceType largeHomeApplianceType) {
        super(applianceName, brand, powerConsumption, yearProduction, turnOn);
        this.largeHomeApplianceType = largeHomeApplianceType;
    }

    public LargeHomeApplianceType getLargeHomeApplianceType() {
        return largeHomeApplianceType;
    }

    public void setLargeHomeApplianceType(LargeHomeApplianceType largeHomeApplianceType) {
        this.largeHomeApplianceType = largeHomeApplianceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LargeHomeAppliance)) return false;
        if (!super.equals(o)) return false;

        LargeHomeAppliance that = (LargeHomeAppliance) o;

        return largeHomeApplianceType == that.largeHomeApplianceType;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (largeHomeApplianceType != null ? largeHomeApplianceType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\nLargeHomeAppliance {" + super.toString() +
                "largeHomeApplianceType= " + largeHomeApplianceType +
                '}';
    }
}
