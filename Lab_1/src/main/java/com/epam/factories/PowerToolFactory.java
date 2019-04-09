package com.epam.factories;

import com.epam.models.ElectricalAppliance;
import com.epam.models.PowerToolType;
import com.epam.models.PowerTool;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PowerToolFactory implements Factories {
    private PowerToolFactory(){
    }

    private static class PowerToolSingletonHolder {
        private final static PowerToolFactory INSTANCE = new PowerToolFactory();
    }

    public static PowerToolFactory getInstance () {
        return PowerToolSingletonHolder.INSTANCE;
    }

    @Override
    public ElectricalAppliance createFactory(String applianceName, String brand, int powerConsumption, int yearProduction
            , boolean turnOn, String inputType) {
        return new PowerTool(applianceName, brand, powerConsumption, yearProduction, turnOn
                , PowerToolType.valueOf(inputType.toUpperCase()));
    }

    @Override
    public ElectricalAppliance create(ResultSet rs) throws SQLException {
        String type = rs.getString("appliance_name");
        String brand = rs.getString("brand");
        int powerConsumption = rs.getInt("power_watt");
        int yearProduction = rs.getInt("production_year");
        boolean turnOn = rs.getBoolean("turned_on");
        String inputType = rs.getString("appliance_type");
        return new PowerTool(type, brand, powerConsumption, yearProduction, turnOn
                , PowerToolType.valueOf(inputType.toUpperCase()));
    }
}
