package com.epam.factories;

import com.epam.models.ElectricalAppliance;
import com.epam.models.Multimedia;
import com.epam.models.MultimediaType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MultiMediaFactory implements Factories {
    private MultiMediaFactory(){
    }

    private static class MultiMediaSingletonHolder {
        private final static MultiMediaFactory INSTANCE = new MultiMediaFactory();
    }

    public static MultiMediaFactory getInstance () {
        return MultiMediaSingletonHolder.INSTANCE;
    }

    @Override
    public ElectricalAppliance createFactory(String applianceName, String brand, int powerConsumption, int yearProduction
            , boolean turnOn, String inputType) {
        return new Multimedia(applianceName, brand, powerConsumption, yearProduction, turnOn
                , MultimediaType.valueOf(inputType.toUpperCase()));
    }

    @Override
    public ElectricalAppliance create(ResultSet rs) throws SQLException {
        String type = rs.getString("appliance_name");
        String brand = rs.getString("brand");
        int powerConsumption = rs.getInt("power_watt");
        int yearProduction = rs.getInt("production_year");
        boolean turnOn = rs.getBoolean("turned_on");
        String inputType = rs.getString("appliance_type");
        return new Multimedia(type, brand, powerConsumption, yearProduction, turnOn
                , MultimediaType.valueOf(inputType.toUpperCase()));
    }
}
