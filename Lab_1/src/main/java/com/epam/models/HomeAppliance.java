package com.epam.models;

public class HomeAppliance extends ElectricalAppliance {

    private HomeApplianceType homeApplianceType;

    public HomeAppliance(String applianceName, String brand, int powerConsumption, int yearProduction, boolean turnOn
            , HomeApplianceType homeApplianceType) {
        super(applianceName, brand, powerConsumption, yearProduction, turnOn);
        this.homeApplianceType = homeApplianceType;
    }

    public HomeApplianceType getHomeApplianceType() {
        return homeApplianceType;
    }

    public void setHomeApplianceType(HomeApplianceType homeApplianceType) {
        this.homeApplianceType = homeApplianceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HomeAppliance)) return false;
        if (!super.equals(o)) return false;

        HomeAppliance that = (HomeAppliance) o;

        return homeApplianceType == that.homeApplianceType;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (homeApplianceType != null ? homeApplianceType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\nHomeAppliance {" + super.toString() +
                "homeApplianceType= " + homeApplianceType +
                '}';
    }
}
