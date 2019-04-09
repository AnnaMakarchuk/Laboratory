package com.epam.factories;

public class ElectricalApplianceFactory {

    private static LargeHomeApplianceFactory largeHomeApplianceFactory = LargeHomeApplianceFactory.getInstance();
    private static HomeApplianceFactory homeApplianceFactory = HomeApplianceFactory.getInstance();
    private static PowerToolFactory powerToolFactory = PowerToolFactory.getInstance();
    private static MultiMediaFactory multiMediaFactory = MultiMediaFactory.getInstance();

    public static Factories createTechnique(ElectricalAppliancesType type){
        switch (type){
            case LARGEHOMEAPPLIANCE:
                return largeHomeApplianceFactory;
            case HOMEAPPLIANCE:
                return homeApplianceFactory;
            case POWERTOOL:
                return powerToolFactory;
            case MULTIMEDIA:
                return multiMediaFactory;
        }
        throw new IllegalArgumentException();
    }

    public static Factories createTechnique(String type) {
        return createTechnique(ElectricalAppliancesType.valueOf(type.toUpperCase()));
    }
}
