package com.epam.factories;

import com.epam.models.ElectricalAppliance;
import com.epam.models.HomeApplianceType;
import com.epam.models.HomeAppliance;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HomeApplianceFactory implements Factories {
    private HomeApplianceFactory(){
    }

    private static class HomeApplianceSingletonHolder {
        private final static HomeApplianceFactory INSTANCE = new HomeApplianceFactory();
    }

    public static HomeApplianceFactory getInstance () {
        return HomeApplianceSingletonHolder.INSTANCE;
    }

    @Override
    public ElectricalAppliance createFactory(String applianceName, String brand, int powerConsumption, int yearProduction
            , boolean turnOn, String inputType) {
        return new HomeAppliance(applianceName, brand, powerConsumption, yearProduction, turnOn
                , HomeApplianceType.valueOf(inputType.toUpperCase()));
    }

    @Override
    public ElectricalAppliance create(ResultSet rs) throws SQLException {
        String type = rs.getString("appliance_name");
        String brand = rs.getString("brand");
        int powerConsumption = rs.getInt("power_watt");
        int yearProduction = rs.getInt("production_year");
        boolean turnOn = rs.getBoolean("turned_on");
        String inputType = rs.getString("appliance_type");
        return new HomeAppliance(type, brand, powerConsumption, yearProduction, turnOn
                , HomeApplianceType.valueOf(inputType.toUpperCase()));
    }
}
