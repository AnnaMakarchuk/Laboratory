package com.epam.models;

public class PowerTool extends ElectricalAppliance {

    private PowerToolType powerToolType;

    public PowerTool(String applianceName, String brand, int powerConsumption, int yearProduction, boolean turnOn,
                     PowerToolType powerToolType) {
        super(applianceName, brand, powerConsumption, yearProduction, turnOn);
        this.powerToolType = powerToolType;
    }

    public PowerToolType getPowerToolType() {
        return powerToolType;
    }

    public void setPowerToolType(PowerToolType powerToolType) {
        this.powerToolType = powerToolType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PowerTool)) return false;
        if (!super.equals(o)) return false;

        PowerTool powerTool = (PowerTool) o;

        return powerToolType == powerTool.powerToolType;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (powerToolType != null ? powerToolType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\nPowerTool {" + super.toString() +
                "powerToolType= " + powerToolType +
                '}';
    }
}
