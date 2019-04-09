package com.epam.factories;

import com.epam.models.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LargeHomeApplianceFactory implements Factories {
    private LargeHomeApplianceFactory(){
    }

    private static class LargeHomeApplianceSingletonHolder {
        private final static LargeHomeApplianceFactory INSTANCE = new LargeHomeApplianceFactory();
    }

    public static LargeHomeApplianceFactory getInstance () {
        return LargeHomeApplianceSingletonHolder.INSTANCE;
    }

    @Override
    public ElectricalAppliance createFactory(String applianceName, String brand, int powerConsumption, int yearProduction
            , boolean turnOn, String inputType) {
        return new LargeHomeAppliance(applianceName, brand,powerConsumption, yearProduction, turnOn
                , LargeHomeApplianceType.valueOf(inputType.toUpperCase()));    }

    @Override
    public ElectricalAppliance create(ResultSet rs) throws SQLException {
        String type = rs.getString("appliance_name");
        String brand = rs.getString("brand");
        int powerConsumption = rs.getInt("power_watt");
        int yearProduction = rs.getInt("production_year");
        boolean turnOn = rs.getBoolean("turned_on");
        String inputType = rs.getString("appliance_type");
        return new LargeHomeAppliance(type, brand,powerConsumption, yearProduction, turnOn
                , LargeHomeApplianceType.valueOf(inputType.toUpperCase()));
    }
}
