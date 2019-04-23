package com.epam.factories;

import com.epam.models.ElectricalAppliance;
import com.epam.models.HomeApplianceType;
import com.epam.models.HomeAppliance;
import com.epam.utils.ColumnNames;
import com.epam.utils.ResultSetFields;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HomeApplianceFactory implements Factories {

    private HomeApplianceFactory() {
    }

    private static class HomeApplianceSingletonHolder {
        private final static HomeApplianceFactory INSTANCE = new HomeApplianceFactory();
    }

    public static HomeApplianceFactory getInstance() {
        return HomeApplianceSingletonHolder.INSTANCE;
    }

    @Override
    public ElectricalAppliance createFactory(String applianceName, String brand, int powerConsumption,
                                             int yearProduction, boolean turnOn, String inputType) {
        return new HomeAppliance(applianceName, brand, powerConsumption, yearProduction, turnOn,
                getHomeApplianceType(inputType));
    }

    @Override
    public ElectricalAppliance create(ResultSet resultSet) throws SQLException {
        String type = ResultSetFields.getStringByName(ColumnNames.APPLIANCE_NAME, resultSet);
        String brand = ResultSetFields.getStringByName(ColumnNames.BRAND, resultSet);
        int powerConsumption = ResultSetFields.getIntByName(ColumnNames.POWER_WATT, resultSet);
        int yearProduction = ResultSetFields.getIntByName(ColumnNames.PRODUCTION_YEAR, resultSet);
        boolean turnOn = ResultSetFields.getBooleanByName(ColumnNames.TURNED_ON, resultSet);
        String inputType = ResultSetFields.getStringByName(ColumnNames.APPLIANCE_TYPE, resultSet);
        return new HomeAppliance(type, brand, powerConsumption, yearProduction, turnOn,
                getHomeApplianceType(inputType));
    }

    private HomeApplianceType getHomeApplianceType(String inputType) {
        return HomeApplianceType.valueOf(inputType.toUpperCase());
    }
}
